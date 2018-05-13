package ru.napadovskiu.servlets;

import ru.napadovskiu.store.UserStore;
import ru.napadovskiu.users.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 *
 */
public class CreateUserServlet extends HttpServlet {

    /**
     *
     */
    private final UserStore usersStore = UserStore.getInstance();

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
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/editRole.jsp");
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
        Timestamp dateOfCreate = new Timestamp(System.currentTimeMillis());

        User user = new User(req.getParameter("name"), req.getParameter("login"), req.getParameter("email"), dateOfCreate, req.getParameter("password"));
        boolean result = this.usersStore.addUser(user);
        if (result) {
            result = this.usersStore.addRole(user.getEmail(), req.getParameter("role"));
        }
        if (result) {
            req.setAttribute("users", UserStore.getInstance().selectAllUser());
            req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req, resp);
        }
    }


}
