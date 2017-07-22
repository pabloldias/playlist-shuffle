package br.com.pabloldias.sorting;

import java.util.ArrayList;
import java.util.List;

import com.wrapper.spotify.models.PlaylistTrack;
import com.wrapper.spotify.models.Track;

import br.com.pabloldias.playlist.SortableAlbum;
import br.com.pabloldias.playlist.SortableTrack;

public class AlbumTracksMapper {

	public List<SortableAlbum> map(List<PlaylistTrack> playlistTracks) {
		List<SortableAlbum> albums = new ArrayList<>();
		for (PlaylistTrack playlistTrack : playlistTracks) {
			Track track = playlistTrack.getTrack();
			SortableAlbum album = new SortableAlbum(track.getAlbum());
			Integer i = albums.indexOf(album);
			if (i >= 0) {
				albums.get(i).addTrack(new SortableTrack(track));
			} else {
				album.addTrack(new SortableTrack(track));
				albums.add(album);
			}
		}
		return albums;
	}

}
