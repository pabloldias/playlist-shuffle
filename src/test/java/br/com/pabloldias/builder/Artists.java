package br.com.pabloldias.builder;

import br.com.pabloldias.playlist.SortableArtist;

public class Artists {
	
	public static SortableArtist u2() {
		return new SortableArtist("U2");
	}
	
	public static SortableArtist television() {
		return new SortableArtist("Television");
	}
	
	public static SortableArtist descendents() {
		return new SortableArtist("Descendents");
	}
	
	public static SortableArtist metronomy() {
		return new SortableArtist("Metronomy");
	}

}
