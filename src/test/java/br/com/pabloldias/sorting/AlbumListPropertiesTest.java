package br.com.pabloldias.sorting;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.pabloldias.builder.AlbumBuilder;
import br.com.pabloldias.playlist.Album;

public class AlbumListPropertiesTest {

	@Test
	public void testListWithAnUniqueAlbum() {
		List<Album> albums = Arrays.asList(AlbumBuilder.getAchtungBaby());
		AlbumListProperties properties = new AlbumListProperties(albums);
		Assert.assertEquals(new Integer(1), properties.getSize());
		Assert.assertEquals(new Integer(0), properties.getOffset());
	}
	
	@Test
	public void testListWithTwoAlbums() {
		List<Album> albums = Arrays.asList(
				AlbumBuilder.getAchtungBaby(),
				AlbumBuilder.getMarqueeMoon());
		AlbumListProperties properties = new AlbumListProperties(albums);
		Assert.assertEquals(new Integer(2), properties.getSize());
		Assert.assertEquals(new Integer(1), properties.getOffset());
	}
	
	@Test
	public void testListWithThreeAlbums() {
		List<Album> albums = Arrays.asList(
				AlbumBuilder.getAchtungBaby(),
				AlbumBuilder.getMarqueeMoon(),
				AlbumBuilder.getAchtungBaby());
		AlbumListProperties properties = new AlbumListProperties(albums);
		Assert.assertEquals(new Integer(3), properties.getSize());
		Assert.assertEquals(new Integer(1), properties.getOffset());
	}
	
	@Test
	public void testListWithFourAlbums() {
		List<Album> albums = Arrays.asList(
				AlbumBuilder.getAchtungBaby(),
				AlbumBuilder.getMarqueeMoon(),
				AlbumBuilder.getAchtungBaby(),
				AlbumBuilder.getMarqueeMoon());
		AlbumListProperties properties = new AlbumListProperties(albums);
		Assert.assertEquals(new Integer(4), properties.getSize());
		Assert.assertEquals(new Integer(2), properties.getOffset());
	}

}
