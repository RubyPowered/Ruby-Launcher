package ml.rubydevelopment.rubylauncher.utils.updater;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ml.rubydevelopment.rubylauncher.gui.startup.SplashScreen;
import simpleDownloader.SimpleDownloader;

public class VersionChecker {

	private static final String INSTALLED_RUBY_VERSION = "1.0.0";
	private static final String INSTALLED_RUBY_BUILD = "12.0.3";
	private static final String INSTALLED_MINECRAFT_VERSION	= "1.17.2";
	//IO Stuff
	private static final File updaterFolder = new File(System.getProperty("user.dir")+"\\updater");
	private static final Properties properties = new Properties();
	
	private static boolean isOutdated = false;
	
	public void init() {
		if(!updaterFolder.exists()) {updaterFolder.mkdir();}
		SimpleDownloader.DownloadWithStatic("https://www.dropbox.com/s/v3n6k6r0p00hbbh/latest_version.version?dl=1", updaterFolder+"\\latest_version.version");
		this.checkVersion();
		
	}
	
	public void checkVersion()  {
	String latestRubyVersion;
	String latestRubyBuild;
	String latestMinecraftVersion;
	try {
	FileReader reader = new FileReader(updaterFolder.toString()+"\\latest_version.version");
	properties.load(reader);
	}catch(IOException e) {
		e.printStackTrace();
	}
	latestRubyVersion = properties.getProperty("latest-ruby-version");
	latestRubyBuild = properties.getProperty("latest-ruby-build");
	latestMinecraftVersion = properties.getProperty("latest-minecraft-version");
	
	System.out.println(latestRubyVersion);
	System.out.println(latestRubyBuild);
	System.out.println(latestMinecraftVersion);
	
	this.compare(latestRubyVersion, latestRubyBuild, latestMinecraftVersion);
	
	}
	
	private void compare(String latestRubyVersion, String latestRubyBuild, String latestMinecraftVersion) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(INSTALLED_RUBY_VERSION.equals(latestRubyVersion)) {
			System.out.println("Checked the ruby version and it is not outdated");
		}else {
			this.isOutdated = true;
			System.out.println("Checked the ruby version and it is outdated");
		}if(INSTALLED_RUBY_BUILD.equals(latestRubyBuild)) {
			System.out.println("Checked the ruby build and it is not outdated");
		}else {
			this.isOutdated = true;
			System.out.println("Checked the ruby build and it is outdated");
		}if(INSTALLED_MINECRAFT_VERSION.equals(latestMinecraftVersion)) {
			System.out.println("Checked the minecraft version and it is not outdated");
		}else {
			this.isOutdated = true;
			System.out.println("Checked the minecraft version and it is outdated");
		}
		
		
		System.out.println(VersionChecker.isOutdated);
		if(VersionChecker.isOutdated==true) {
			this.startUpdater();
			System.out.println("outdated!");
		}if(this.isOutdated==false) {
			try {
				SplashScreen.init();
				this.updaterFolder.delete();
			}catch(Exception e) {e.printStackTrace();}
		}
	}
	private void startUpdater() {
		ProcessBuilder builder  = new ProcessBuilder();
		JOptionPane.showMessageDialog(null, "Ruby Launcher has an update.\nThis update requires a reliable internet connection and at least 1GB of RAM.\nThe update will now automatically install.", "Update required", JOptionPane.INFORMATION_MESSAGE);
		SimpleDownloader.DownloadWithStatic("https://www.dropbox.com/s/g43od5wcdlavivf/RubyLauncherAU.exe?dl=1", this.updaterFolder+"\\RubyLauncherAU.exe");
		builder.command("cmd.exe", "/c", this.updaterFolder+"\\RubyLauncherAU.exe");
		try {
			builder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(-1);
	}
	
}
