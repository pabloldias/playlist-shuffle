package br.com.pabloldias.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.wrapper.spotify.models.PlaylistTrack;
import com.wrapper.spotify.models.SimpleAlbum;
import com.wrapper.spotify.models.Track;

public class PlaylistTracks {

	private static PlaylistTrack newTrack(SimpleAlbum album, String name) {
		Track track = new Track();
		track.setAlbum(album);
		track.setName(name);
		track.setUri(album.getName() + name);

		PlaylistTrack playlistTrack = new PlaylistTrack();
		playlistTrack.setTrack(track);
		return playlistTrack;
	}

	private static List<PlaylistTrack> newPlaylist(SimpleAlbum album, List<String> trackList) {
		List<PlaylistTrack> playlist = new ArrayList<>();
		for (String trackName : trackList) {
			playlist.add(newTrack(album, trackName));
		}
		return playlist;
	}
	
	public static List<PlaylistTrack> achtungBaby() {
		SimpleAlbum album = Albums.achtungBaby();
		
		return newPlaylist(album,
				Arrays.asList(
						"Zoo Station", 
						"Even Better Than the Real Thing", 
						"One", 
						"Until the End of the World",
						"Who's Gonna Ride Your Wild Horses", 
						"So Cruel", 
						"The Fly", 
						"Mysterious Ways",
						"Tryin' to Throw Your Arms Around the World", 
						"Ultraviolet (Light My Way)", 
						"Acrobat",
						"Love Is Blindness"));
	}

	public static List<PlaylistTrack> marqueeMoon() {
		SimpleAlbum album = Albums.marqueeMoon();
		
		return newPlaylist(album,
				Arrays.asList(
						"See No Evil",
						"Venus",
						"Friction",
						"Marquee Moon",
						"Elevation",
						"Guiding Light",
						"Prove It",
						"Torn Curtain"));
	}
	
	public static List<PlaylistTrack> miloGoesToCollege() {
		SimpleAlbum album = Albums.miloGoesToCollege();
		
		return newPlaylist(album,
				Arrays.asList(
						"Myage",
						"I Wanna Be A Bear",
						"I'm Not A Loser",
						"Parents",
						"Tonyage",
						"M 16",
						"I'm Not A Punk",
						"Catalina",
						"Suburban Home",
						"Statue Of Liberty",
						"Kabuki Girl",
						"Marriage",
						"Hope",
						"Bikeage",
						"Jean Is Dead"));
	}
	
	public static List<PlaylistTrack> theEnglishRiviera() {
		SimpleAlbum album = Albums.theEnglishRiviera();
		
		return newPlaylist(album,
				Arrays.asList(
						"The English Riviera", 
						"We Broke Free",
						"Everything Goes My Way", 
						"The Look", 
						"She Wants",
						"Trouble", 
						"The Bay", 
						"Loving Arm", 
						"Corinne",
						"Some Written", 
						"Love Underlined"));
	}
	
	public static List<PlaylistTrack> theJoshuaTree() {
		SimpleAlbum album = Albums.theJoshuaTree();
		
		return newPlaylist(album,
				Arrays.asList(
						"Where The Streets Have No Name",
						"I Still Haven't Found What I'm Looking For",
						"With Or Without You",
						"Bullet The Blue Sky",
						"Running To Stand Still",
						"Red Hill Mining Town",
						"In God's Country",
						"Trip Through Your Wires",
						"One Tree Hill",
						"Exit",
						"Mothers Of The Disappeared"));
	}
	
}
