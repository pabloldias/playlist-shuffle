package br.com.pabloldias.builder;

import com.wrapper.spotify.models.AlbumType;

import br.com.pabloldias.playlist.Album;

public class Albums {

	public static Album achtungBaby() {
		/*List<Track> trackList = Arrays.asList(
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
		return new Album(Artists.u2(), trackList);*/
		Album album = new Album();
		album.setName("Achtung Baby");
		album.setAlbumType(AlbumType.ALBUM);
		return album;
	}

	public static Album marqueeMoon() {
		/*List<Track> trackList = Arrays.asList(
				new Track("See No Evil"),
				new Track("Venus"),
				new Track("Friction"),
				new Track("Marquee Moon"),
				new Track("Elevation"),
				new Track("Guiding Light"),
				new Track("Prove It"),
				new Track("Torn Curtain"));
		
		return new Album(Artists.television(), trackList);*/
		Album album = new Album();
		album.setName("Marquee Moon");
		album.setAlbumType(AlbumType.ALBUM);
		return album;
	}
	
	public static Album miloGoesToCollege() {
		/*List<Track> trackList = Arrays.asList(
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
		
		return new Album(Artists.descendents(), trackList);*/
		Album album = new Album();
		album.setName("Milo Goes To College");
		album.setAlbumType(AlbumType.ALBUM);
		return album;
	}

	public static Album theEnglishRiviera() {
		/*List<Track> trackList = Arrays.asList(
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

		return new Album(Artists.metronomy(), trackList);*/
		Album album = new Album();
		album.setName("The English Riviera");
		album.setAlbumType(AlbumType.ALBUM);
		return album;
	}
	
	public static Album theJoshuaTree() {
		/*List<Track> tracklist = Arrays.asList(
				new Track("Where The Streets Have No Name"),
				new Track("I Still Haven't Found What I'm Looking For"),
				new Track("With Or Without You"),
				new Track("Bullet The Blue Sky"),
				new Track("Running To Stand Still"),
				new Track("Red Hill Mining Town"),
				new Track("In God's Country"),
				new Track("Trip Through Your Wires"),
				new Track("One Tree Hill"),
				new Track("Exit"),
				new Track("Mothers Of The Disappeared"));
		
		return new Album(Artists.u2(), tracklist);*/
		Album album = new Album();
		album.setName("The Joshua Tree");
		album.setAlbumType(AlbumType.ALBUM);
		return album;
	}
	
}
