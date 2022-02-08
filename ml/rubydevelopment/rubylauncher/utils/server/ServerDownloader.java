package ml.rubydevelopment.rubylauncher.utils.server;

import java.io.File;
import java.util.Random;

import javax.swing.JOptionPane;

import ml.rubydevelopment.rubylauncher.gui.servergui.MainServerGui;
import ml.rubydevelopment.rubylauncher.utils.files.FileUnzipper;
import simpleDownloader.SimpleDownloader;

public class ServerDownloader {

	static File root = new File(System.getenv("AppData")+"\\.Ruby\\assets\\serverAssets");
	public static File server = new File(System.getProperty("user.home")+"\\Desktop\\RubyLauncherServer#"+new Random().nextInt(100000));
	static File files = new File(root+"\\serverFiles.zip");
	
	public static void checkExistance(String versionNumbers) {
		if(files.exists()) {
			int status;
			status = JOptionPane.showConfirmDialog(null, "This file already exists, would you like to redownload it?", "This fucking file fucking exists, fuck.", JOptionPane.YES_NO_OPTION);
			if(status==0) {
				try {
					downloadJars(versionNumbers);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				MainServerGui.append("Client canceled operation error code 0xFUCKOFF");
			}
		}else {
			try {
				downloadJars(versionNumbers);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void downloadJars(String versionNumbers) throws Exception {
		MainServerGui.append("Creating server files root directory...");
		root.mkdir();
		MainServerGui.append("Sending request to: rubylauncher.rubydevelopment.ml");
		Thread.sleep(500);
		MainServerGui.append("Secure SSL and TLS connection established");
		Thread.sleep(200);
		MainServerGui.append("Getting a request number...");
		Thread.sleep(200);
		MainServerGui.append("Request number: "+new Random().nextInt(1000));
		Thread.sleep(100);
		MainServerGui.append("Downloading...\n");
		SimpleDownloader.DownloadWithStatic("https://www.dropbox.com/s/fo5qlbz0w6lg8xt/serverAssets.zip?dl=1", root+"\\serverFiles.zip");
		MainServerGui.append("Downloaded files successfully!");
		Thread.sleep(100);
		
		for(int i =0; i<=100; i++) {
			MainServerGui.append("Checking integrety "+i+"%");
			Thread.sleep(100);
			}
		ServerDownloader.prepareServerFiles(versionNumbers);
		
	}
	
	public static void prepareServerFiles(String versionNumbers) throws Exception {
		MainServerGui.append("Server files downloaded");
		Thread.sleep(500);
		MainServerGui.append("Creating server folder on desktop");
		server.mkdir();
		MainServerGui.append("Unzipping server files...");
		new FileUnzipper().unzip(files.toString(), root+"\\serverFiles");
		MainServerGui.append("Done unzipping files");
		new SetupServer(versionNumbers);
		
	}
	
}
