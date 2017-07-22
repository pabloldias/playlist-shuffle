package br.com.pabloldias.builder;

import com.wrapper.spotify.models.SimpleAlbum;

public class Albums {
	
	private static SimpleAlbum newAlbum(String name) {
		SimpleAlbum album = new SimpleAlbum();
		album.setName(name);
		album.setUri(name);
		return album;
	}

	public static SimpleAlbum achtungBaby() {
		return newAlbum("Achtung Baby");
	}

	public static SimpleAlbum marqueeMoon() {
		return newAlbum("Marquee Moon");
	}
	
	public static SimpleAlbum miloGoesToCollege() {
		return newAlbum("Milo Goes To College");
	}

	public static SimpleAlbum theEnglishRiviera() {
		return newAlbum("The English Riviera");
	}
	
	public static SimpleAlbum theJoshuaTree() {
		return newAlbum("The Joshua Tree");
	}
	
}
