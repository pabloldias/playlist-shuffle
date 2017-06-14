package br.com.pabloldias.api;

import java.util.Properties;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.HttpManager;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.methods.authentication.ClientCredentialsGrantRequest;
import com.wrapper.spotify.models.ClientCredentials;

public class Authenticator {

	private static final String CLIENT_ID = "clientId";
	private static final String CLIENT_SECRET = "clientSecret";
	private static final String USER_ID = "userId";
	
	private Api api;
	private String accessToken;
	private Properties properties;

	public Authenticator(Properties properties) {
		this.properties = properties;
		authenticate();
	}

	private void authenticate() {

		try {

			api = Api.builder()
					.clientId(properties.getProperty(CLIENT_ID))
					.clientSecret(properties.getProperty(CLIENT_SECRET))
					.build();

			HttpManager httpManager = SpotifyHttpManager.builder().build();

			final ClientCredentialsGrantRequest clientCredentialsGrantRequest = api.clientCredentialsGrant()
					.httpManager(httpManager).build();

			ClientCredentials clientCredentials = clientCredentialsGrantRequest.get();
			accessToken = clientCredentials.getAccessToken();
			api.setAccessToken(accessToken);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Api getApi() {
		return api;
	}
	
	public String getAccessToken() {
		return accessToken;
	}

	public String getUserId() {
		// TODO Auto-generated method stub
		return properties.getProperty(USER_ID);
	}

}
