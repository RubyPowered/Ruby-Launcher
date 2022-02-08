package ml.rubydevelopment.rubylauncher.gui.startup;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ml.rubydevelopment.rubylauncher.gui.GuiMainWindow;
import ml.rubydevelopment.rubylauncher.utils.files.FileCreaterAndDownloader;
import ml.rubydevelopment.rubylauncher.utils.font.FontFactory;
import ml.rubydevelopment.rubylauncher.utils.server.ServerDownloader;

public class SplashScreen extends JFrame{

	private JPanel p = new JPanel();
	private JPanel help = new JPanel();
	
	JLabel loading = new JLabel();
	JLabel title = new JLabel("Special thanks to:");
	JLabel contrib1 = new JLabel("JackRoxxxx");
	JLabel contrib2 = new JLabel("Litarvan");
	JLabel contrib3 = new JLabel("chris54721");
	JLabel contrib4 = new JLabel("Kronos666");
	JLabel rubyicon = new JLabel();
	JLabel status = new JLabel();
	
	
	String img = "LauncherLogo.png";
	ImageIcon ruby = new ImageIcon(this.getClass().getResource(img));
	
	ImageIcon icon = new ImageIcon(FileCreaterAndDownloader.images+"\\favicon.png");
	
	JButton skip = new JButton("Skip");
	
	public SplashScreen() throws Exception {
		super("Starting launcher Ruby Development http://rubydevelopment.ml/");
		System.out.println("Starting splash screen...");
		this.setVisible(true);
		this.setSize(600,500);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setIconImage(icon.getImage());
		
		p.setVisible(true);
		p.setSize(getWidth(), getHeight());
		p.setLayout(null);
		
		help.setVisible(true);
		help.setBounds(0, 0, 200, this.getHeight());
		help.setLayout(null);
		help.setBackground(new Color(220,220,220));
		
		title.setVisible(true);
		title.setBounds(10, 0, 200, 50);
		
		contrib1.setVisible(true);
		contrib1.setBounds(10, 55, 200, 10);
		
		contrib2.setVisible(true);
		contrib2.setBounds(10, 70, 200, 10);
		
		contrib3.setVisible(true);
		contrib3.setBounds(10, 85, 200, 10);
		
		contrib4.setVisible(true);
		contrib4.setBounds(10, 100, 200, 10);
		
		rubyicon.setVisible(true);
		rubyicon.setBounds(200, -10, 500, 200);
		rubyicon.setIcon(ruby);
		
		status.setVisible(true);
		status.setBounds(280, 400, 200, 20);
		status.setForeground(Color.blue);
		status.setFont(FontFactory.createEmptyFont("Arial", FontFactory.PLAIN, 16));
		status.setBorder(BorderFactory.createLineBorder(Color.green, 1, true));
		
		loading.setVisible(true);
		loading.setBounds(325, 250, 200, 30);
		//loading.setForeground(Color.green);
		loading.setFont(FontFactory.createEmptyFont("Arial", FontFactory.PLAIN, 24));
		
		skip.setBounds(320, 325, 100, 20);
		skip.setVisible(true);
		skip.setFocusable(false);
		skip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					exit();
					GuiMainWindow.init();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		this.add(p);
		p.add(help);
		p.add(rubyicon);
		p.add(status);
		p.add(loading);
		
		help.add(title);
		help.add(contrib1);
		help.add(contrib2);
		help.add(contrib3);
		help.add(contrib4);
		
		//p.add(skip);
		
		status.setText("http://rubydevelopment.ml/");
		status.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("http://rubydevelopment.ml/java/RubyLauncher.html"));
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		SwingUtilities.updateComponentTreeUI(p);
		
		for(int i=0;i<6;i++) {
			loading.setText("Loading.");
			Thread.sleep(500);
			loading.setText("Loading..");
			Thread.sleep(500);
			loading.setText("Loading...");
			Thread.sleep(500);
		}
		Thread.sleep(1000);
		this.exit();
		GuiMainWindow.init();
		
		
	}
	public static void init() {
		try {
			new SplashScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void exit() {
		this.dispose();
	}
	
}
