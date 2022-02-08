package ml.rubydevelopment.rubylauncher.utils.misc;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Images {

	public final ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("./assets/favicon.png"));
	
	public static Image getFavicon() {
		return new Images().icon.getImage();
	}
	
}
