package br.com.pabloldias.sorting;

import java.util.List;

import br.com.pabloldias.playlist.Album;

public interface PlaylistSorter {
	
	List<Album> sort(List<Album> albums);

}
