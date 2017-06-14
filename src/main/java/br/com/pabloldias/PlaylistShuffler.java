package br.com.pabloldias;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.methods.PlaylistRequest;
import com.wrapper.spotify.methods.UserPlaylistsRequest;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.SimplePlaylist;

import br.com.pabloldias.api.Authenticator;

public class PlaylistShuffler {
	
	private final int portion = 10;

	public void shuffle() {
		Authenticator auth = new Authenticator(getProperties());
		listPlaylists(auth);
	}

	private void listPlaylists(Authenticator auth) {
		try {
			
		String userId = auth.getUserId();
		UserPlaylistsRequest.Builder playlistBuilder = auth.getApi().getPlaylistsForUser(userId);

		UserPlaylistsRequest userPlaylistsRequest = playlistBuilder.accessToken(auth.getAccessToken())
				.limit(portion).build();

		int offset = 0;

		System.out.println(String.format("Getting playlists for user: '%s'", userId));
		boolean isLastPage = false;
		while (!isLastPage) {
			Page<SimplePlaylist> simplePlaylistPage = userPlaylistsRequest.get();
			List<SimplePlaylist> simplePlaylists = simplePlaylistPage.getItems();
			for (SimplePlaylist simplePlaylist : simplePlaylists) {
				String playListId = simplePlaylist.getId();

				PlaylistRequest playlistRequest = auth.getApi().getPlaylist(simplePlaylist.getOwner().getId(), playListId)
						.build();
				try {
					System.out.println(String.format("Getting playlist with name '%s' owner: '%s'",
							simplePlaylist.getName(), simplePlaylist.getOwner().getId()));
					// Playlist playlist = playlistRequest.get();
				} catch (Exception e) {
					// suppress
				}
			}
			if (simplePlaylists.size() < portion) {
				isLastPage = true;
			} else {
				offset += portion;
				userPlaylistsRequest = auth.getApi().getPlaylistsForUser(userId)
						.accessToken(auth.getAccessToken()).limit(portion).offset(offset).build();
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
		try(InputStream resourceStream = loader.getResourceAsStream(authFile)) {
		    properties.load(resourceStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}
