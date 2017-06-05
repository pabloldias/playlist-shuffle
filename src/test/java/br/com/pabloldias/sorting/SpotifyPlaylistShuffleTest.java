package br.com.pabloldias.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.pabloldias.builder.AlbumBuilder;
import br.com.pabloldias.playlist.Album;

public class SpotifyPlaylistShuffleTest {
	
	@Test
	public void shufflePlaylistWithAnUniqueAlbum() {
		List<Album> expectedPlaylist = Arrays.asList(
				AlbumBuilder.getAchtungBaby());
		List<Album> originalPlaylist = Arrays.asList(
				AlbumBuilder.getAchtungBaby());

		PlaylistSorter sorter = new SpotifyPlaylistShuffle();
		List<Album> actualPlaylist = sorter.sort(originalPlaylist);

		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}
	
	@Test
	public void shufflePlaylistWithTwoAlbums() {	
		List<Album> originalPlaylist = Arrays.asList(
				AlbumBuilder.getMarqueeMoon(),
				AlbumBuilder.getAchtungBaby());

		List<Album> expectedPlaylist = Arrays.asList(
				AlbumBuilder.getAchtungBaby(),
				AlbumBuilder.getMarqueeMoon());
		
		PlaylistSorter sorter = new SpotifyPlaylistShuffle();	
		List<Album> actualPlaylist = sorter.sort(originalPlaylist);
		
		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}
	
	@Test
	public void shufflePlaylistWithThreeAlbums() {	
		List<Album> originalPlaylist = Arrays.asList(
				AlbumBuilder.getMarqueeMoon(),
				AlbumBuilder.getAchtungBaby(),
				AlbumBuilder.getMiloGoesToCollege());

		List<Album> expectedPlaylist = Arrays.asList(
				AlbumBuilder.getAchtungBaby(),
				AlbumBuilder.getMarqueeMoon(),
				AlbumBuilder.getMiloGoesToCollege());
		
		PlaylistSorter sorter = new SpotifyPlaylistShuffle();	
		List<Album> actualPlaylist = sorter.sort(originalPlaylist);
		
		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}

	@Test
	public void shufflePlaylistWithFourAlbums() {	
		List<Album> originalPlaylist = Arrays.asList(
				AlbumBuilder.getMarqueeMoon(),
				AlbumBuilder.getAchtungBaby(),
				AlbumBuilder.getMiloGoesToCollege(),
				AlbumBuilder.getTheEnglishRiviera());

		List<Album> expectedPlaylist = Arrays.asList(
				AlbumBuilder.getMiloGoesToCollege(),
				AlbumBuilder.getMarqueeMoon(),
				AlbumBuilder.getTheEnglishRiviera(),
				AlbumBuilder.getAchtungBaby());
		
		PlaylistSorter sorter = new SpotifyPlaylistShuffle();	
		List<Album> actualPlaylist = sorter.sort(originalPlaylist);
		
		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}
	
}
