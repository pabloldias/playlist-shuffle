package br.com.pabloldias.builder;

import br.com.pabloldias.playlist.SortableAlbum;

public class SortableAlbums {
	
	public static SortableAlbum achtungBaby() {
		return new SortableAlbum(Albums.achtungBaby());
	}

	public static SortableAlbum marqueeMoon() {
		return new SortableAlbum(Albums.marqueeMoon());
	}
	
	public static SortableAlbum miloGoesToCollege() {
		return new SortableAlbum(Albums.miloGoesToCollege());
	}

	public static SortableAlbum theEnglishRiviera() {
		return new SortableAlbum(Albums.theEnglishRiviera());
	}
	
	public static SortableAlbum theJoshuaTree() {
		return new SortableAlbum(Albums.theJoshuaTree());
	}

}
