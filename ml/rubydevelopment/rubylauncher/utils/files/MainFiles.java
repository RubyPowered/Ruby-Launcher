package ml.rubydevelopment.rubylauncher.utils.files;

import java.io.File;

public class MainFiles {

	static String userDir = System.getProperty("user.home");
	
	static File mainGameDir = new File(userDir+"\\AppData\\Roaming\\.minecraft");
	static File mainGameBin = new File(userDir+"\\AppData\\Roaming\\.minecraft\\bin");
	static File mainGameLibDir = new File(userDir+"\\AppData\\Roaming\\.minecraft");
	
	public static void dirTester() {
		System.out.println(mainGameDir);
		
		
	}
	
}
