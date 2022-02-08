package ml.rubydevelopment.rubylauncher.utils.files;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import simpleDownloader.SimpleDownloader;

public class FileCreaterAndDownloader {

	public static File roaming = new File(System.getProperty("user.home")+"\\AppData\\Roaming");
	public static File mainRubyFolder = new File(roaming.toString()+"\\.Ruby");
	public static File MainAssetDir = new File(mainRubyFolder.toString()+"\\assets");
	public static File images = new File(MainAssetDir.toString()+"\\images");
	
	private SimpleDownloader downloader = new SimpleDownloader();
	
	public FileCreaterAndDownloader() {
		//This is basically a big file factory
		//A ton of if statements
		
		System.out.println(roaming);
		System.out.println(mainRubyFolder);
		System.out.println(MainAssetDir);
		System.out.println(images);
		
		this.mainRubyFolder.mkdir();
		this.MainAssetDir.mkdir();
		this.images.mkdir();
		
		try {
		downloader.Download("https://www.dropbox.com/s/vea5k8xm32uyyp2/favicon.png?dl=1", this.images.toString()+"\\favicon.png");
		downloader.Download("https://www.dropbox.com/s/ppgb1xkspwefix5/ruby.png?dl=1", this.images.toString()+"\\ruby.png");
		}catch(Exception e) {
			try {
				e.printStackTrace();
			downloader.Download("https://www.dropbox.com/s/vea5k8xm32uyyp2/favicon.png?dl=1", this.images.toString()+"\\favicon.png");
			downloader.Download("https://www.dropbox.com/s/ppgb1xkspwefix5/ruby.png?dl=1", this.images.toString()+"\\ruby.png");
			}catch(Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Could not connect to Ruby Development file servers!\n Try restarting the launcher and check your internet connection and router.", "", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	

	
}
