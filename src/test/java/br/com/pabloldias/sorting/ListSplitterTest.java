package br.com.pabloldias.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.pabloldias.builder.Albums;
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
		List<Album> albums = Arrays.asList(Albums.achtungBaby());
		ListSplitter lists = new ListSplitter(albums);
		
		List<Album> firstList = Collections.emptyList();
		List<Album> secondList = Arrays.asList(Albums.achtungBaby());
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());
	}
	
	@Test
	public void testListWithTwoAlbums() {
		List<Album> albums = Arrays.asList(
				Albums.achtungBaby(),
				Albums.marqueeMoon());
		ListSplitter lists = new ListSplitter(albums);

		List<Album> firstList = Arrays.asList(Albums.achtungBaby());
		List<Album> secondList = Arrays.asList(Albums.marqueeMoon());
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());
	}
	
	@Test
	public void testListWithThreeAlbums() {
		List<Album> albums = Arrays.asList(
				Albums.achtungBaby(),
				Albums.marqueeMoon(),
				Albums.miloGoesToCollege());

		ListSplitter lists = new ListSplitter(albums);

		List<Album> firstList = Arrays.asList(Albums.achtungBaby());
		List<Album> secondList = Arrays.asList(
				Albums.marqueeMoon(),
				Albums.miloGoesToCollege());
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());
	}
	
	@Test
	public void testListWithFourAlbums() {
		List<Album> albums = Arrays.asList(
				Albums.achtungBaby(),
				Albums.marqueeMoon(),
				Albums.miloGoesToCollege(),
				Albums.theEnglishRiviera());
		
		ListSplitter lists = new ListSplitter(albums);

		List<Album> firstList = Arrays.asList(
				Albums.achtungBaby(),
				Albums.marqueeMoon());
		List<Album> secondList = Arrays.asList(
				Albums.miloGoesToCollege(),
				Albums.theEnglishRiviera());
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());		
	}

}
