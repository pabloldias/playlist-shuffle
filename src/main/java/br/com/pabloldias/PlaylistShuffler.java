package br.com.pabloldias;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.HttpManager;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.methods.PlaylistRequest;
import com.wrapper.spotify.methods.UserPlaylistsRequest;
import com.wrapper.spotify.methods.authentication.ClientCredentialsGrantRequest;
import com.wrapper.spotify.models.ClientCredentials;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.Playlist;
import com.wrapper.spotify.models.SimplePlaylist;

public class PlaylistShuffler {

	private static final String CLIENT_ID = "clientId";
	private static final String CLIENT_SECRET = "clientSecret";
	private static final String USER_ID = "userId";

	private final int portion = 10;
	
	private Api api;
	private String userId;
	private String accessToken;

	public void shuffle() {
		authenticate();
		listPlaylists();
	}

	private void authenticate() {
		Properties properties = getProperties();
		userId = properties.getProperty(USER_ID);
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
	
	private void listPlaylists() {
		try {
			UserPlaylistsRequest.Builder playlistBuilder = api.getPlaylistsForUser(userId);

			UserPlaylistsRequest userPlaylistsRequest = playlistBuilder.accessToken(accessToken)
					.limit(portion).build();

			int offset = 0;

			System.out.println(String.format("Getting playlists for user: '%s'", userId));
			boolean isLastPage = false;
			while (!isLastPage) {
				Page<SimplePlaylist> simplePlaylistPage = userPlaylistsRequest.get();
				List<SimplePlaylist> simplePlaylists = simplePlaylistPage.getItems();
				for (SimplePlaylist simplePlaylist : simplePlaylists) {
					String playListId = simplePlaylist.getId();

					PlaylistRequest playlistRequest = api
							.getPlaylist(simplePlaylist.getOwner().getId(), playListId)
							.build();
					try {
						System.out.println(String.format("Getting playlist with name '%s' owner: '%s' (%s)",
								simplePlaylist.getName(), 
								simplePlaylist.getOwner().getId(),
								simplePlaylist.getId()));
						//Playlist playlist = playlistRequest.get();
					} catch (Exception e) {
						// suppress
					}
				}
				if (simplePlaylists.size() < portion) {
					isLastPage = true;
				} else {
					offset += portion;
					userPlaylistsRequest = api.getPlaylistsForUser(userId)
							.accessToken(accessToken)
							.limit(portion).offset(offset).build();
				}
			}
		} catch (IOException | WebApiException e) {
			e.printStackTrace();
		}
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
