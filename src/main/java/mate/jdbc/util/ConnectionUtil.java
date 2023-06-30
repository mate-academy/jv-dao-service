package mate.jdbc.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PROPERTIES_FILEPATH = "src/main/resources/db.properties";
    private static final String URL = "jdbc:mysql://localhost:3306/taxi_service";
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver", e);
        }

        try (InputStream inputStream = new FileInputStream(PROPERTIES_FILEPATH)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            USERNAME = properties.getProperty("user");
            PASSWORD = properties.getProperty("password");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(
                    "DB properties file not found, file=" + PROPERTIES_FILEPATH, e
            );
        } catch (IOException e) {
            throw new RuntimeException("Cannot load DB properties", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", USERNAME);
        dbProperties.setProperty("password", PASSWORD);
        return DriverManager.getConnection(URL, dbProperties);
    }
}
