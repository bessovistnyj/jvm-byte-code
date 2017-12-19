package ru.napadovskiu.sqlstorage;

import  org.slf4j.Logger;
import  org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
public class SqlStorage {

    private static final Logger log = LoggerFactory.getLogger(SqlStorage.class);

    public Connection connectToDataBase() {
        Connection result = null;

        String url = "jdbc:postgresql://localhost:5432/Tracker";
        String userName = "postgres";
        String password = "12341234";


        try {
            result = DriverManager.getConnection(url,userName,password);
            //PreparedStatement st = result.prepareStatement();
        } catch (Exception e ) {
            log.error(e.getMessage(),e);
//        } finally {
//            if (result != null) {
//                try {
//                    result.close();
//                } catch (SQLException e) {
//                    log.error(e.getMessage(),e);
//                }
//            }


        }
        return result;
    }


    private void createTable(String nameOfTable) {
      Connection conn = connectToDataBase();

      if (conn != null)  {

          //PreparedStatement st = conn.prepareStatement("Create ");

      }


    }

    //public void insertValues
}
