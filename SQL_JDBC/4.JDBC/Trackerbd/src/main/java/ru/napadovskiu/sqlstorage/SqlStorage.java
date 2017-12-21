package ru.napadovskiu.sqlstorage;

import  org.slf4j.Logger;
import  org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;

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
    }

    public Connection getConnection() {
        try {
            this.connection = DriverManager.getConnection(settings.getValue("url"),settings.getValue("userName"),settings.getValue("password"));
        } catch (SQLException e ) {
            log.error(e.getMessage(),e);
        }
        return this.connection;
    }

    public void createDateBase()  {
        String result = "";
        RandomAccessFile randomAccessFile = null;
        Statement st = null;
        File fileQuery = new File("C:\\projects\\jvm-byte-code\\SQL_JDBC\\4.JDBC\\Trackerbd\\src\\main\\resources\\sqlquery\\createTable.sql");

        try {
            randomAccessFile = new RandomAccessFile(fileQuery.getAbsoluteFile(), "r");
            this.connection = DriverManager.getConnection(settings.getValue("url"),settings.getValue("userName"),settings.getValue("password"));

            st = this.connection.createStatement();

            StringBuffer sb  = new StringBuffer();
            String line;

            while((line = randomAccessFile.readLine()) != null ) {
            sb.append(line);
                if (line.endsWith(";")) {
                    st.addBatch(sb.toString());
                    sb = new StringBuffer();
                }
            }
            st.executeBatch();
        } catch ( IOException | SQLException e ) {
            log.error(e.getMessage(),e);
        } finally {
            try {
                st.close();
                this.connection.close();
                randomAccessFile.close();
            } catch (IOException | SQLException e) {
                log.error(e.getMessage(),e);
            }
        }
    }

}
