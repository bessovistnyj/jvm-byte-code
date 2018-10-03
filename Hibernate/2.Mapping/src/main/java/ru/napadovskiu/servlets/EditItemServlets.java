package ru.napadovskiu.servlets;



import ru.napadovskiu.entities.Item;
import ru.napadovskiu.storage.ItemStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 */
public class EditItemServlets extends HttpServlet {

    /**
     *
     */
    private final ItemStorage itemStorage = ItemStorage.getInstance();

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
        int userId = Integer.parseInt(req.getParameter("id"));
        Item editItem = itemStorage.get(userId);
        req.setAttribute("editItem", editItem);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/editItem.jsp");
        rd.forward(req, resp);
    }


    /**
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

//        resp.setContentType("text/html");
//        int userId = Integer.parseInt(req.getParameter("userId"));
//        User editUser = usersStore.getById(userId);
//
//        editUser.setName(req.getParameter("name"));
//        editUser.setPassword(req.getParameter("password"));
//        editUser.setLogin(req.getParameter("login"));
//
//        Role role = roleStore.getByName(req.getParameter("role"));
//        editUser.setRole(role);
//        usersStore.updateRoleInUser(editUser, role);
//
//        Address editAddress = addressStore.getByName(req.getParameter("address"));
//        if (editAddress == null) {
//            editAddress = new Address(req.getParameter("address"));
//            if (addressStore.create(editAddress)) {
//                editAddress = addressStore.getByName(editAddress.getAddress_name());
//            }
//        }
//        usersStore.updateAddressInUser(editUser,editAddress);
//        editUser.setAddress(editAddress);
//
//
//        List<MusicType> musicTypes =  takeListMusicType(req.getParameterValues("music"));
//        if (musicTypes.size() != 0 ) {
//            addMusicTypeListToUser(editUser,musicTypes);
//        }
//
//        req.getRequestDispatcher("/WEB-INF/views/usersView.jsp").forward(req, resp);
   }

}
