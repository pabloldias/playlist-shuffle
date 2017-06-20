package br.com.pabloldias.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.HttpManager;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.methods.authentication.ClientCredentialsGrantRequest;
import com.wrapper.spotify.models.ClientCredentials;

import br.com.pabloldias.AppProperties;

@Service
public class SpotifyService {

	@Autowired
	private AppProperties properties;
	
	public String getAuthorizeURL() {
		try {

			Api api = Api.builder()
					.clientId(properties.getClientId())
					.clientSecret(properties.getClientSecret())
					.redirectURI("http://localhost:8080/ok")
					.build();
			
			final List<String> scopes = Arrays.asList(
					"playlist-modify-public",
					"playlist-modify-private",
					"user-read-private", 
					"user-read-email",
					"user-library-modify",
					"playlist-read-private");

			HttpManager httpManager = SpotifyHttpManager.builder().build();

			final ClientCredentialsGrantRequest clientCredentialsGrantRequest = api.clientCredentialsGrant()
					.httpManager(httpManager).build();

			ClientCredentials clientCredentials = clientCredentialsGrantRequest.get();
			String accessToken = clientCredentials.getAccessToken();
			api.setAccessToken(accessToken);
			
			final String state = "3847hy87fy2qa1";
			String authorizeURL = api.createAuthorizeURL(scopes, state);
			System.out.println(authorizeURL);
			return authorizeURL;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
