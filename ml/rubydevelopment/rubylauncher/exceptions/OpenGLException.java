package ml.rubydevelopment.rubylauncher.exceptions;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class OpenGLException extends Throwable{

	public static void test() throws OpenGLException {
		throw new OpenGLException();

	}
	
	public OpenGLException() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Your GPU drivers are out of date and do not support the latest version of LWJGL OpenGL.\n Visit aka.ms/mcdriver or rubylauncher.net/drivers for assistance.", "GPU Error", JOptionPane.ERROR_MESSAGE);
		
	}
	
}
