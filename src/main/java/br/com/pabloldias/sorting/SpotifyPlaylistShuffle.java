package br.com.pabloldias.sorting;

import java.util.ArrayList;
import java.util.List;

import br.com.pabloldias.playlist.Album;

public class SpotifyPlaylistShuffle implements PlaylistSorter {

	@Override
	public List<Album> sort(List<Album> albums) {
		
		List<Album> sortedAlbums = new ArrayList<>();
		AlbumListProperties properties = new AlbumListProperties(albums);
		
		if (albums.size() <= 1) {
			sortedAlbums.addAll(albums);
			return sortedAlbums;
		}
		
		return sortedAlbums;
	}

}
