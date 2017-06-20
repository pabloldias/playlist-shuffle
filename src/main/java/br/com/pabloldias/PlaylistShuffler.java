package br.com.pabloldias;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.HttpManager;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.methods.PlaylistCreationRequest;
import com.wrapper.spotify.methods.UserPlaylistsRequest;
import com.wrapper.spotify.methods.authentication.ClientCredentialsGrantRequest;
import com.wrapper.spotify.models.ClientCredentials;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.Playlist;
import com.wrapper.spotify.models.SimplePlaylist;

@Component
public class PlaylistShuffler {
	
	private Api api;
	private String accessToken;
	private HttpManager httpManager;
	
	@Autowired
	private AppProperties properties;

	public void shuffle() {
		buildApi();
		Optional<SimplePlaylist> playlist = findPlaylist();
		if (playlist.isPresent()) {
			SimplePlaylist newPlaylist = copyPlaylist(playlist.get());
			shufflePlaylist(newPlaylist);
		}
	}
	
	private void buildApi() {
		try {

			api = Api.builder()
					.clientId(properties.getClientId())
					.clientSecret(properties.getClientSecret())
					.redirectURI("http://localhost:8081/redirect")
					.build();
			
			final List<String> scopes = Arrays.asList(
					"playlist-modify-public",
					"playlist-modify-private",
					"user-read-private", 
					"user-read-email",
					"user-library-modify",
					"playlist-read-private");

			httpManager = SpotifyHttpManager.builder().build();

			final ClientCredentialsGrantRequest clientCredentialsGrantRequest = api.clientCredentialsGrant()
					.httpManager(httpManager).build();

			ClientCredentials clientCredentials = clientCredentialsGrantRequest.get();
			accessToken = clientCredentials.getAccessToken();
			api.setAccessToken(accessToken);
			
			final String state = "3847hy87fy2qa1";
			String authorizeURL = api.createAuthorizeURL(scopes, state);
			System.out.println(authorizeURL);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Optional<SimplePlaylist> findPlaylist() {
		UserPlaylistsRequest.Builder playlistBuilder = api.getPlaylistsForUser(properties.getUserId());
		UserPlaylistsRequest userPlaylistsRequest = playlistBuilder.accessToken(accessToken).build();
		Page<SimplePlaylist> playlistsPage = new Page<>();
		try {
			playlistsPage = userPlaylistsRequest.get();
		} catch (IOException | WebApiException e) {
			e.printStackTrace();
		}

		String playlistName = properties.getPlaylistName(); 
		for (SimplePlaylist playlist : playlistsPage.getItems()) {
			if (playlistName.equals(playlist.getName())) {
				return Optional.of(playlist);
			}
		}

		return Optional.empty();
	}
	
	private SimplePlaylist copyPlaylist(SimplePlaylist playlist) {
		System.out.println(playlist.getId());
		final Api api2 = Api.builder().accessToken(accessToken).build();
		final PlaylistCreationRequest request = api2
				.createPlaylist(properties.getUserId(), properties.getPlaylistName() + " NEW")
				.publicAccess(true)
				.build();

		try {
			final Playlist newPlaylist = request.get();

			System.out.println("You just created this playlist!");
			System.out.println("Its title is " + newPlaylist.getName());
		} catch (Exception e) {
			System.out.println("Something went wrong!" + e.getMessage());
		}
		return null;
	}
	
	private void shufflePlaylist(SimplePlaylist newPlaylist) {
		// TODO Auto-generated method stub
	}

}
