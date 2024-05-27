package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    public static Connection ConnectToUrl() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/public";
        String userName = "xamz";
        String password = "root";
        return DriverManager.getConnection(url, userName, password);
    }
}
