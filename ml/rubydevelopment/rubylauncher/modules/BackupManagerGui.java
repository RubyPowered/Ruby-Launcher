package ml.rubydevelopment.rubylauncher.modules;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ml.rubydevelopment.rubylauncher.utils.backupmanager.GameBackup;
import ml.rubydevelopment.rubylauncher.utils.backupmanager.WorldBackup;
import ml.rubydevelopment.rubylauncher.utils.files.FileCreaterAndDownloader;
import ml.rubydevelopment.rubylauncher.utils.font.FontFactory;

@SuppressWarnings("serial")
public class BackupManagerGui extends JFrame{

	JPanel p = new JPanel();
	
	JButton backupGame = new JButton("Backup game");
	JButton backupSaves = new JButton("Backup worlds");
	JButton continueToLauncher = new JButton("Exit backup manager");
	
	private static JLabel backup = new JLabel("Backup Manager");
	public static JLabel done = new JLabel("Ready to work!");
	JLabel version = new JLabel("v1.2.1");
	
	ImageIcon icon = new ImageIcon(FileCreaterAndDownloader.images+"\\favicon.png");
	
	@SuppressWarnings("static-access")
	public BackupManagerGui() {
		super("Backup");
		this.setVisible(true);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setSize(200,230);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		//this.setAlwaysOnTop(true);
		this.setIconImage(icon.getImage());
		
		p.setVisible(true);
		p.setSize(getWidth(), getHeight());
		p.setLayout(null);
		//p.setBackground(Color.WHITE);
		
		backup.setVisible(true);
		backup.setFocusable(false);
		backup.setBounds(10, 5, 200, 30);
		backup.setFont(FontFactory.createEmptyFont("Aria;", FontFactory.PLAIN, 22));
		
		done.setVisible(true);
		done.setFocusable(false);
		done.setBounds(10, 140, 200, 30);
		done.setFont(FontFactory.createEmptyFont("Aria;", FontFactory.PLAIN, 24));
		
		version.setVisible(true);
		version.setFocusable(false);
		version.setBounds(5, 370, 50, 30);
		version.setFont(FontFactory.createEmptyFont("Aria;", FontFactory.PLAIN, 12));
		
		continueToLauncher.setVisible(true);
		continueToLauncher.setFocusable(false);
		continueToLauncher.setBounds(5, 100, 175, 20);
		continueToLauncher.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if(done.getText()=="Working...") {
					JOptionPane.showMessageDialog(null, "Please wait until the operation is done.\nWorking will change to done when it's done. ","Please wait", JOptionPane.WARNING_MESSAGE);
				}else {
				BackupManagerGui.super.dispose();
				}
			}
		});
		
		backupSaves.setVisible(true);
		backupSaves.setFocusable(false);
		backupSaves.setBounds(5, 70, 175, 20);
		backupSaves.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				new WorldBackup().start();
			}
		});
		
		backupGame.setVisible(true);
		backupGame.setFocusable(false);
		backupGame.setBounds(5, 40, 175, 20);
		backupGame.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				new GameBackup().start();
			}
		});
		
		this.add(p);
		
		p.add(backup);
		p.add(continueToLauncher);
		p.add(backupGame);
		p.add(backupSaves);
		p.add(done);
		p.add(version);
	}
	
	
	
	public static void startBackupManager() {
		new BackupManagerGui();
	}
	
	
}
