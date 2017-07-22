package br.com.pabloldias.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.wrapper.spotify.models.PlaylistTrack;

import br.com.pabloldias.builder.PlaylistTracks;
import br.com.pabloldias.builder.SortableAlbums;
import br.com.pabloldias.playlist.SortableAlbum;

public class AlbumTracksMapperTest {
	
	@Test
	public void mapEmptyPlaylist() {
		List<PlaylistTrack> originalPlaylistTracks = Collections.emptyList();
		List<SortableAlbum> expectedPlaylist = Collections.emptyList();
		AlbumTracksMapper mapper = new AlbumTracksMapper();
		List<SortableAlbum> actualPlaylist = mapper.map(originalPlaylistTracks);
		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}
	
	@Test
	public void mapPlaylistWithAnUniqueAlbum() {
		List<PlaylistTrack> originalPlaylistTracks = PlaylistTracks.achtungBaby();
		List<SortableAlbum> expectedPlaylist = Arrays.asList(
				SortableAlbums.achtungBaby());
		AlbumTracksMapper mapper = new AlbumTracksMapper();
		List<SortableAlbum> actualPlaylist = mapper.map(originalPlaylistTracks);
		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}

	@Test
	public void mapPlaylistWithTwoAlbums() {
		List<PlaylistTrack> originalPlaylistTracks = new ArrayList<>();
		originalPlaylistTracks.addAll(PlaylistTracks.achtungBaby());
		originalPlaylistTracks.addAll(PlaylistTracks.marqueeMoon());
		
		List<SortableAlbum> expectedPlaylist = Arrays.asList(
				SortableAlbums.achtungBaby(),
				SortableAlbums.marqueeMoon());
		AlbumTracksMapper mapper = new AlbumTracksMapper();
		List<SortableAlbum> actualPlaylist = mapper.map(originalPlaylistTracks);
		Assert.assertEquals(expectedPlaylist, actualPlaylist);
	}
}
