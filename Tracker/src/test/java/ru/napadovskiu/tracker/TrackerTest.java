package ru.napadovskiu.tracker;

import ru.napadovskiu.items.Item;

import org.junit.Assert;

import static org.hamcrest.core.Is.is;

import org.junit.Test;

import static org.junit.Assert.*;


public class TrackerTest{
		
	@Test
	public void whenAddItem() {
		Tracker testTracker = new Tracker();
			
		Item firstItem 	= new Item("firstItem","descriptionFirstItem");
		testTracker.addNewItem(firstItem);
		
		assertThat(testTracker.getAllItem()[0], is(firstItem));
	}	

	@Test
	public void whenDeleteItem() {
		Tracker testTracker = new Tracker();
			
		Item firstItem 	= new Item("firstItem","descriptionFirstItem");
		testTracker.addNewItem(firstItem);
		
		testTracker.deleteItem(firstItem);
		
		assertThat(testTracker.getAllItem().length, is(0));
	}	

	@Test
	public void whenFindItem() {
		Tracker testTracker = new Tracker();
			
		Item firstItem 	= new Item("firstItem","descriptionFirstItem");
		testTracker.addNewItem(firstItem);

		Item secondItem = new Item("secondItem","descriptionSecondItem");
		testTracker.addNewItem(secondItem);
		
		Item[] testArray = new Item[] {firstItem};
		
		assertThat(testTracker.findItemById(secondItem.getId()), is(secondItem));
	}	

	@Test
	public void whenEditItem() {
		Tracker testTracker = new Tracker();
		Item firstItem 	= new Item("firstItem","descriptionFirstItem");
		testTracker.addNewItem(firstItem);
		
		Item editItem = new Item("secondItem","descriptionSecondItem");
		editItem.setId(firstItem.getId());
		testTracker.editItem(editItem);
	
		assertThat(firstItem.getName(), is(editItem.getName()));
	}	
}