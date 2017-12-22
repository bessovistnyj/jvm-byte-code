package ru.napadovskiu.workwithsql;

import ru.napadovskiu.items.Comments;
import ru.napadovskiu.items.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultsFromQuery {

    public Item getItemFromResultQuery(ResultSet resultQuery) throws SQLException {
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

    public ArrayList<Item> getItemsFromResultQuery(ResultSet resultQuery) throws SQLException {
        ArrayList<Item> result = new ArrayList<Item>();
        while (resultQuery.next()) {
            Item newItem = new Item();
            newItem.setId(resultQuery.getString("item_id"));
            newItem.setName(resultQuery.getString("item_name"));
            newItem.setDescription(resultQuery.getString("item_desc"));
            newItem.setCreateDate(resultQuery.getTimestamp("item_date").getTime());
            result.add(newItem);
        }
        return result;
    }

    public ArrayList<Comments> getCommentsFromResultQuery(ResultSet resultQuery) throws SQLException {
        ArrayList<Comments> result = new ArrayList<Comments>();
        while (resultQuery.next()) {
            Comments comments = new Comments();
            comments.setComment(resultQuery.getString("comments_description"));
            result.add(comments);
        }
        return result;
    }

}
