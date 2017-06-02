package br.com.pabloldias.sorting;

import java.util.List;

import br.com.pabloldias.playlist.Album;

public class AlbumListProperties {

	private Integer size;

	public AlbumListProperties(List<Album> albums) {
		this.size = albums.size();
	}
	
	public Integer getOffset() {
		return this.size / 2;
	}

	public Integer getSize() {
		return size;
	}

}
