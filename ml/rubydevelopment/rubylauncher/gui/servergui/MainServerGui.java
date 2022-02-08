package ml.rubydevelopment.rubylauncher.gui.servergui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

import ml.rubydevelopment.rubylauncher.modules.BackupManagerGui;
import ml.rubydevelopment.rubylauncher.utils.files.FileCreaterAndDownloader;
import ml.rubydevelopment.rubylauncher.utils.font.FontFactory;
import ml.rubydevelopment.rubylauncher.utils.server.ServerDownloader;

public class MainServerGui extends JFrame{

	public static String wantedServerVersion;
	
	private String[] versionSelection = {"1.17.1", "1.17", "1.16.5", "1.16.4", "1.16.3", "1.16.2", "1.16.1", "1.16", "1.15.2", "1.15.1", "1.15", "1.14.4", "1.14.3", "1.14.2", "1.14.1", "1.14", "1.13.2", "1.13.1", "1.13", "1.12.2", "1.12.1", "1.12", "1.11.2", "1.11.1", "1.11", "1.10.2", "1.10", "1.9.4", "1.9.2", "1.9", "1.8.8", "1.7.10"};
	
	//Window icon
	ImageIcon icon = new ImageIcon(FileCreaterAndDownloader.images+"\\favicon.png");
	
	//Swing JComponents
	JLabel logo = new JLabel("Ruby Development Server Manager");
	JPanel p = new JPanel();
	JLabel so = new JLabel("Server Output:");
		
	JLabel config = new JLabel("Configuration");
	
	//Buttons
	JButton download = new JButton("Download");
	
	private JComboBox versions = new JComboBox(versionSelection);
	
	public static TextArea serverOutput = new TextArea();
	
	public MainServerGui() {
		super("Ruby Development Server Manager");
		this.setVisible(true);
		this.setDefaultCloseOperation(1);
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setIconImage(icon.getImage());
		
		
		p.setVisible(true);
		p.setSize(getWidth(), getHeight());
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		
		logo.setBounds(50,10,390,30);
		logo.setVisible(true);
		logo.setFont(FontFactory.createEmptyFont("Arial", FontFactory.PLAIN, 24));
		
		serverOutput.setVisible(true);
		serverOutput.setBounds(175, 75, 300, 250);
		
		serverOutput.setEditable(false);
		serverOutput.append("Your server output will appear here and in the other GUI window that will open\n");
		//serverOutput.setFont(FontFactory.createEmptyFont("Arial", FontFactory.PLAIN, 12));
		
		so.setBounds(175,50,100,20);
		so.setVisible(true);
		//so.setFont(FontFactory.createEmptyFont("Arial", FontFactory.PLAIN, 24));
		
		config.setBounds(10,50 ,100,20);
		config.setVisible(true);
		
		versions.setVisible(true);
		versions.setBounds(10, 75, 150, 20);
		
		download.setBounds(10, 105, 150, 20);
		download.setVisible(true);
		download.setFocusable(false);
		download.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					wantedServerVersion = versions.getSelectedItem().toString();
					System.out.println(wantedServerVersion);
					ServerDownloader.checkExistance(versions.getSelectedItem().toString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		this.add(p);
		
		p.add(logo);
		p.add(so);
		p.add(serverOutput);
		p.add(versions);
		p.add(config);
		p.add(download);
	}
	
	public static void append(String tzt) {
		serverOutput.append(tzt+"\n");
	}
	
}
