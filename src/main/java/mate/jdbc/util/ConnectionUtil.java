package mate.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class ConnectionUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/taxi_service";
    private static final String username;
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String password;

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver", e);
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please type login:");
            username = scanner.nextLine();
            System.out.println("Please type password:");
            password = scanner.nextLine();
        }
    }

    public static Connection getConnection() throws SQLException {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", username);
        dbProperties.setProperty("password", password);
        return DriverManager.getConnection(URL, dbProperties);
    }
}
