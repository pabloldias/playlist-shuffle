package br.com.pabloldias.builder;

import java.util.ArrayList;
import java.util.List;

import com.wrapper.spotify.models.PlaylistTrack;

public class PlaylistTrackUris {
	
	private static List<String> getTrackUris(List<PlaylistTrack> playlistTracks) {
		List<String> uris = new ArrayList<>();
		for (PlaylistTrack playlistTrack : playlistTracks) {
			uris.add(playlistTrack.getTrack().getUri());
		}
		return uris;
	}

	public static List<String> achtungBaby() {
		return getTrackUris(PlaylistTracks.achtungBaby());
	}

	public static List<String> marqueeMoon() {
		return getTrackUris(PlaylistTracks.marqueeMoon());
	}
	
	public static List<String> miloGoesToCollege() {
		return getTrackUris(PlaylistTracks.miloGoesToCollege());
	}

	public static List<String> theEnglishRiviera() {
		return getTrackUris(PlaylistTracks.theEnglishRiviera());
	}
	
	public static List<String> theJoshuaTree() {
		return getTrackUris(PlaylistTracks.theJoshuaTree());
	}
	
}
