package ru.napadovskiu.servlets;


import ru.napadovskiu.entities.Address;
import ru.napadovskiu.entities.MusicType;
import ru.napadovskiu.entities.Role;
import ru.napadovskiu.entities.User;
import ru.napadovskiu.store.AddressStore;
import ru.napadovskiu.store.MusicStore;
import ru.napadovskiu.store.RoleStore;
import ru.napadovskiu.store.UserStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 */
public class CreateUserServlet extends HttpServlet {

    /**
     *
     */
    private final UserStore usersStore = UserStore.INSTANCE;

    private final AddressStore addressStore = AddressStore.INSTANCE;

    private final RoleStore roleStore = RoleStore.INSTANCE;

    private final MusicStore musicStore = MusicStore.INSTANCE;


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
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/createUser.jsp");
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
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Address address = addressStore.getByName( req.getParameter("address"));
        Role role = roleStore.getByName(req.getParameter("role"));
        List<MusicType> musicTypeList = musicStore.getById(req.getParameter("muic"));

        User user = new User(name, login);
        user.setPassword(password);
        user.setAddress(address);
        user.setRole(role);
        user.setMusicType(musicTypeList);

        //,password,address,role,musicTypeList);
//        boolean result = this.usersStore.addUser(user);
//        if (result) {
//            result = this.usersStore.addRole(user.getEmail(), req.getParameter("role"));
//        }
//        if (result) {
//            req.setAttribute("users", UserStore.getInstance().selectAllUser());
//            req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req, resp);
//        }
   }


}
