package ru.napadovskiu.sql;

import  org.slf4j.Logger;
import  org.slf4j.LoggerFactory;
import ru.napadovskiu.Vacancy;
import ru.napadovskiu.settings.Settings;

import java.io.InputStream;


import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 */
public class WorkWithDB {

    /**
     * URL to DB.
     */
    private String url;

    /**
     * DB user.
     */
    private String user;

    /**
     * DB user pass.
     */
    private String password;


    /**
     *
     */
    private String createTableQuery;


    /**
     *
     */
    private String insertTableQuery;

    /**
     *
     */
    private static final Logger LOG = LoggerFactory.getLogger(WorkWithDB.class);

    /**
     *
     */
    private final Settings settings = new Settings();

    /**
     *
     */
    public WorkWithDB() {
        ClassLoader loader = Settings.class.getClassLoader();
        InputStream io = loader.getResourceAsStream("app.properties");
        this.settings.load(io);
        this.url = this.settings.getValue("url");
        this.user = this.settings.getValue("userName");
        this.password = this.settings.getValue("password");
        this.createTableQuery = this.settings.getValue("createTable");
        this.insertTableQuery = this.settings.getValue("insertValue");

    }


    public boolean itIsFirstLaunch() {
        boolean result = false;

        return result;

    }



    public void addVacancy(Vacancy vacancy) {
        try (Connection connection = DriverManager.getConnection(this.url,this.user,this.password);
             Statement statement = connection.createStatement();)  {
            statement.addBatch(this.insertTableQuery);
            statement.executeBatch();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }

    }



    /**
     *
     */
    public void createDateBase() {

        try (Connection connection = DriverManager.getConnection(this.url,this.user,this.password);
             Statement statement = connection.createStatement();)  {
            statement.addBatch(this.createTableQuery);
            statement.executeBatch();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }





}
