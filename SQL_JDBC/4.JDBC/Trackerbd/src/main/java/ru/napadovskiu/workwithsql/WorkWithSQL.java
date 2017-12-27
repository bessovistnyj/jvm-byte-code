package ru.napadovskiu.workwithsql;

import  org.slf4j.Logger;
import  org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.File;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 */
public class WorkWithSQL {

    /**
     *
     */
    private static final Logger LOG = LoggerFactory.getLogger(WorkWithSQL.class);

    /**
     *
     */
    private Settings settings = new Settings();

    /**
     *
     */
    private Connection connection;

    /**
     *
     */
    private ClassLoader loader;
    InputStream io;

    /**
     *
     */
    public WorkWithSQL() {
        this.loader = Settings.class.getClassLoader();
        this.io = loader.getResourceAsStream("app.properties");
        this.settings.load(io);
    }

    /**
     *
     * @return
     */
    public Connection getConnection() {
        try {
            this.connection = DriverManager.getConnection(settings.getValue("url"), settings.getValue("userName"), settings.getValue("password"));
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return this.connection;
    }

    /**
     *
     */
    public void createDateBase() {
        RandomAccessFile randomAccessFile = null;
        Statement st = null;
        File fileQuery1 = new File(this.loader.getResource("app.properties").getFile());

        File fileQuery =  new File(fileQuery1.getParent() + (settings.getValue("createDataBaseQuery")));

        try {
            randomAccessFile = new RandomAccessFile(fileQuery.getAbsoluteFile(), "r");
            this.connection = DriverManager.getConnection(settings.getValue("url"), settings.getValue("userName"), settings.getValue("password"));

            st = this.connection.createStatement();

            StringBuffer sb  = new StringBuffer();
            String line;
            while ((line = randomAccessFile.readLine()) != null) {
            sb.append(line);
                if (line.endsWith(";")) {
                    st.addBatch(sb.toString());
                    sb = new StringBuffer();
                }
            }
            st.executeBatch();
        } catch (IOException | SQLException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            try {
                st.close();
                this.connection.close();
                randomAccessFile.close();
            } catch (IOException | SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }

}
