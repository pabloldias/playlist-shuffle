package br.com.pabloldias.playlist;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.pabloldias.builder.AlbumBuilder;
import br.com.pabloldias.sorting.PlaylistSorter;
import br.com.pabloldias.sorting.SpotifyPlaylistShuffle;

public class SpotifyPlaylistShuffleTest {
	
	@Test
	public void shufflePlaylistWithAnUniqueAlbum() {
		List<Album> expectedPlaylist = new ArrayList<>();
		expectedPlaylist.add(AlbumBuilder.getAchtungBaby());
				
		List<Album> originalPlaylist = new ArrayList<>();
		originalPlaylist.add(AlbumBuilder.getAchtungBaby());
		
		PlaylistSorter sorter = new SpotifyPlaylistShuffle();	
		List<Album> actualPlaylist = sorter.sort(originalPlaylist);
		
		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}
	
	@Test
	public void shufflePlaylistWithTwoAlbums() {	
		List<Album> originalPlaylist = new ArrayList<>();
		originalPlaylist.add(AlbumBuilder.getMarqueeMoon());
		originalPlaylist.add(AlbumBuilder.getAchtungBaby());

		List<Album> expectedPlaylist = new ArrayList<>();
		expectedPlaylist.add(AlbumBuilder.getAchtungBaby());
		expectedPlaylist.add(AlbumBuilder.getMarqueeMoon());
		
		PlaylistSorter sorter = new SpotifyPlaylistShuffle();	
		List<Album> actualPlaylist = sorter.sort(originalPlaylist);
		
		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}

}
