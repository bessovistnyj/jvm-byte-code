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
import java.util.Set;


public class CountryController extends HttpServlet {

    /**
     *
     */
    private final UserStore usersStore = UserStore.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        Set<String> countries = usersStore.selectCountries();
        String json = new Gson().toJson(countries);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);

    }

}
