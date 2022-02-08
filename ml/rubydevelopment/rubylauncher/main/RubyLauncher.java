package ml.rubydevelopment.rubylauncher.main;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.fusesource.jansi.AnsiConsole;

import ml.rubydevelopment.rubylauncher.exceptions.JavaException;
import ml.rubydevelopment.rubylauncher.gui.MainForm;
import ml.rubydevelopment.rubylauncher.gui.otherGuis.Console;
import ml.rubydevelopment.rubylauncher.gui.otherGuis.RamAmounts;
import ml.rubydevelopment.rubylauncher.gui.otherGuis.Selectors;
import ml.rubydevelopment.rubylauncher.gui.otherGuis.SignInSystem;
import ml.rubydevelopment.rubylauncher.gui.startup.SplashScreen;
import ml.rubydevelopment.rubylauncher.utils.files.FileCreaterAndDownloader;
import ml.rubydevelopment.rubylauncher.utils.files.MainFiles;
import ml.rubydevelopment.rubylauncher.utils.specs.Ram;

public class RubyLauncher { 
	
	/*
	 ***********COPYRIGHT NOTICE**********
	 * 
	 * copyright 2021 Ruby Development and(or) affiliates
	 * to use my code you have to follow the guidelines below!
	 * 
	 * **********LICENSE**********
	 * you CAN:
	 * use my code FOR PRIVATE USE ONLY
	 * publish it under the same license
	 * decompile my code
	 * mod my code
	 * use my code in any other program as long as you give me partial credit somewhere
	 * I don't care where
	 * you CANNOT:
	 * use my code for commercial or industrial use without a small royalty of $100USD 
	 * publish it under a different license(unless approved by me at: cayden.davis@outlook.com)
	 * share my decompiled code online
	 * take credit for my code
	 * use my services at rubydevelopment.ml without my approval(I will know, so don't do it!)
	 * mod it and make it closed source it has to be open!
	 * **********END OF LICENSE**********
	 */
	
	
	
	public static void main(String[] args){
		
		if(!System.getProperty("java.version").contains("17") || System.getProperty("java.version").contains("16")) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Your Java version is not up to date, some versions of Minecraft may not work correctly.", "Error", 0);
			RubyLauncher.launcherInit();
		}else{
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RubyLauncher.launcherInit();
		}
	}
	private static void launcherInit() {
		try {
			new FileCreaterAndDownloader();
			new Ram();
			new RamAmounts();
			MainFiles.dirTester();
			new Selectors();
			new SignInSystem();
			new Console();
			new MainForm();
			SplashScreen.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
