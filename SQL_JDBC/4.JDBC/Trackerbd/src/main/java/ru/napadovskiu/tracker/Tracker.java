package ru.napadovskiu.tracker;

import ru.napadovskiu.items.Item;
import ru.napadovskiu.sqlstorage.SqlStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by napadovskiy on 13.09.2016.
	*@author napadovskiy
	*@since 13.09.2016
	*@version 1
 */
 public class Tracker {

    /**
    *Array list items.
    */
    //private ArrayList<Item> takeItems = new ArrayList<Item>();

    /**
     *arguments for generate id item.
     */
    private static  final Random RN = new Random();

    private SqlStorage sqlStorage;
    private ResultSet resultQuery;


    public Tracker() {
        this.sqlStorage = new SqlStorage();
        init();
    }


    private void init() {
        SqlStorage sqlStorage = new SqlStorage();
        sqlStorage.createDateBase();
    }

    private Item getItemFroResultQuery( ResultSet resultQuery) throws SQLException {
        Item result = null;
        while (resultQuery.next()) {
            Item newItem = new Item();
            newItem.setId(resultQuery.getString("item_id"));
            newItem.setName(resultQuery.getString("item_name"));
            newItem.setDescription(resultQuery.getString("item_desc"));
            newItem.setDescription(resultQuery.getString("item_date"));
            result = newItem;
        }
        return result;
    }

    private ArrayList<Item> getItemsFromResultQuery( ResultSet resultQuery) throws SQLException {
        ArrayList<Item> result = new ArrayList<Item>();
        while (resultQuery.next()) {
            Item newItem = new Item();
            newItem.setId(resultQuery.getString("item_id"));
            newItem.setName(resultQuery.getString("item_name"));
            newItem.setDescription(resultQuery.getString("item_desc"));
            newItem.setCreateDate(resultQuery.getLong("item_date"));
            result.add(newItem);
        }
        return result;
    }

     /**
     *The method add new item to items array.
     * @param item item for add.
     * @return item.
     */
    public Item addNewItem(Item item) {
		boolean newItem = false;

        item.setId(generateId());
        item.setCreateDate(System.currentTimeMillis());

        Connection connection = this.sqlStorage.getConnection();
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("INSERT INTO table_items (item_id, item_name, item_date, item_desc) VALUES(?,?,?,?)");
            pst.setString(1,item.getId());
            pst.setString(2,item.getName());
            pst.setTimestamp(3,new java.sql.Timestamp(item.getCreateDate()));
            pst.setString(4,item.getDescription());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // this.takeItems.add(item);
        return item;
	}

    /**
     * The method delete item from items array.
     * @param item item for delete.
     * @return result if delete.
     */
    public boolean deleteItem(Item item) {
        boolean result = false;
        int i =0 ;
        Connection connection = this.sqlStorage.getConnection();
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("DELETE FROM table_items WHERE item_id = ?");
            pst.setString(1, item.getId());
            i = pst.executeUpdate();
            result =true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
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
        Connection connection = this.sqlStorage.getConnection();
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("SELECT * FROM table_items WHERE item_id = ?");
            pst.setString(1,id);
            ResultSet resultQuery =  pst.executeQuery();
            result = getItemFroResultQuery(resultQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     *
     * @param str string.
     * @param findStr find for find.
     * @return result string.
     */
    private boolean findSubString(String str, String findStr) {
        boolean result = false;
        if (str.indexOf(findStr) != -1) {
            result  = true;
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
         Connection connection = this.sqlStorage.getConnection();
         PreparedStatement pst = null;
         try {
             pst = connection.prepareStatement("SELECT * FROM table_items WHERE item_name = ?");
             pst.setString(1,name);
             ResultSet resultQuery =  pst.executeQuery();
             resultArray = getItemsFromResultQuery(resultQuery);
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             try {
                 pst.close();
                 connection.close();
             } catch (SQLException e) {
                 e.printStackTrace();
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
        String descForSearch = new StringBuilder().append("'%").append(description).append("%'").toString();
        Connection connection = this.sqlStorage.getConnection();
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("SELECT * FROM table_items WHERE item_desc LIKE ?");
            pst.setString(1,descForSearch);
            ResultSet resultQuery =  pst.executeQuery();
            resultArray = getItemsFromResultQuery(resultQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultArray;
    }

	/**
	*The method edit item.
	*@param editItem item for edit.
	*/
    public void editItem(Item editItem) {
        Connection connection = this.sqlStorage.getConnection();
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("UPDATE table_items SET item_id = ?,item_name = ?, item_date =? WHERE item_id = ?");
            pst.setString(1,editItem.getId());
            pst.setString(2,editItem.getName());
            pst.setTimestamp(3,new java.sql.Timestamp(editItem.getCreateDate()));
            pst.setString(4,editItem.getId());
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *The method show all item.
     *@return an array all items.
     */
    public ArrayList<Item> getAllItem() {
        ArrayList result = null;
        //return this.takeItems;

        return result;
    }

    /**
     *The method generate id for new item.
     *@return id id.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

}
