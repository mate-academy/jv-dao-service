package mate.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    public static final String DRIVERS_URL = "jdbc:mysql://127.0.0.1:3306/driver_db";
    public static final String MANUFACTURERS_URL = "jdbc:mysql://127.0.0.1:3306/manufacturer_db";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1488";
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver", e);
        }
    }

    public static Connection getDriversConnection() throws SQLException {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", USERNAME);
        dbProperties.setProperty("password", PASSWORD);
        return DriverManager.getConnection(DRIVERS_URL, dbProperties);
    }
    
    public static Connection getManufacturersConnection() throws SQLException {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", USERNAME);
        dbProperties.setProperty("password", PASSWORD);
        return DriverManager.getConnection(MANUFACTURERS_URL, dbProperties);
    }
}
