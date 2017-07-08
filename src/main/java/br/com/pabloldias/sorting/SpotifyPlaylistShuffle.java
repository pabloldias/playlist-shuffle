package br.com.pabloldias.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.wrapper.spotify.models.PlaylistTrack;
import com.wrapper.spotify.models.SimpleAlbum;

@Component
public class SpotifyPlaylistShuffle implements PlaylistSorter {

	@Override
	public List<PlaylistTrack> sort(List<PlaylistTrack> playlistTracks) {
		Map<SimpleAlbum, List<PlaylistTrack>> albums = getAlbums(playlistTracks);
		List<SimpleAlbum> sortedAlbums = getSortedAlbums(albums.keySet().stream().collect(Collectors.toList()));
		return getSortedPlaylistTracks(sortedAlbums, albums);
	}

	private Map<SimpleAlbum, List<PlaylistTrack>> getAlbums(List<PlaylistTrack> playlistTracks) {
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
	
	private List<SimpleAlbum> getSortedAlbums(List<SimpleAlbum> albums) {
		List<SimpleAlbum> sortedAlbums = new ArrayList<>();
		ListSplitter lists = new ListSplitter(albums);
		
		Iterator<SimpleAlbum> firstListIterator = lists.getFirstList().iterator();
		Iterator<SimpleAlbum> secondListIterator = lists.getSecondList().iterator();
		
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

	private List<PlaylistTrack> getSortedPlaylistTracks(
			List<SimpleAlbum> sortedAlbums,
			Map<SimpleAlbum, List<PlaylistTrack>> albums) {
		
		List<PlaylistTrack> playlistTracks = new ArrayList<>();
		for (SimpleAlbum album : sortedAlbums) {
			if (albums.containsKey(album)) {
				playlistTracks.addAll(albums.get(album));
			}
		}
		return playlistTracks;
	}
	
	

}
