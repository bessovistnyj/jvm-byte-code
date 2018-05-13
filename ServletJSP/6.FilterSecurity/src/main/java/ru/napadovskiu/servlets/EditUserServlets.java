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

/**
 *
 */
public class EditUserServlets extends HttpServlet {

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
        req.setAttribute("userRole", req.getParameter("userRole"));
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/editUser.jsp");
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
        resp.setContentType("text/html");

        String oldEmail = req.getParameter("oldEmail");
        String oldName = req.getParameter("oldName");
        String oldLogin = req.getParameter("oldLogin");

        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        req.setAttribute("userRole", req.getParameter("userRole"));

        boolean result = this.usersStore.updateUser(oldName, oldLogin, oldEmail, name, login, email, password);
        if (result) {
            User user = UserStore.getInstance().selectUser(login, password);
            req.setAttribute("users", UserStore.getInstance().selectAllUser());
            req.setAttribute("userRole", req.getParameter("userRole"));
            req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req,resp);
        } else {
            resp.sendError(404);
        }


    }

}