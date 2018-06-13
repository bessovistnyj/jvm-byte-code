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

public class CountryController extends HttpServlet {

    /**
     *
     */
    private final UserStore usersStore = UserStore.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        Gson gson = new Gson();
        CopyOnWriteArraySet<String> roles = usersStore.selectCountries();
        PrintWriter writer = resp.getWriter();

        String json = gson.toJson(roles);
        resp.setCharacterEncoding("UTF-8");
        writer.write(json);
        writer.flush();

    }

}
