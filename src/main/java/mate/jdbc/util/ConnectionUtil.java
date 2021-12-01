package mate.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    public static final String URL = "jdbc:mysql://localhost:3306/taxi_service_db";
    public static final String USERNAME = "DentalRaid";
    public static final String PASSWORD = "LittleBaldBruce4891";
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String TIME_ZONE = "?useUnicode=true&serverTimezone=UTC";

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
        return DriverManager.getConnection(URL + TIME_ZONE, dbProperties);
    }
}
