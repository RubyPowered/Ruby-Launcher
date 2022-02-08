package ml.rubydevelopment.rubylauncher.gui.otherGuis;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import ml.rubydevelopment.rubylauncher.gui.GuiMainWindow;

public class Selectors {

	private String[] modloaders = {"Vanilla", "FML Tweaker", "Fabric", "LiteLoader", "Injection ModLoader", "Risugami's ModLoader"};
	private String[] versionSelection = {"1.17.1", "1.17", "1.16.5", "1.16.4", "1.16.3", "1.16.2", "1.16.1", "1.16", "1.15.2", "1.15.1", "1.15", "1.14.4", "1.14.3", "1.14.2", "1.14.1", "1.14", "1.13.2", "1.13.1", "1.13", "1.12.2", "1.12.1", "1.12", "1.11.2", "1.11.1", "1.11", "1.10.2", "1.10.1", "1.10", "1.9.4", "1.9.3", "1.9.2", "1.9.1", "1.9", "1.8.9", "1.8.8", "1.8.7", "1.8.6", "1.8.5", "1.8.4", "1.8.3", "1.8.2", "1.8.1", "1.8", "1.7.10", "1.7.9", "1.7.8","1.7.7","1.7.6","1.7.5","1.7.4","1.7.3","1.7.2","1.6.4", "1.6.2", "1.6.1", "1.5.2", "1.5.1", "1.4.7", "1.4.6", "1.4.5", "1.4.2", "1.3.2", "1.3.1", "1.2.5", "1.2.4", "1.2.3", "1.2.2", "1.2.1", "1.1", "1.0"};
	private String[] shadersLoaders = {"Optifine Ultra HD", "Injection Shaders", "The Loader"};
	
	private JComboBox versions = new JComboBox(versionSelection);
	private JComboBox modloader = new JComboBox(modloaders);
	private JComboBox shaders = new JComboBox(shadersLoaders);
	
	public Selectors() {
		versions.setVisible(true);
		versions.setBounds(450,20,100,20);
		versions.setBorder(BorderFactory.createLineBorder(null, 0, true));
		
		modloader.setVisible(true);
		modloader.setBounds(450,45,100,20);
		modloader.setBorder(BorderFactory.createLineBorder(null, 0, true));
		modloader.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "You can look at this but changing it will have no effect, we haven't finished it yet", "Error", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		shaders.setVisible(true);
		shaders.setBounds(450,70,100,20);
		shaders.setBorder(BorderFactory.createLineBorder(null, 0, true));
		
		GuiMainWindow.addToBottomPanel(versions);
		GuiMainWindow.addToBottomPanel(modloader);
		//GuiMainWindow.addToBottomPanel(shaders);
		
	}
	
}
