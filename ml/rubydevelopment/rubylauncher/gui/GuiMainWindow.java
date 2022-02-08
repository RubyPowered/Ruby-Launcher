package ml.rubydevelopment.rubylauncher.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import ml.rubydevelopment.rubylauncher.gui.otherGuis.Console;
import ml.rubydevelopment.rubylauncher.gui.servergui.MainServerGui;
import ml.rubydevelopment.rubylauncher.modules.BackupManagerGui;
import ml.rubydevelopment.rubylauncher.utils.files.FileCreaterAndDownloader;
import ml.rubydevelopment.rubylauncher.utils.font.FontFactory;
import ml.rubydevelopment.rubylauncher.utils.gameRunner.StartGame;

@SuppressWarnings("serial")
public class GuiMainWindow extends JFrame{

	//Swing JComponents
	private static JPanel p = new JPanel();
	private static JPanel sp = new JPanel();
	private static JPanel sidePanel = new JPanel();
	private static JPanel contentPane = new JPanel();
	private static JTabbedPane pane = new JTabbedPane();
	
	//More Swing JComponents
	JButton backupManager = new JButton("Backup Manager");
	JButton launch = new JButton("Enter the game");
	JButton gameManager = new JButton("Force update");
	JButton servers = new JButton("Server Options");
	JButton clear = new JButton("Clear");
	
	ImageIcon icon = new ImageIcon(FileCreaterAndDownloader.images+"\\favicon.png");
	
	public GuiMainWindow() {
		super("Ruby Development Ruby Launcher http://rubydevelopment.ml/");
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setSize(1000,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setIconImage(icon.getImage());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});
		
		p.setVisible(true);
		p.setSize(getWidth(), getHeight());
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		
		pane.setVisible(true);
		pane.setBounds(0,0,800,450);
		
		contentPane.setVisible(true);
		contentPane.setSize(800,450);
		contentPane.setLayout(null);
		//contentPane.setBackground(Color.green);
		
		sp.setVisible(true);
		sp.setBounds(0, 450, this.getWidth(), 150);
		sp.setLayout(null);
		sp.setBackground(new Color(102,199,255));
		
		sidePanel.setVisible(true);
		sidePanel.setBounds(800, 0, 200, 450);
		sidePanel.setLayout(null);
		sidePanel.setBackground(new Color(102,199,255));
		
		backupManager.setVisible(true);
		backupManager.setFocusable(false);
		backupManager.setBounds(770, 20, 200, 35);
		backupManager.setFont(FontFactory.createEmptyFont("Aria;", FontFactory.PLAIN, 16));
		backupManager.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BackupManagerGui.startBackupManager();
			}
		});
		
		gameManager.setVisible(true);
		gameManager.setFocusable(false);
		gameManager.setBounds(770, 60, 200, 35);
		gameManager.setFont(FontFactory.createEmptyFont("Aria;", FontFactory.PLAIN, 16));
		
		launch.setVisible(true);
		launch.setFocusable(false);
		launch.setBounds(560, 20, 200, 75);
		launch.setFont(FontFactory.createEmptyFont("Aria;", FontFactory.PLAIN, 16));
		launch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StartGame();
			}
		});
		
		clear.setVisible(true);
		clear.setBounds(450, 70, 100, 20);
		clear.setBackground(Color.white);
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Console.clear();
			}
		});
		
		servers.setVisible(true);
		servers.setBounds(5,70,175,25);
		servers.setFocusable(false);
		servers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainServerGui();
			}
		});
		
		this.add(p);
		p.add(sp);
		p.add(sidePanel);
		p.add(pane);
		
		pane.addTab("Main", MainForm.p);
		pane.addTab("Console", Console.area);
		
		//Adding comps to second panel
		sp.add(backupManager);
		sp.add(launch);
		sp.add(gameManager);
		sp.add(clear);
		
		this.addToSidePanel(servers);
		
		SwingUtilities.updateComponentTreeUI(this);
		
	}
	public static void init() {
		new GuiMainWindow();
	}
	public static void addToMainPanel(JComponent comp) {
		p.add(comp);
		SwingUtilities.updateComponentTreeUI(p);
	}
	public static void addToBottomPanel(JComponent comp) {
		sp.add(comp);
		SwingUtilities.updateComponentTreeUI(sp);

	}
	public static void addToSidePanel(JComponent comp) {
		sidePanel.add(comp);
		SwingUtilities.updateComponentTreeUI(sidePanel);

	}
	public static void addToMainPanel(Component comp) {
		p.add(comp);
		SwingUtilities.updateComponentTreeUI(p);
	}
	public static void addToBottomPanel(Component comp) {
		sp.add(comp);
		SwingUtilities.updateComponentTreeUI(sp);

	}
	public static void addToSidePanel(Component comp) {
		sidePanel.add(comp);
		SwingUtilities.updateComponentTreeUI(sidePanel);

	}
	public static JTabbedPane getTabbedPane() {
		return pane;
	}
	
	
}
