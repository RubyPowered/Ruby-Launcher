package ml.rubydevelopment.rubylauncher.utils.login;

import javax.swing.JOptionPane;

import ml.rubydevelopment.rubylauncher.gui.otherGuis.Console;
import net.chris54721.openmcauthenticator.OpenMCAuthenticator;
import net.chris54721.openmcauthenticator.exceptions.AuthenticationUnavailableException;
import net.chris54721.openmcauthenticator.exceptions.InvalidCredentialsException;
import net.chris54721.openmcauthenticator.exceptions.RequestException;
import net.chris54721.openmcauthenticator.responses.AuthenticationResponse;
import net.chris54721.openmcauthenticator.responses.RefreshResponse;

public class LoginWithMoj {

	protected String clientToken = "";
	protected String accessToken = "";
	protected String username = "";
	protected String refreshToken = "";
	
	public void login(String email, String password){
		try {
		AuthenticationResponse authResponse = OpenMCAuthenticator.authenticate(email, password);
		this.clientToken = authResponse.getClientToken();
		this.accessToken = authResponse.getAccessToken();
		this.username = authResponse.getSelectedProfile().getName();
		}catch(RequestException | AuthenticationUnavailableException e) {
			JOptionPane.showMessageDialog(null, "Well there was an error, this could be because the authentication servers are down or\n your credentials are wrong!\n"+e, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			Console.print("Couldn't login! check email and password?");
		}
	}
	public void refresh(String oldaccessToken, String usedClientToken) throws Exception {
		RefreshResponse response = OpenMCAuthenticator.refresh(oldaccessToken, usedClientToken);
		this.clientToken = response.getClientToken();
		this.accessToken = response.getAccessToken();
		this.username = response.getSelectedProfile().getName();
	}
	public void logout(String username, String password) {
		
	}
	
	public static LoginWithMoj getInstance() {
		return new LoginWithMoj();
	}
	public String getClientToken() {
		return clientToken;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public String getUsername() {
		return username;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	
	
}
