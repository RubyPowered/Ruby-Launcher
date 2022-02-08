package ml.rubydevelopment.rubylauncher.gui.otherGuis;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.theshark34.openlauncherlib.util.ramselector.RamSelector;
import ml.rubydevelopment.rubylauncher.gui.GuiMainWindow;
import ml.rubydevelopment.rubylauncher.utils.font.FontFactory;
import ml.rubydevelopment.rubylauncher.utils.specs.Ram;

public class RamAmounts extends FontFactory{

	public static JTextField ram = new JTextField("1024");
	public static JCheckBox box = new JCheckBox("Override default ram options");
	public static JLabel options = new JLabel("Configuration");
	public static JLabel maxRam = new JLabel(" / "+Ram.getRam()+" GB");
	
	@SuppressWarnings("static-access")
	public RamAmounts() {
		
		
		ram.setVisible(true);
		ram.setBounds(5, 40, 100, 20);
		ram.setEnabled(true);
		
		maxRam.setVisible(true);
		maxRam.setBounds(120, 40, 100, 20);
		maxRam.setFont(FontFactory.createEmptyFont("Aria;", FontFactory.BOLD, 16));
		
		options.setVisible(true);
		options.setBounds(40, 0, 160, 30);
		options.setFont(this.createEmptyFont("Aria;", this.PLAIN, 20));
		
		box.setVisible(true);
		box.setBounds(5, 40, 190, 20);
		box.setFocusable(false);
		
		GuiMainWindow.addToSidePanel(maxRam);
		GuiMainWindow.addToSidePanel(options);
		GuiMainWindow.addToSidePanel(ram);
		
	}
	public static String getSelectedRam() {
		return ram.getText();
	}
}
