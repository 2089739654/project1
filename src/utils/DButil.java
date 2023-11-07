package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

import static java.lang.Class.*;

public class DButil {
    private static ResourceBundle bundle=ResourceBundle.getBundle("resource/jdbc");
    private static String driver= bundle.getString("driver");
    private static String url=bundle.getString("url");
    private static String password=bundle.getString("password");
    private static String username=bundle.getString("username");

    private DButil(){}

    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection GetConnection() throws IOException, SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static void close(Connection con, Statement stm, ResultSet rs){
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(stm!=null) {
            try {
                stm.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(con!=null) {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }



    }


}
