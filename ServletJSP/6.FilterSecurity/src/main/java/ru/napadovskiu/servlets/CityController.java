package ru.napadovskiu.servlets;

import com.google.gson.Gson;
import ru.napadovskiu.store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CopyOnWriteArraySet;

public class CityController extends HttpServlet {


    private final UserStore usersStore = UserStore.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);        Gson gson = new Gson();
        CopyOnWriteArraySet<String> roles = usersStore.selectCities();
        PrintWriter writer = resp.getWriter();

        String json = gson.toJson(roles);
        writer.append(json);
        writer.flush();

    }
}
