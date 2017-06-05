package br.com.pabloldias.sorting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.pabloldias.playlist.Album;

public class SpotifyPlaylistShuffle implements PlaylistSorter {

	@Override
	public List<Album> sort(List<Album> albums) {
		
		List<Album> sortedAlbums = new ArrayList<>();
		ListSplitter lists = new ListSplitter(albums);
		
		Iterator<Album> firstListIterator = lists.getFirstList().iterator();
		Iterator<Album> secondListIterator = lists.getSecondList().iterator();
		
		while (firstListIterator.hasNext() || secondListIterator.hasNext()) {
			if (secondListIterator.hasNext()) {
				sortedAlbums.add(secondListIterator.next());
			}
			if (firstListIterator.hasNext()) {
				sortedAlbums.add(firstListIterator.next());
			}
		}
		
		return sortedAlbums;
	}

}
