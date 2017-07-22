package br.com.pabloldias.sorting;

import java.util.List;

import com.wrapper.spotify.models.PlaylistTrack;

public interface PlaylistSorter {

	List<String> sort(List<PlaylistTrack> playlistTracks);

}
