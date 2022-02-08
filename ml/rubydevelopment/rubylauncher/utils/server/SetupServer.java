package ml.rubydevelopment.rubylauncher.utils.server;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import ml.rubydevelopment.rubylauncher.gui.servergui.MainServerGui;

public class SetupServer {

	File jar;
	File eula = new File(System.getenv("AppData")+"\\.Ruby\\serverAssets\\eula.txt");
	
	public SetupServer(String jarName) {
		System.out.println("Starting file transfer");
		this.jar = new File("vanilla-"+jarName);
		System.out.println(jar);
		System.out.println(eula);
		
		Path  jars = Paths.get(jar.toString());
		Path license = Paths.get(eula.toString());
		
		Path endJars = Paths.get(ServerDownloader.server+"\\server.jar");
		Path endEula = Paths.get(ServerDownloader.server+"\\eula.txt");
		
		try {
		Files.move(jars, endJars);
		}catch(IOException e) {
			MainServerGui.append(e.toString());
		}
		try {
			Files.move(license, endEula);
			}catch(IOException e) {
				MainServerGui.append(e.toString());
			}
		
	}
	
}
