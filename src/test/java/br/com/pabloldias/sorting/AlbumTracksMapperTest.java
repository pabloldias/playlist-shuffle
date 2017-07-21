package br.com.pabloldias.sorting;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.wrapper.spotify.models.PlaylistTrack;
import com.wrapper.spotify.models.SimpleAlbum;

public class AlbumTracksMapperTest {
	
	@Test
	public void mapEmptyPlaylist() {
		List<PlaylistTrack> originalPlaylistTracks = Collections.emptyList();
		Map<SimpleAlbum, List<PlaylistTrack>> expectedMap = Collections.emptyMap();
		AlbumTracksMapper mapper = new AlbumTracksMapper();
		Map<SimpleAlbum, List<PlaylistTrack>> actualMap = mapper.map(originalPlaylistTracks);
		Assert.assertEquals(expectedMap, actualMap);
	}
	
	@Test
	public void mapPlaylistWithAnUniqueAlbum() {
		
	}

}
