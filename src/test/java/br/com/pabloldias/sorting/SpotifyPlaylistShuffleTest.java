package br.com.pabloldias.sorting;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.wrapper.spotify.models.SimpleAlbum;

import br.com.pabloldias.builder.Albums;

public class SpotifyPlaylistShuffleTest {
	
	@Test
	public void shufflePlaylistWithAnUniqueAlbum() {
		List<SimpleAlbum> expectedPlaylist = Arrays.asList(
				Albums.achtungBaby());
		List<SimpleAlbum> originalPlaylist = Arrays.asList(
				Albums.achtungBaby());

		PlaylistSorter sorter = new SpotifyPlaylistShuffle();
		List<SimpleAlbum> actualPlaylist = sorter.sort(originalPlaylist);

		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}
	
	@Test
	public void shufflePlaylistWithTwoAlbums() {	
		List<SimpleAlbum> originalPlaylist = Arrays.asList(
				Albums.marqueeMoon(),
				Albums.achtungBaby());

		List<SimpleAlbum> expectedPlaylist = Arrays.asList(
				Albums.achtungBaby(),
				Albums.marqueeMoon());
		
		PlaylistSorter sorter = new SpotifyPlaylistShuffle();	
		List<SimpleAlbum> actualPlaylist = sorter.sort(originalPlaylist);
		
		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}
	
	@Test
	public void shufflePlaylistWithThreeAlbums() {	
		List<SimpleAlbum> originalPlaylist = Arrays.asList(
				Albums.marqueeMoon(),
				Albums.achtungBaby(),
				Albums.miloGoesToCollege());

		List<SimpleAlbum> expectedPlaylist = Arrays.asList(
				Albums.achtungBaby(),
				Albums.marqueeMoon(),
				Albums.miloGoesToCollege());
		
		PlaylistSorter sorter = new SpotifyPlaylistShuffle();	
		List<SimpleAlbum> actualPlaylist = sorter.sort(originalPlaylist);
		
		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}

	@Test
	public void shufflePlaylistWithFourAlbums() {	
		List<SimpleAlbum> originalPlaylist = Arrays.asList(
				Albums.marqueeMoon(),
				Albums.achtungBaby(),
				Albums.miloGoesToCollege(),
				Albums.theEnglishRiviera());

		List<SimpleAlbum> expectedPlaylist = Arrays.asList(
				Albums.miloGoesToCollege(),
				Albums.marqueeMoon(),
				Albums.theEnglishRiviera(),
				Albums.achtungBaby());
		
		PlaylistSorter sorter = new SpotifyPlaylistShuffle();	
		List<SimpleAlbum> actualPlaylist = sorter.sort(originalPlaylist);
		
		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}
	
}
