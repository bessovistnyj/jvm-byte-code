package ru.napadovskiu.servlets;

import ru.napadovskiu.entities.*;
import ru.napadovskiu.storage.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;


/**
 *
 */
public class CreateItemServlet extends HttpServlet {

    /**
     *
     */
    private ItemStorage itemStorage = ItemStorage.getInstance();

    private CarStorage carStorage = CarStorage.getInstance();

    private EngineStorage engineStorage = EngineStorage.getInstance();

    private TransStorage transStorage = TransStorage.getInstance();

    private GearBoxStorage gearBoxStorage = GearBoxStorage.getInstance();

    /**
     *
     * @param transName
     * @return
     */
    private Transmission getTransmission(String transName) {
        Transmission transmission = transStorage.getByName(transName);
        if (transmission == null) {
            Transmission trans = new Transmission();
            trans.setTransName(transName);
            transStorage.add(trans);
            transmission = transStorage.getByName(trans.getTransName());
        }

        return transmission;
    }

    private GearBox getGearBox(String gearBoxName) {
        GearBox gearBox = gearBoxStorage.getByName(gearBoxName);
        if (gearBox == null) {
            GearBox tmpGearBox = new GearBox();
            tmpGearBox.setGearBoxName(gearBoxName);
            gearBoxStorage.add(tmpGearBox);
            gearBox = gearBoxStorage.getByName(tmpGearBox.getGearBoxName());
        }

        return gearBox;
    }

    private Engine getEngine(String engineName) {
        Engine engine = engineStorage.getByName(engineName);
        if (engine == null) {
            Engine tmpEngine = new Engine();
            tmpEngine.setEngineName(engineName);
            engineStorage.add(tmpEngine);
            engine = engineStorage.getByName(engineName);
        }

        return engine;
    }


    private Item createItem(String carName, String gearBoxName, String transName, String engineName) {
        Transmission transmission = getTransmission(transName);
        GearBox gearBox = getGearBox(gearBoxName);
        Engine engine = getEngine(engineName);
        Car newCar = new Car();
        newCar.setCarName(carName);
        newCar.setGearBox(gearBox);
        newCar.setTransmission(transmission);
        newCar.setEngine(engine);
        Item newItem = new Item();
        newItem.setDescription(carName);
        newItem.setCar(newCar);
        newItem.setDate(new Timestamp(System.currentTimeMillis()));
        return newItem;
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/createItem.jsp");
        rd.forward(req, resp);
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean result = true;

        String car_name = req.getParameter("car_name");
        String engine_name = req.getParameter("select_engine");
        String gearBox_name = req.getParameter("select_GearBox");
        String trans_name = req.getParameter("select_Transmission");
        Item newItem = createItem(car_name, gearBox_name,trans_name,engine_name);
        if (newItem == null) {
            result = false;
        }

        if (result) {
            req.getRequestDispatcher("/WEB-INF/views/items.jsp").forward(req, resp);
        } else {

        }



//        transStorage.





   }
}
