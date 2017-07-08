package br.com.pabloldias.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.wrapper.spotify.models.SimpleAlbum;

import br.com.pabloldias.builder.Albums;

public class ListSplitterTest {

	@Test
	public void testEmptyList() {
		List<SimpleAlbum> albums = Collections.emptyList();
		ListSplitter lists = new ListSplitter(albums);
		
		List<SimpleAlbum> firstList = Collections.emptyList();
		List<SimpleAlbum> secondList = Collections.emptyList();
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());
	}
	
	@Test
	public void testListWithAnUniqueAlbum() {
		List<SimpleAlbum> albums = Arrays.asList(Albums.achtungBaby());
		ListSplitter lists = new ListSplitter(albums);
		
		List<SimpleAlbum> firstList = Collections.emptyList();
		List<SimpleAlbum> secondList = Arrays.asList(Albums.achtungBaby());
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());
	}
	
	@Test
	public void testListWithTwoAlbums() {
		List<SimpleAlbum> albums = Arrays.asList(
				Albums.achtungBaby(),
				Albums.marqueeMoon());
		ListSplitter lists = new ListSplitter(albums);

		List<SimpleAlbum> firstList = Arrays.asList(Albums.achtungBaby());
		List<SimpleAlbum> secondList = Arrays.asList(Albums.marqueeMoon());
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());
	}
	
	@Test
	public void testListWithThreeAlbums() {
		List<SimpleAlbum> albums = Arrays.asList(
				Albums.achtungBaby(),
				Albums.marqueeMoon(),
				Albums.miloGoesToCollege());

		ListSplitter lists = new ListSplitter(albums);

		List<SimpleAlbum> firstList = Arrays.asList(Albums.achtungBaby());
		List<SimpleAlbum> secondList = Arrays.asList(
				Albums.marqueeMoon(),
				Albums.miloGoesToCollege());
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());
	}
	
	@Test
	public void testListWithFourAlbums() {
		List<SimpleAlbum> albums = Arrays.asList(
				Albums.achtungBaby(),
				Albums.marqueeMoon(),
				Albums.miloGoesToCollege(),
				Albums.theEnglishRiviera());
		
		ListSplitter lists = new ListSplitter(albums);

		List<SimpleAlbum> firstList = Arrays.asList(
				Albums.achtungBaby(),
				Albums.marqueeMoon());
		List<SimpleAlbum> secondList = Arrays.asList(
				Albums.miloGoesToCollege(),
				Albums.theEnglishRiviera());
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());		
	}

}
