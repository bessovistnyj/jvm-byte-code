package ru.napadovskiu.store;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.napadovskiu.entities.MusicType;
import ru.napadovskiu.entities.User;
import ru.napadovskiu.settings.Settings;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;


public class UserStore implements AbstractStore<User> {

    /**
     * settings for load.
     */
    private final Settings connectToDB = new Settings();


    /**
     * settings for load.
     */
    private final Settings createQuery = new Settings();


    /**
     *
     */
    private final Settings selectQuery = new Settings();


    /**
     *
     */
    private final Settings insertQuery = new Settings();

    /**
     *
     */
    private final Settings deleteQuery = new Settings();


    private final Settings updateQuery = new Settings();

    /**
     * logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserStore.class);

    /**
     *
     */
    private BasicDataSource ds;



    public UserStore() {
        ClassLoader loader = Settings.class.getClassLoader();
        this.selectQuery.load(loader.getResourceAsStream("select.properties"));
        this.insertQuery.load(loader.getResourceAsStream("insert.properties"));
        this.deleteQuery.load(loader.getResourceAsStream("delete.properties"));
        this.updateQuery.load(loader.getResourceAsStream("update.properties"));
    }


    @Override
    public User getById(int userId) {
        User user = null;
        try (Connection connection = ConnectionDB.INSTANCE.getConnection();
             PreparedStatement pst = connection.prepareStatement(this.selectQuery.getValue("selectUser")))  {
            pst.setInt(1, userId);
            ResultSet resultQuery =  pst.executeQuery();
            while (resultQuery.next()) {
                user = createUserFromQuery(resultQuery);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> result = new CopyOnWriteArrayList<>();
        try (Connection connection = ConnectionDB.INSTANCE.getConnection();
             PreparedStatement pst = connection.prepareStatement(this.selectQuery.getValue("selectUser"));)  {
            ResultSet resultQuery =  pst.executeQuery();
            while (resultQuery.next()) {
                result.add(createUserFromQuery(resultQuery));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public boolean create(User user) {
        boolean result;
        try (Connection connection = ConnectionDB.INSTANCE.getConnection();
             PreparedStatement pst = connection.prepareStatement(this.insertQuery.getValue("insertUser"))) {
            pst.setString(1, user.getName());
            pst.setString(2, user.getLogin());
            pst.setString(3, user.getPassword());

            result = pst.executeUpdate() != 0;
        } catch (SQLException e) {
            result = false;
            LOG.error(e.getMessage(), e);
        }
        return result;

    }

    @Override
    public boolean update(User user) {
        boolean result;
        try (Connection connection = ConnectionDB.INSTANCE.getConnection();
             PreparedStatement pst = connection.prepareStatement(this.updateQuery.getValue("updateMusic"))) {
            pst.setString(1, user.getMusic_name());
            pst.setInt(2, user.getMusic_id());
            result = pst.executeUpdate() != 0;
        } catch (SQLException e) {
            result = false;
            LOG.error(e.getMessage(), e);
        }
        return result;

    }

    @Override
    public boolean delete(User user) {
        boolean result = false;
        try (Connection connection = ConnectionDB.INSTANCE.getConnection();
             PreparedStatement pst = connection.prepareStatement(this.deleteQuery.getValue("deleteMusic"));)  {
            pst.setInt(1, user.getMusic_id());
            result = pst.executeUpdate() != 0;
        } catch (SQLException e) {
            result = false;
            LOG.error(e.getMessage(), e);
        }
        return result;

    }

    /**
     *
     * @param resultQuery
     * @return
     * @throws SQLException
     */
    private User createUserFromQuery(ResultSet resultQuery) throws SQLException {
        int userId = resultQuery.getInt("user_id");
        String userName = resultQuery.getString("user_name");
        String userLogin = resultQuery.getString("user_login");
        String userPassword = resultQuery.getString("user_password");
//        UserRole role = selectUserRole(newUser);
//        String userEmail = resultQuery.getString("user_email");
//        String userPassword = resultQuery.getString("user_password");
//        String user_country = resultQuery.getString("user_country");
//        String user_city = resultQuery.getString("user_city");
//        Timestamp userCreateDate = resultQuery.getTimestamp("user_createDate");

        User newUser = new User(userId, userName, userLogin, userEmail, userCreateDate, userPassword, user_country, user_city);



//        newUser.setRole(role);

        return newUser;
    }


}

