package ml.rubydevelopment.rubylauncher.utils.login;

import javax.swing.JOptionPane;

import fr.litarvan.openauth.Authenticator;
import fr.litarvan.openauth.microsoft.MicrosoftAuthResult;
import fr.litarvan.openauth.microsoft.MicrosoftAuthenticationException;
import fr.litarvan.openauth.microsoft.MicrosoftAuthenticator;
import ml.rubydevelopment.rubylauncher.gui.otherGuis.Console;

public class LoginWithLive {

	protected String refreshToken = "";
	protected String accessToken = "";
	protected String username = "";
	
	private MicrosoftAuthenticator authenticator = new MicrosoftAuthenticator();
	
	public void loginWithLive(String email, String password) {
		try {
			MicrosoftAuthResult result = authenticator.loginWithCredentials(email, password);
			this.setRefreshToken(result.getRefreshToken());
			this.setUsername(result.getProfile().getName());
			this.setAccessToken(result.getAccessToken());
		} catch (MicrosoftAuthenticationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Your email or password was incorrect, maybe you didn't migrate your account?"+"\n"+e);
		}
	}
	public void loginWithRefreshToken(String token) {
		try {
			MicrosoftAuthResult result = authenticator.loginWithRefreshToken(token);
			this.setRefreshToken(result.getRefreshToken());
			this.setUsername(result.getProfile().getName());
			this.setAccessToken(result.getAccessToken());
		} catch (MicrosoftAuthenticationException e) {
			Console.print("Couldn't login! check username and password?");
			e.printStackTrace();
		}
	}
	
	
	
	
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public static LoginWithLive getInstance() {
		return new LoginWithLive();
	}
	
}
