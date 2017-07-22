package br.com.pabloldias.sorting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.wrapper.spotify.models.PlaylistTrack;

import br.com.pabloldias.playlist.SortableAlbum;
import br.com.pabloldias.playlist.SortableTrack;

@Component
public class SpotifyPlaylistShuffle implements PlaylistSorter {

	@Override
	public List<String> sort(List<PlaylistTrack> playlistTracks) {
		AlbumTracksMapper mapper = new AlbumTracksMapper();
		List<SortableAlbum> albums = mapper.map(playlistTracks);
		List<SortableAlbum> sortedAlbums = getSortedAlbums(albums);
		return getSortedPlaylistTrackUris(sortedAlbums);
	}

	private List<SortableAlbum> getSortedAlbums(List<SortableAlbum> albums) {
		List<SortableAlbum> sortedAlbums = new ArrayList<>();
		ListSplitter lists = new ListSplitter(albums);
		
		Iterator<SortableAlbum> firstListIterator = lists.getFirstList().iterator();
		Iterator<SortableAlbum> secondListIterator = lists.getSecondList().iterator();
		
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

	private List<String> getSortedPlaylistTrackUris(
			List<SortableAlbum> sortedAlbums) {
		
		List<String> uris = new ArrayList<>();
		for (SortableAlbum album : sortedAlbums) {
			for (SortableTrack track : album.getTracks()) {
				uris.add(track.getUri());
			}
		}
		return uris;
	}
	
	

}
