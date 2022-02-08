package ml.rubydevelopment.rubylauncher.gui.otherGuis;

import java.awt.TextArea;
import java.util.Date;

import ml.rubydevelopment.rubylauncher.gui.GuiMainWindow;
import ml.rubydevelopment.rubylauncher.utils.font.FontFactory;

@SuppressWarnings("serial")
public class Console{
	
	 public static TextArea area = new TextArea();
	
	public Console() {
		area.setSize(800, 450);
		area.setVisible(true);
		area.setFont(FontFactory.createEmptyFont("Aria;", FontFactory.PLAIN, 16));
		
		//Printing some info to the screen
		this.print("Ruby Launcher by Ruby Development copyright Ruby Development and JackRoxxxx 2022\n");
		//this.wait(5000);
		//this.print("Attempting to login with refresh token: ");
		area.setEditable(false);
		this.printfo();
	}
	
	public static Console getConsole() {
		return new Console();
	}
	
	
	public static void print(String text) {
			area.append(text+"\n");
		
	}
	public static void clear() {
		area.setText(null);
	}
	private static void printfo() {
		print("Welcome to Ruby Launcher version 1.0.0-18.0.3!");
		print("Come visit our website at: http://rubydevelopment.ml or http://rubydev.ml");
		print("Console started at: "+new Date().toString());
		
	}
	
	
}
