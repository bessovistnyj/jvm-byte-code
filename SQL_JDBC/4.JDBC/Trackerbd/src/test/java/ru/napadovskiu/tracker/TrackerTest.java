package ru.napadovskiu.tracker;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.napadovskiu.items.Item;
import static org.hamcrest.core.Is.is;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static org.junit.Assert.*;



public class TrackerTest {

    private Tracker tracker = null;

    final Logger log = LoggerFactory.getLogger("TrackerTest");

    private Connection connection = null;

    private Item firstItem;

    private Item secondItem;

    @Before
    public void initialize() {
        Properties properties = new Properties();
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tracker", "postgres", "12341234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.tracker = new Tracker();

        this.firstItem = new Item("firstItemName", "FisrtItemDesc");
        this.secondItem = new Item("2ItemName", "2ItemDesc");

    }


    @Test
    public void addNewItem() {
        Item addItem = this.tracker.addNewItem(this.firstItem);
    }

    @Test
    public void deleteItem() {
    }

    @Test
    public void findItemById() {

        this.tracker.addNewItem(firstItem);
        this.tracker.addNewItem(secondItem);
        Item findItem = this.tracker.findItemById(firstItem.getId());
        assertThat(findItem.getId(), is(firstItem.getId()));

    }

    @Test
    public void findItemByName() {
        Item tmpItem = new Item("firstItemName","tmpDescription");

        this.tracker.addNewItem(firstItem);
        this.tracker.addNewItem(secondItem);
        this.tracker.addNewItem(tmpItem);

        ArrayList<Item> itemArrayList = tracker.findItemByName("firstItemName");
        assertThat(itemArrayList.isEmpty(), is(false));

    }

    @Test
    public void findItemByDescription() {
        Item tmpItem = new Item("firstItemName","tmpDescription");
        this.tracker.addNewItem(firstItem);
        this.tracker.addNewItem(secondItem);
        this.tracker.addNewItem(tmpItem);

        ArrayList<Item> itemArrayList = tracker.findItemByDescription("Item");
        assertThat(itemArrayList.isEmpty(), is(false));
        int a=1;
    }

    @Test
    public void editItem() {
    }

    @Test
    public void getAllItem() {
        this.tracker.addNewItem(firstItem);
        this.tracker.addNewItem(secondItem);
 
        ArrayList<Item> itemArrayList = tracker.findItemByName("firstItemName");
        assertThat(itemArrayList.isEmpty(), is(false));

    }
}