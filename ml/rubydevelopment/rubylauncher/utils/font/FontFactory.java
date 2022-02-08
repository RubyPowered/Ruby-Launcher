package ml.rubydevelopment.rubylauncher.utils.font;

import java.awt.Font;

public class FontFactory {

	public static final int PLAIN = 0;
	public static final int BOLD = 1;
	public static final int ITALIC = 2;
	
	public static Font createEmptyFont(String font, int type, int size) {
		return new Font(font, type, size);
	}
}
	
	

