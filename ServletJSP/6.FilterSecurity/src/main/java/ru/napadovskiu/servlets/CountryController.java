package ru.napadovskiu.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.napadovskiu.store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class CountryController extends HttpServlet {

    /**
     *
     */
    private final UserStore usersStore = UserStore.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        Gson jsonBuilder = new GsonBuilder().create();
        String json = jsonBuilder.toJson(usersStore.selectAllUser());
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(json);
        writer.flush();
    }

}
