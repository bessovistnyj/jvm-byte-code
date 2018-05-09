package ru.napadovskiu.servlets;

import ru.napadovskiu.store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 */
public class UserServlet extends HttpServlet {

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
        String roleName = req.getParameter("userRole");
        req.setAttribute("users", UserStore.getInstance().selectAllUser());
        req.setAttribute("userRole", roleName);
//        HttpSession session = req.getSession();
//        session.setAttribute("userRole", roleName);
        req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req,resp);
    }

}
