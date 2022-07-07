package mate.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String URL = "YOUR DATABASE URL";
    private static final String USERNAME = "YOUR USERNAME";
    private static final String PASSWORD = "YOUR PASSWORD";
    private static final String JDBC_DRIVER = "YOUR DRIVER";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", USERNAME);
        dbProperties.setProperty("password", PASSWORD);
        return DriverManager.getConnection(URL, dbProperties);
    }
}
