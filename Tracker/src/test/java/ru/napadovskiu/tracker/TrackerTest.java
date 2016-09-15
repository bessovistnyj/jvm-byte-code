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
		
		Item secondItem = new Item("secondItem","descriptionSecondItem");
		testTracker.addNewItem(secondItem);
		
		Item thirdItem 	= new Item("thirdItem","descriptionThirdItem");
		testTracker.addNewItem(thirdItem);
		
		Item fourthItem	= new Item("fourthItem","descriptionfourthItem");
		testTracker.addNewItem(fourthItem);
		
		Item fifthItem 	= new Item("fifthItem","descriptionfifthItem");
		testTracker.addNewItem(fifthItem);
		
		Item[] testArray = new Item[] {firstItem,secondItem,thirdItem,fourthItem,fifthItem};
		
		assertThat(testTracker.showAllItem(), is(testArray));
	}	

	@Test
	public void whenDeleteItem() {
		Tracker testTracker = new Tracker();
			
		Item firstItem 	= new Item("firstItem","descriptionFirstItem");
		testTracker.addNewItem(firstItem);
		
		Item secondItem = new Item("secondItem","descriptionSecondItem");
		testTracker.addNewItem(secondItem);
		
		Item thirdItem 	= new Item("thirdItem","descriptionThirdItem");
		testTracker.addNewItem(thirdItem);
		
		Item fourthItem	= new Item("fourthItem","descriptionfourthItem");
		testTracker.addNewItem(fourthItem);
		
		Item fifthItem 	= new Item("fifthItem","descriptionfifthItem");
		testTracker.addNewItem(fifthItem);
		
		testTracker.deleteItem(thirdItem);
		Item[] testArray = new Item[] {firstItem,secondItem,fourthItem,fifthItem};
		
		assertThat(testTracker.showAllItem(), is(testArray));
	}	

	@Test
	public void whenFindItem() {
		Tracker testTracker = new Tracker();
			
		Item firstItem 	= new Item("firstItem","descriptionFirstItem");
		testTracker.addNewItem(firstItem);
		
		Item fourthItem	= new Item("fourthItem","descriptionfourthItem");
		testTracker.addNewItem(fourthItem);
		
		Item fifthItem 	= new Item("fifthItem","descriptionfifthItem");
		testTracker.addNewItem(fifthItem);
		
		Item[] testArray = new Item[] {fourthItem};
		
		assertThat(testTracker.findItem(fourthItem.getId()), is(testArray));
	}	

	@Test
	public void whenEditItem() {
        Tracker testTracker = new Tracker();

        Item firstItem 	= new Item("firstItem","descriptionFirstItem");
        testTracker.addNewItem(firstItem);

        Item secondItem = new Item("secondItem","descriptionSecondItem");
        testTracker.addNewItem(secondItem);
		
		Item editItem = new Item("editItem","descriptionEditItem");
		editItem.setId(firstItem.getId());

        testTracker.editItem(secondItem);

        Item[] testArray = new Item[] {firstItem,secondItem};

        Item[] ArrayItem = new Item[2];

        ArrayItem =testTracker.showAllItem();
		
		assertThat(ArrayItem, is(testArray));
	}	



	
	
}