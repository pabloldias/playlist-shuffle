package br.com.pabloldias.sorting;

import java.util.ArrayList;
import java.util.List;

import br.com.pabloldias.playlist.Album;

public class SpotifyPlaylistShuffle implements PlaylistSorter {

	@Override
	public List<Album> sort(List<Album> albums) {
		
		List<Album> sortedAlbums = new ArrayList<>();
		ListSplitter lists = new ListSplitter(albums);
		
		//for (int i = ranges.getFirstRangeStart(); i <= ranges.getFirstRangeEnd(); i++) {
			
		//}
		
		return sortedAlbums;
	}

}
