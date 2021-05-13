package mate.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    public static final String URL = "jdbc:mysql://localhost:3306/manufacturer_db";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "x67i9#VYL%2X(*vd";
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can`t load JDBC driver for MySQL: " + JDBC_DRIVER, e);
        }
    }

    public static Connection getConnection() throws SQLException {
        try {
            Properties dbProperties = new Properties();
            dbProperties.put("user", USERNAME);
            dbProperties.put("password", PASSWORD);
            return DriverManager
                    .getConnection(URL, dbProperties);
        } catch (SQLException throwable) {
            throw new RuntimeException("Can`t create connection to DB ,URL: "
                    + URL + " user: " + USERNAME, throwable);
        }
    }
}
