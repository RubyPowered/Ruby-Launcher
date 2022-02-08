package ml.rubydevelopment.rubylauncher.security;

public class TokenSystem {

	private String accessToken;
	private String refreshToken;
	
	public void saveTokens(String refreshToken, String accessToken) {
		
	}
	public String[] getTokens() {
		String[] tokens = {"ommited", "ommited"};
		return tokens;
	}
	public static TokenSystem getSystemTokenSystem(int mode) {
		return new TokenSystem();
	}
	private void loginWithRefreshToken() {
		
	}
	
}
