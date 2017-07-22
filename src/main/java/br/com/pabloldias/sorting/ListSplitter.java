package br.com.pabloldias.sorting;

import java.util.List;

import br.com.pabloldias.playlist.SortableAlbum;

public class ListSplitter {

	private List<SortableAlbum> firstList;
	private List<SortableAlbum> secondList;

	public ListSplitter(List<SortableAlbum> albums) {
		splitList(albums);
	}
	
	private void splitList(List<SortableAlbum> albums) {
		this.firstList = albums.subList(0, albums.size() / 2);
		this.secondList = albums.subList(albums.size() / 2, albums.size());
	}

	public List<SortableAlbum> getFirstList() {
		return firstList;
	}

	public List<SortableAlbum> getSecondList() {
		return secondList;
	}

}
