package br.com.pabloldias.builder;

import java.util.Arrays;
import java.util.List;

import br.com.pabloldias.playlist.Album;
import br.com.pabloldias.playlist.Artist;
import br.com.pabloldias.playlist.Track;

public class AlbumBuilder {

	public static Album getAchtungBaby() {
		List<Track> trackList = Arrays.asList(
				new Track("Zoo Station"),
				new Track("Even Better Than the Real Thing"),
				new Track("One"),
				new Track("Until the End of the World"),
				new Track("Who's Gonna Ride Your Wild Horses"),
				new Track("So Cruel"),
				new Track("The Fly"),
				new Track("Mysterious Ways"),
				new Track("Tryin' to Throw Your Arms Around the World"),
				new Track("Ultraviolet (Light My Way)"),
				new Track("Acrobat"),
				new Track("Love Is Blindness"));
		
		return new Album(new Artist("U2"), trackList);
	}

	public static Album getMarqueeMoon() {
		List<Track> trackList = Arrays.asList(
				new Track("See No Evil"),
				new Track("Venus"),
				new Track("Friction"),
				new Track("Marquee Moon"),
				new Track("Elevation"),
				new Track("Guiding Light"),
				new Track("Prove It"),
				new Track("Torn Curtain"));
		
		return new Album(new Artist("Television"), trackList);
	}
	
	public static Album getMiloGoesToCollege() {
		List<Track> trackList = Arrays.asList(
				new Track("Myage"),
				new Track("I Wanna Be A Bear"),
				new Track("I'm Not A Loser"),
				new Track("Parents"),
				new Track("Tonyage"),
				new Track("M 16"),
				new Track("I'm Not A Punk"),
				new Track("Catalina"),
				new Track("Suburban Home"),
				new Track("Statue Of Liberty"),
				new Track("Kabuki Girl"),
				new Track("Marriage"),
				new Track("Hope"),
				new Track("Bikeage"),
				new Track("Jean Is Dead"));
		
		return new Album(new Artist("Descendents"), trackList);
	}

	public static Album getTheEnglishRiviera() {
		List<Track> trackList = Arrays.asList(
				new Track("The English Riviera"), 
				new Track("We Broke Free"),
				new Track("Everything Goes My Way"), 
				new Track("The Look"), 
				new Track("She Wants"),
				new Track("Trouble"), 
				new Track("The Bay"), 
				new Track("Loving Arm"), 
				new Track("Corinne"),
				new Track("Some Written"), 
				new Track("Love Underlined"));

		return new Album(new Artist("Metronomy"), trackList);
	}
	
}
