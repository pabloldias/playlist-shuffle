package br.com.pabloldias.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wrapper.spotify.models.PlaylistTrack;
import com.wrapper.spotify.models.SimpleAlbum;

public class AlbumTracksMapper {

	public Map<SimpleAlbum, List<PlaylistTrack>> map(List<PlaylistTrack> playlistTracks) {
		Map<SimpleAlbum, List<PlaylistTrack>> albums = new HashMap<>();
		for (PlaylistTrack playlistTrack : playlistTracks) {
			SimpleAlbum album = playlistTrack.getTrack().getAlbum();
			if (albums.containsKey(album)) {
				albums.get(album).add(playlistTrack);
			} else {
				List<PlaylistTrack> albumTracks = new ArrayList<>();
				albumTracks.add(playlistTrack);
				albums.put(album, albumTracks);
			}
		}
		return albums;
	}

}
