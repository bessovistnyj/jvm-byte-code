package ru.napadovskiu.sqlstorage;

import  org.slf4j.Logger;
import  org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 */
public class SqlStorage {

    private static final Logger log = LoggerFactory.getLogger(SqlStorage.class);

    private Settings settings = new Settings();

    private Connection connection;

    private ClassLoader loader;
    InputStream io;

    public SqlStorage() {
        this.loader = Settings.class.getClassLoader();
        this.io = loader.getResourceAsStream("app.properties");
        this.settings.load(io);
        try {
            this.connection = DriverManager.getConnection(settings.getValue("url"),settings.getValue("userName"),settings.getValue("password"));
        } catch (SQLException e ) {
            log.error(e.getMessage(),e);
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public String getSQLQuery(String value) {
        String result = "";
        File fileQuery = new File(this.settings.getValue(value));
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileQuery.getAbsoluteFile(), "r");
            String line;
            while((line = randomAccessFile.readLine()) != null ) {
                result = result+line;
            }

            randomAccessFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

}
