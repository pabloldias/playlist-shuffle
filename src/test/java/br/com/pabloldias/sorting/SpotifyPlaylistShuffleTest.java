package br.com.pabloldias.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.pabloldias.builder.Albums;
import br.com.pabloldias.playlist.Album;

public class SpotifyPlaylistShuffleTest {
	
	@Test
	public void shufflePlaylistWithAnUniqueAlbum() {
		List<Album> expectedPlaylist = Arrays.asList(
				Albums.achtungBaby());
		List<Album> originalPlaylist = Arrays.asList(
				Albums.achtungBaby());

		PlaylistSorter sorter = new SpotifyPlaylistShuffle();
		List<Album> actualPlaylist = sorter.sort(originalPlaylist);

		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}
	
	@Test
	public void shufflePlaylistWithTwoAlbums() {	
		List<Album> originalPlaylist = Arrays.asList(
				Albums.marqueeMoon(),
				Albums.achtungBaby());

		List<Album> expectedPlaylist = Arrays.asList(
				Albums.achtungBaby(),
				Albums.marqueeMoon());
		
		PlaylistSorter sorter = new SpotifyPlaylistShuffle();	
		List<Album> actualPlaylist = sorter.sort(originalPlaylist);
		
		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}
	
	@Test
	public void shufflePlaylistWithThreeAlbums() {	
		List<Album> originalPlaylist = Arrays.asList(
				Albums.marqueeMoon(),
				Albums.achtungBaby(),
				Albums.miloGoesToCollege());

		List<Album> expectedPlaylist = Arrays.asList(
				Albums.achtungBaby(),
				Albums.marqueeMoon(),
				Albums.miloGoesToCollege());
		
		PlaylistSorter sorter = new SpotifyPlaylistShuffle();	
		List<Album> actualPlaylist = sorter.sort(originalPlaylist);
		
		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}

	@Test
	public void shufflePlaylistWithFourAlbums() {	
		List<Album> originalPlaylist = Arrays.asList(
				Albums.marqueeMoon(),
				Albums.achtungBaby(),
				Albums.miloGoesToCollege(),
				Albums.theEnglishRiviera());

		List<Album> expectedPlaylist = Arrays.asList(
				Albums.miloGoesToCollege(),
				Albums.marqueeMoon(),
				Albums.theEnglishRiviera(),
				Albums.achtungBaby());
		
		PlaylistSorter sorter = new SpotifyPlaylistShuffle();	
		List<Album> actualPlaylist = sorter.sort(originalPlaylist);
		
		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}
	
}
