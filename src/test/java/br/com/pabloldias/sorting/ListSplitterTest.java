package br.com.pabloldias.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.pabloldias.builder.AlbumBuilder;
import br.com.pabloldias.playlist.Album;

public class ListSplitterTest {

	@Test
	public void testEmptyList() {
		List<Album> albums = Collections.emptyList();
		ListSplitter lists = new ListSplitter(albums);
		
		List<Album> firstList = Collections.emptyList();
		List<Album> secondList = Collections.emptyList();
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());
	}
	
	@Test
	public void testListWithAnUniqueAlbum() {
		List<Album> albums = Arrays.asList(AlbumBuilder.getAchtungBaby());
		ListSplitter lists = new ListSplitter(albums);
		
		List<Album> firstList = Collections.emptyList();
		List<Album> secondList = Arrays.asList(AlbumBuilder.getAchtungBaby());
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());
	}
	
	@Test
	public void testListWithTwoAlbums() {
		List<Album> albums = Arrays.asList(
				AlbumBuilder.getAchtungBaby(),
				AlbumBuilder.getMarqueeMoon());
		ListSplitter lists = new ListSplitter(albums);

		List<Album> firstList = Arrays.asList(AlbumBuilder.getAchtungBaby());
		List<Album> secondList = Arrays.asList(AlbumBuilder.getMarqueeMoon());
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());
	}
	
	@Test
	public void testListWithThreeAlbums() {
		List<Album> albums = Arrays.asList(
				AlbumBuilder.getAchtungBaby(),
				AlbumBuilder.getMarqueeMoon(),
				AlbumBuilder.getMiloGoesToCollege());

		ListSplitter lists = new ListSplitter(albums);

		List<Album> firstList = Arrays.asList(AlbumBuilder.getAchtungBaby());
		List<Album> secondList = Arrays.asList(
				AlbumBuilder.getMarqueeMoon(),
				AlbumBuilder.getMiloGoesToCollege());
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());
	}
	
	@Test
	public void testListWithFourAlbums() {
		List<Album> albums = Arrays.asList(
				AlbumBuilder.getAchtungBaby(),
				AlbumBuilder.getMarqueeMoon(),
				AlbumBuilder.getMiloGoesToCollege(),
				AlbumBuilder.getTheEnglishRiviera());
		
		ListSplitter lists = new ListSplitter(albums);

		List<Album> firstList = Arrays.asList(
				AlbumBuilder.getAchtungBaby(),
				AlbumBuilder.getMarqueeMoon());
		List<Album> secondList = Arrays.asList(
				AlbumBuilder.getMiloGoesToCollege(),
				AlbumBuilder.getTheEnglishRiviera());
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());		
	}

}
