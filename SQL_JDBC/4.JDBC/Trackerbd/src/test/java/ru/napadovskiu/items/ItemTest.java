package ru.napadovskiu.items;

import org.junit.Test;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.napadovskiu.items.Item;
import ru.napadovskiu.tracker.Tracker;

import static org.hamcrest.core.Is.is;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class ItemTest {

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
    public void addComment() {
    }

    @Test
    public void getComment() {
    }
}