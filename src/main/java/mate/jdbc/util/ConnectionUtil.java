package mate.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import mate.jdbc.exception.DataProcessingException;

public class ConnectionUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/taxi_service";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "11111";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver: " + JDBC_DRIVER, e);
        }
    }

    public static String getUrl() {
        return URL;
    }

    public static String getUserName() {
        return USERNAME;
    }

    public static Connection getConnection() throws SQLException {
        try {
            Properties dbProperties = new Properties();
            dbProperties.setProperty("user", USERNAME);
            dbProperties.setProperty("password", PASSWORD);
            return DriverManager.getConnection(URL, dbProperties);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create connection to DB: "
                    + URL, e);
        }
    }
}
