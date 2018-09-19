package ru.napadovskiu.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.simple.JSONObject;
import ru.napadovskiu.entities.Item;
import ru.napadovskiu.entities.User;
import ru.napadovskiu.storage.ItemStorage;
import ru.napadovskiu.storage.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ItemsJson extends HttpServlet {

    /**
     *
     */
    private final ItemStorage itemStorage = ItemStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
//        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        List<Item> items = itemStorage.getAll();
        int a =1;
//        GsonBuilder builder = new GsonBuilder();
//        Gson gson = builder.create();
////        JsonArray jarray = gson.toJsonTree(items).getAsJsonArray();
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.add("items", jarray);
////        String json = new Gson().toJson(items);
////        jsonObject.add("items", jarray);
////        writer.append(jsonObject.toString());
////        writer.flush();
////        resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//        resp.getWriter().write(String.valueOf(jsonObject));
    }
}
