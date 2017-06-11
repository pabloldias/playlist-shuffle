package br.com.pabloldias.api;

import java.util.List;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.HttpManager;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.methods.PlaylistRequest;
import com.wrapper.spotify.methods.UserPlaylistsRequest;
import com.wrapper.spotify.methods.authentication.ClientCredentialsGrantRequest;
import com.wrapper.spotify.models.ClientCredentials;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.SimplePlaylist;

public class Authenticator {

	private final int portion = 10;

	public void authenticate() {

		try {

			final String clientId = "";
			final String clientSecret = "";
			final String userId = "";

			final Api api = Api.builder().clientId(clientId).clientSecret(clientSecret).build();

			UserPlaylistsRequest.Builder playlistBuilder = api.getPlaylistsForUser(userId);

			HttpManager httpManager = SpotifyHttpManager.builder().build();

			final ClientCredentialsGrantRequest clientCredentialsGrantRequest = api.clientCredentialsGrant()
					.httpManager(httpManager).build();

			ClientCredentials clientCredentials = clientCredentialsGrantRequest.get();
			api.setAccessToken(clientCredentials.getAccessToken());

			UserPlaylistsRequest userPlaylistsRequest = playlistBuilder.accessToken(clientCredentials.getAccessToken())
					.limit(portion).build();

			int offset = 0;

			System.out.println(String.format("Getting playlists for user: '%s'", userId));
			boolean isLastPage = false;
			while (!isLastPage) {
				Page<SimplePlaylist> simplePlaylistPage = userPlaylistsRequest.get();
				List<SimplePlaylist> simplePlaylists = simplePlaylistPage.getItems();
				for (SimplePlaylist simplePlaylist : simplePlaylists) {
					String playListId = simplePlaylist.getId();

					PlaylistRequest playlistRequest = api.getPlaylist(simplePlaylist.getOwner().getId(), playListId)
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
					userPlaylistsRequest = api.getPlaylistsForUser(userId)
							.accessToken(clientCredentials.getAccessToken()).limit(portion).offset(offset).build();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
