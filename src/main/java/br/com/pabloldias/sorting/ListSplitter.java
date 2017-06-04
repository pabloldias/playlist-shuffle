package br.com.pabloldias.sorting;

import java.util.List;

import br.com.pabloldias.playlist.Album;

public class ListSplitter {

	private List<Album> firstList;
	private List<Album> secondList;

	public ListSplitter(List<Album> albums) {
		splitList(albums);
	}
	
	private void splitList(List<Album> albums) {
		this.firstList = albums.subList(0, albums.size() / 2);
		this.secondList = albums.subList(albums.size() / 2, albums.size());
	}

	public List<Album> getFirstList() {
		return firstList;
	}

	public List<Album> getSecondList() {
		return secondList;
	}

}
