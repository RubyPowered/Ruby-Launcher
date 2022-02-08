package ml.rubydevelopment.rubylauncher.gui;

import javax.swing.*;

import java.awt.Color;

public class MainForm{
	
	String img = "logo.png";
	ImageIcon logoI = new ImageIcon(this.getClass().getResource(img));
	
	JLabel logo = new JLabel();
	
	public static JPanel p = new JPanel();
	
	public MainForm() {
		p.setSize(800,450);
		p.setVisible(true);
		p.setLayout(null);
		p.setBackground(new Color(232,229,231));
		
		logo.setBounds(10,-120,400,400);
		logo.setIcon(logoI);
		
		p.add(logo);
	}
	
}
