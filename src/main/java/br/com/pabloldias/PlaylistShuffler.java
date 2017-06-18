package br.com.pabloldias;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.HttpManager;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.methods.UserPlaylistsRequest;
import com.wrapper.spotify.methods.authentication.ClientCredentialsGrantRequest;
import com.wrapper.spotify.models.ClientCredentials;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.SimplePlaylist;

@Component
public class PlaylistShuffler {
	
	private Api api;
	private String accessToken;
	
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
		return null;
	}
	
	private void shufflePlaylist(SimplePlaylist newPlaylist) {
		// TODO Auto-generated method stub
	}

}
