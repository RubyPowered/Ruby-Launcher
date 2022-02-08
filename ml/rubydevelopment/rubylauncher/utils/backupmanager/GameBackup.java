package ml.rubydevelopment.rubylauncher.utils.backupmanager;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import ml.rubydevelopment.rubylauncher.modules.BackupManagerGui;

public class GameBackup extends Thread{

	private final String pathToGameFolder = System.getProperty("user.home")+"\\AppData\\Roaming\\.minecraft";
	
	private final String newZipFolder = System.getProperty("user.home")+"\\Desktop\\MCGameBackup.mcgamefiles";
	
	public void run() {
		try {
			this.zipFolder(Paths.get(pathToGameFolder),Paths.get(newZipFolder));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public void zipFolder(Path sourceFolderPath, Path zipPath) throws Exception {
		 BackupManagerGui.done.setForeground(Color.red);
		 BackupManagerGui.done.setText("Working...");
		 BackupManagerGui.done.setForeground(Color.red);
		 BackupManagerGui.done.setText("Working...");
	        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath.toFile()));
	        Files.walkFileTree(sourceFolderPath, new SimpleFileVisitor<Path>() {
	            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
	                zos.putNextEntry(new ZipEntry(sourceFolderPath.relativize(file).toString()));
	                Files.copy(file, zos);
	                zos.closeEntry();
	                return FileVisitResult.CONTINUE;
	            }
	        });
	        zos.close();
	        BackupManagerGui.done.setForeground(Color.green);
	        BackupManagerGui.done.setText("Done!");
	        BackupManagerGui.done.setForeground(Color.green);
	        BackupManagerGui.done.setText("Done!");
	    }
	
}
