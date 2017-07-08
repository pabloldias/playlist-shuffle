package br.com.pabloldias.sorting;

import java.util.List;

import com.wrapper.spotify.models.SimpleAlbum;

public class ListSplitter {

	private List<SimpleAlbum> firstList;
	private List<SimpleAlbum> secondList;

	public ListSplitter(List<SimpleAlbum> albums) {
		splitList(albums);
	}
	
	private void splitList(List<SimpleAlbum> albums) {
		this.firstList = albums.subList(0, albums.size() / 2);
		this.secondList = albums.subList(albums.size() / 2, albums.size());
	}

	public List<SimpleAlbum> getFirstList() {
		return firstList;
	}

	public List<SimpleAlbum> getSecondList() {
		return secondList;
	}

}
