package mate.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    public static final String URL_MANUFACTURERS = "jdbc:mysql://localhost:3306/manufacturers";
    public static final String URL_DRIVERS = "jdbc:mysql://localhost:3306/drivers";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "OkC0mputer";
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver", e);
        }
    }

    public static Connection getManufacturersConnection() throws SQLException {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", USERNAME);
        dbProperties.setProperty("password", PASSWORD);
        return DriverManager.getConnection(URL_MANUFACTURERS, dbProperties);
    }

    public static Connection getDriversConnection() throws SQLException {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", USERNAME);
        dbProperties.setProperty("password", PASSWORD);
        return DriverManager.getConnection(URL_DRIVERS, dbProperties);
    }
}
