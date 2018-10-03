package ru.napadovskiu.servlets;

import com.google.gson.Gson;
import ru.napadovskiu.entities.Engine;
import ru.napadovskiu.entities.GearBox;
import ru.napadovskiu.entities.Transmission;
import ru.napadovskiu.storage.EngineStorage;
import ru.napadovskiu.storage.GearBoxStorage;
import ru.napadovskiu.storage.TransStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class JsonServlet extends HttpServlet {

    /**
     *
     */
    private final EngineStorage engineStorage = EngineStorage.getInstance();

    private final GearBoxStorage gearBoxStorage = GearBoxStorage.getInstance();

    private final TransStorage transStorage = TransStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        String queryName = req.getParameter("namePart");
        String json = null;
        if (queryName.equals("engine") ) {
            List<Engine> list = engineStorage.getAll();
            json = new Gson().toJson(list);
        } else if(queryName.equals("gearBox")) {
            List<GearBox> list = gearBoxStorage.getAll();
            json = new Gson().toJson(list);

        } else {
            List<Transmission> list = transStorage.getAll();
            json = new Gson().toJson(list);

        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/json");
//        int userId = Integer.parseInt(req.getParameter("userId"));
//
//        List<MusicType> listMusicType = musicStore.getAllMusicTypeByUser(userId);
//        String json = new Gson().toJson(listMusicType);
//
//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//        resp.getWriter().write(json);

    }
}
