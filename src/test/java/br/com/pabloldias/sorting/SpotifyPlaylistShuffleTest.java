package br.com.pabloldias.sorting;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.wrapper.spotify.models.PlaylistTrack;

import br.com.pabloldias.builder.PlaylistTrackUris;
import br.com.pabloldias.builder.PlaylistTracks;

public class SpotifyPlaylistShuffleTest {
	
	@Test
	public void shufflePlaylistWithAnUniqueAlbum() {
		List<PlaylistTrack> originalPlaylist = PlaylistTracks.achtungBaby();
		List<String> expectedPlaylist = PlaylistTrackUris.achtungBaby();

		PlaylistSorter sorter = new SpotifyPlaylistShuffle();
		List<String> actualPlaylist = sorter.sort(originalPlaylist);

		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}
	
	@Test
	public void shufflePlaylistWithTwoAlbums() {	
		List<PlaylistTrack> originalPlaylist = new ArrayList<>();
		originalPlaylist.addAll(PlaylistTracks.achtungBaby());
		originalPlaylist.addAll(PlaylistTracks.marqueeMoon());
		
		List<String> expectedPlaylist = new ArrayList<>();
		expectedPlaylist.addAll(PlaylistTrackUris.marqueeMoon());
		expectedPlaylist.addAll(PlaylistTrackUris.achtungBaby());

		PlaylistSorter sorter = new SpotifyPlaylistShuffle();
		List<String> actualPlaylist = sorter.sort(originalPlaylist);

		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}
	
	@Test
	public void shufflePlaylistWithThreeAlbums() {
		List<PlaylistTrack> originalPlaylist = new ArrayList<>();
		originalPlaylist.addAll(PlaylistTracks.marqueeMoon());
		originalPlaylist.addAll(PlaylistTracks.achtungBaby());
		originalPlaylist.addAll(PlaylistTracks.miloGoesToCollege());
		
		List<String> expectedPlaylist = new ArrayList<>();
		expectedPlaylist.addAll(PlaylistTrackUris.achtungBaby());
		expectedPlaylist.addAll(PlaylistTrackUris.marqueeMoon());
		expectedPlaylist.addAll(PlaylistTrackUris.miloGoesToCollege());
		
		PlaylistSorter sorter = new SpotifyPlaylistShuffle();	
		List<String> actualPlaylist = sorter.sort(originalPlaylist);
		
		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}

	@Test
	public void shufflePlaylistWithFourAlbums() {	
		List<PlaylistTrack> originalPlaylist = new ArrayList<>();
		originalPlaylist.addAll(PlaylistTracks.marqueeMoon());
		originalPlaylist.addAll(PlaylistTracks.achtungBaby());
		originalPlaylist.addAll(PlaylistTracks.miloGoesToCollege());
		originalPlaylist.addAll(PlaylistTracks.theEnglishRiviera());
		
		List<String> expectedPlaylist = new ArrayList<>();
		expectedPlaylist.addAll(PlaylistTrackUris.miloGoesToCollege());
		expectedPlaylist.addAll(PlaylistTrackUris.marqueeMoon());
		expectedPlaylist.addAll(PlaylistTrackUris.theEnglishRiviera());
		expectedPlaylist.addAll(PlaylistTrackUris.achtungBaby());
		
		PlaylistSorter sorter = new SpotifyPlaylistShuffle();	
		List<String> actualPlaylist = sorter.sort(originalPlaylist);
		
		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}
	
}
