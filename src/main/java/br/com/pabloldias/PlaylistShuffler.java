package br.com.pabloldias;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.HttpManager;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.methods.UserPlaylistsRequest;
import com.wrapper.spotify.methods.authentication.ClientCredentialsGrantRequest;
import com.wrapper.spotify.models.ClientCredentials;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.SimplePlaylist;

public class PlaylistShuffler {

	private static final String CLIENT_ID = "clientId";
	private static final String CLIENT_SECRET = "clientSecret";
	private static final String USER_ID = "userId";
	private static final String PLAYLIST_NAME = "playlistName";
	
	private Api api;
	private String userId;
	private String accessToken;
	private Object playlistName;

	public void shuffle() {
		authenticate();
		Optional<SimplePlaylist> playlist = findPlaylist();
		if (playlist.isPresent()) {
			SimplePlaylist newPlaylist = copyPlaylist(playlist.get());
			shufflePlaylist(newPlaylist);
		}
	}

	private void authenticate() {
		Properties properties = getProperties();
		userId = properties.getProperty(USER_ID);
		playlistName = properties.getProperty(PLAYLIST_NAME);
		buildApi(properties);
	}
	
	private void buildApi(Properties properties) {
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
	
	private Optional<SimplePlaylist> findPlaylist() {
		UserPlaylistsRequest.Builder playlistBuilder = api.getPlaylistsForUser(userId);
		UserPlaylistsRequest userPlaylistsRequest = playlistBuilder.accessToken(accessToken).build();
		Page<SimplePlaylist> playlistsPage = new Page<>();
		try {
			playlistsPage = userPlaylistsRequest.get();
		} catch (IOException | WebApiException e) {
			e.printStackTrace();
		}

		for (SimplePlaylist playlist : playlistsPage.getItems()) {
			if (playlistName.equals(playlist.getName())) {
				return Optional.of(playlist);
			}
		}

		return Optional.empty();
	}
	
	private SimplePlaylist copyPlaylist(SimplePlaylist playlist) {
		System.out.println(playlist.getId());
		return null;
	}
	
	private void shufflePlaylist(SimplePlaylist newPlaylist) {
		// TODO Auto-generated method stub
	}

	private Properties getProperties() {
		String authFile = "auth.properties";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();
		try (InputStream resourceStream = loader.getResourceAsStream(authFile)) {
			properties.load(resourceStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}
