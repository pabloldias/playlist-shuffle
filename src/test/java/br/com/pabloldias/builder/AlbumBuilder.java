package br.com.pabloldias.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.pabloldias.playlist.Album;
import br.com.pabloldias.playlist.Artist;
import br.com.pabloldias.playlist.Track;

public class AlbumBuilder {

	public static Album getAchtungBaby() {
		List<Track> trackList = new ArrayList<>();
		trackList.add(new Track("One"));
		trackList.add(new Track("The Fly"));
		trackList.add(new Track("Ultraviolet"));
		
		return new Album(new Artist("U2"), trackList);
	}

	public static Album getMarqueeMoon() {
		List<Track> trackList = new ArrayList<>();
		trackList.add(new Track("Venus"));
		trackList.add(new Track("Marquee Moon"));
		trackList.add(new Track("Torn Curtain"));
		
		return new Album(new Artist("Television"), trackList);
	}

}
