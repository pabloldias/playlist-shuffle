package br.com.pabloldias.sorting;

import java.util.List;

import com.wrapper.spotify.models.PlaylistTrack;

public interface PlaylistSorter {

	List<PlaylistTrack> sort(List<PlaylistTrack> playlistTracks);

}
