package ml.rubydevelopment.rubylauncher.gui.otherGuis;

import java.awt.Button;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import ml.rubydevelopment.rubylauncher.gui.GuiMainWindow;
import ml.rubydevelopment.rubylauncher.utils.login.LoginWithLive;
import ml.rubydevelopment.rubylauncher.utils.login.LoginWithMoj;

public class SignInSystem implements ActionListener{

	protected static String clientToken;
	protected static String accessToken;
	protected static String username;
	
	private Button login = new Button("Log in");
	private Button logout = new Button("Log out");
	private Button refresh = new Button("Refresh");
	
	private TextField userbox = new TextField("Email");
	private JPasswordField passbox = new JPasswordField("Password");
	
	private ButtonGroup group = new ButtonGroup();
	
	private JRadioButton live = new JRadioButton("Live");
	private JRadioButton moj = new JRadioButton("Mojang");
	private JRadioButton ruby = new JRadioButton("Ruby");
	private JRadioButton none = new JRadioButton("none");

	
	public SignInSystem() {
		group.add(live);
		group.add(moj);
		group.add(ruby);
		group.add(none);
		
		live.setVisible(true);
		live.setBounds(280,20,100,25);
		live.setBackground(Color.white);
		//live.setForeground(Color.white);
		live.setToolTipText("Authenticate with Xbox Live servers, use this if you have migrated your account!, bedrock accounts won't work");
		live.addActionListener(this);
		
		moj.setVisible(true);
		moj.setBounds(280,40,100,25);
		moj.setBackground(Color.white);
		//moj.setForeground(Color.white);
		moj.setToolTipText("Authenticate with mojang servers, requrires an email and password unless it is a legacy account if so "
				+ "it needs the username and password");
		moj.addActionListener(this);
		
		ruby.setVisible(true);
		ruby.setBounds(280,60,100,25);
		ruby.setBackground(Color.white);
		//ruby.setForeground(Color.white);
		ruby.setToolTipText("Authenticate with RubyDevelopment servers, coming soon!");
		ruby.addActionListener(this);
		
		none.setVisible(true);
		none.setBounds(280,80,100,25);
		none.setBackground(Color.white);
		//none.setForeground(Color.white);
		none.setToolTipText("Pretty much a cracked account doesn't require a password");
		none.addActionListener(this);
		
		login.setVisible(true);
		login.setBounds(390, 20, 50, 20);
		login.addActionListener(this);
		login.setBackground(Color.white);
		
		logout.setVisible(true);
		logout.setBounds(390, 45, 50, 20);
		logout.addActionListener(this);
		logout.setBackground(Color.white);
		
		refresh.setVisible(true);
		refresh.setBounds(390, 70, 50, 20);
		refresh.addActionListener(this);
		refresh.setBackground(Color.white);
		
		userbox.setVisible(true);
		userbox.setBounds(10, 20, 260, 20);
		
		passbox.setVisible(true);
		passbox.setBounds(10, 45, 260, 20);
		
		GuiMainWindow.addToBottomPanel(login);
		GuiMainWindow.addToBottomPanel(logout);
		//GuiMainWindow.addToBottomPanel(refresh);
		GuiMainWindow.addToBottomPanel(live);
		GuiMainWindow.addToBottomPanel(moj);
		GuiMainWindow.addToBottomPanel(ruby);
		GuiMainWindow.addToBottomPanel(none);
		GuiMainWindow.addToBottomPanel(userbox);
		GuiMainWindow.addToBottomPanel(passbox);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==refresh) {
			if(moj.isSelected()) {
				LoginWithMoj instance = LoginWithMoj.getInstance();
				try {
					instance.refresh(accessToken, clientToken);
					this.clientToken = instance.getClientToken();
					this.accessToken = instance.getAccessToken();
					this.username = instance.getUsername();
					Console.print("Succefully refreshed!");
					Console.print("Access token: "+accessToken);
					Console.print("Client token: "+clientToken);
					Console.print("Username: "+username);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(live.isSelected()) {
				
			}
		}
		if(e.getSource()==login) {
			if(moj.isSelected()) {
				try {
					Console.print("Attempting to login with Mojang...");
					LoginWithMoj instance = LoginWithMoj.getInstance();
					instance.login(userbox.getText(), passbox.getText());
					Console.clear();
					Console.print("Access token: "+instance.getAccessToken());
					Console.print("Client token: "+instance.getClientToken());
					Console.print("Username: "+instance.getUsername());

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
			if(live.isSelected()) {
				try {
					Console.print("Attempting to login with Xbox Live Services...");
					LoginWithLive.getInstance().loginWithLive(userbox.getText(), passbox.getText());
					Console.clear();
					Console.print("Access token: "+LoginWithLive.getInstance().getAccessToken());
					Console.print("Refresh token: "+LoginWithLive.getInstance().getRefreshToken());
					Console.print("Username: "+LoginWithLive.getInstance().getUsername());


				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource()==logout) {
			if(moj.isSelected()) {
				Console.print("Logging out...");
				LoginWithMoj.getInstance().logout(userbox.getText(), passbox.getPassword().toString());
				Console.print("Logged out successfully!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Console.clear();
			}
			if(live.isSelected()) {
				Console.print("Logging out...");
				LoginWithLive.getInstance();
				Console.print("Logged out successfully!");
			}
		}
	}
}
