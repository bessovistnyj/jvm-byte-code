package ru.napadovskiu.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.napadovskiu.items.Item;
import ru.napadovskiu.workwithsql.ResultsFromQuery;
import ru.napadovskiu.workwithsql.WorkWithSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Random;

/**
 * Created by napadovskiy on 13.09.2016.
	*@author napadovskiy
	*@since 13.09.2016
	*@version 1
 */
 public class Tracker {

    private static final Logger LOG = LoggerFactory.getLogger(WorkWithSQL.class);
    /**
     *arguments for generate id item.
     */
    private static  final Random RN = new Random();

    private WorkWithSQL workWithSQL;

    public Tracker() {
        this.workWithSQL = new WorkWithSQL();
        init();
    }


    private void init() {
        WorkWithSQL workWithSQL = new WorkWithSQL();
        workWithSQL.createDateBase();
    }

    /**
     *The method generate id for new item.
     *@return id id.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

     /**
     *The method add new item to items array.
     * @param item item for add.
     * @return item.
     */
    public Item addNewItem(Item item) {
        item.setId(generateId());
        item.setCreateDate(System.currentTimeMillis());

        Connection connection = this.workWithSQL.getConnection();
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("INSERT INTO table_items (item_id, item_name, item_date, item_desc) VALUES(?,?,?,?)");
            pst.setString(1, item.getId());
            pst.setString(2, item.getName());
            pst.setTimestamp(3, new java.sql.Timestamp(item.getCreateDate()));
            pst.setString(4, item.getDescription());
            pst.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return item;
	}

    /**
     * The method delete item from items array.
     * @param item item for delete.
     * @return result if delete.
     */
    public boolean deleteItem(Item item) {
        boolean result = false;

        Connection connection = this.workWithSQL.getConnection();
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("DELETE FROM table_items WHERE item_id = ?");
            pst.setString(1, item.getId());
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return result;
    }

	 /**
	 *The method find item by id.
	 *@param id id for search.
	 *@return an array of items found.
	 */
    public Item findItemById(String id) {
        Item result = null;
        Connection connection = this.workWithSQL.getConnection();
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("SELECT * FROM table_items WHERE item_id = ?");
            pst.setString(1, id);
            ResultSet resultQuery =  pst.executeQuery();
            ResultsFromQuery resultsFromQuery = new ResultsFromQuery();
            result = resultsFromQuery.getItemFromResultQuery(resultQuery);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return result;
    }

    /**
     *The method find item by name.
     *@param name name of item.
     *@return an array of items found.
     */
     public ArrayList<Item> findItemByName(String name) {
         ArrayList<Item> resultArray = null;
         Connection connection = this.workWithSQL.getConnection();
         PreparedStatement pst = null;
         try {
             pst = connection.prepareStatement("SELECT * FROM table_items WHERE item_name = ?");
             pst.setString(1, name);
             ResultSet resultQuery =  pst.executeQuery();
             ResultsFromQuery resultsFromQuery = new ResultsFromQuery();
             resultArray = resultsFromQuery.getItemsFromResultQuery(resultQuery);
         } catch (SQLException e) {
             LOG.error(e.getMessage(), e);
         } finally {
             try {
                 pst.close();
                 connection.close();
             } catch (SQLException e) {
                 LOG.error(e.getMessage(), e);
             }
         }
        return resultArray;
    }

    /**
     *The method find item by name and description.
     *@param description description of item.
     *@return an array of items found.
     */
    public ArrayList<Item> findItemByDescription(String description) {
        ArrayList<Item> resultArray = new ArrayList<Item>();
        Connection connection = this.workWithSQL.getConnection();
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(String.format("SELECT * FROM table_items WHERE item_desc LIKE  \'%%%s%%\'", description));
            ResultSet resultQuery =  pst.executeQuery();
            ResultsFromQuery resultsFromQuery = new ResultsFromQuery();
            resultArray = resultsFromQuery.getItemsFromResultQuery(resultQuery);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return resultArray;
    }

	/**
	*The method edit item.
	*@param editItem item for edit.
	*/
    public void editItem(Item editItem) {
        Connection connection = this.workWithSQL.getConnection();
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("UPDATE table_items SET item_name = ?, item_date =? WHERE item_id = ?");
            pst.setString(1, editItem.getName());
            pst.setTimestamp(2, new java.sql.Timestamp(editItem.getCreateDate()));
            pst.setString(3, editItem.getId());
            pst.executeUpdate();

        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }

    /**
     *The method show all item.
     *@return an array all items.
     */
    public ArrayList<Item> getAllItem() {
        ArrayList<Item> resultArray = new ArrayList<Item>();
        Connection connection = this.workWithSQL.getConnection();
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("SELECT * FROM table_items");
            ResultSet resultQuery =  pst.executeQuery();
            ResultsFromQuery resultsFromQuery = new ResultsFromQuery();
            resultArray = resultsFromQuery.getItemsFromResultQuery(resultQuery);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return resultArray;
    }

}
