package br.com.pabloldias.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.pabloldias.builder.SortableAlbums;
import br.com.pabloldias.playlist.SortableAlbum;

public class ListSplitterTest {

	@Test
	public void testEmptyList() {
		List<SortableAlbum> albums = Collections.emptyList();
		ListSplitter lists = new ListSplitter(albums);
		
		List<SortableAlbum> firstList = Collections.emptyList();
		List<SortableAlbum> secondList = Collections.emptyList();
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());
	}
	
	@Test
	public void testListWithAnUniqueAlbum() {
		List<SortableAlbum> albums = Arrays.asList(SortableAlbums.achtungBaby());
		ListSplitter lists = new ListSplitter(albums);
		
		List<SortableAlbum> firstList = Collections.emptyList();
		List<SortableAlbum> secondList = Arrays.asList(SortableAlbums.achtungBaby());
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());
	}
	
	@Test
	public void testListWithTwoAlbums() {
		List<SortableAlbum> albums = Arrays.asList(
				SortableAlbums.achtungBaby(),
				SortableAlbums.marqueeMoon());
		ListSplitter lists = new ListSplitter(albums);

		List<SortableAlbum> firstList = Arrays.asList(SortableAlbums.achtungBaby());
		List<SortableAlbum> secondList = Arrays.asList(SortableAlbums.marqueeMoon());
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());
	}
	
	@Test
	public void testListWithThreeAlbums() {
		List<SortableAlbum> albums = Arrays.asList(
				SortableAlbums.achtungBaby(),
				SortableAlbums.marqueeMoon(),
				SortableAlbums.miloGoesToCollege());

		ListSplitter lists = new ListSplitter(albums);

		List<SortableAlbum> firstList = Arrays.asList(SortableAlbums.achtungBaby());
		List<SortableAlbum> secondList = Arrays.asList(
				SortableAlbums.marqueeMoon(),
				SortableAlbums.miloGoesToCollege());
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());
	}
	
	@Test
	public void testListWithFourAlbums() {
		List<SortableAlbum> albums = Arrays.asList(
				SortableAlbums.achtungBaby(),
				SortableAlbums.marqueeMoon(),
				SortableAlbums.miloGoesToCollege(),
				SortableAlbums.theEnglishRiviera());
		
		ListSplitter lists = new ListSplitter(albums);

		List<SortableAlbum> firstList = Arrays.asList(
				SortableAlbums.achtungBaby(),
				SortableAlbums.marqueeMoon());
		List<SortableAlbum> secondList = Arrays.asList(
				SortableAlbums.miloGoesToCollege(),
				SortableAlbums.theEnglishRiviera());
		
		Assert.assertEquals(firstList, lists.getFirstList());
		Assert.assertEquals(secondList, lists.getSecondList());		
	}

}
