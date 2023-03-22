package mate.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/taxi_service_database";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static String incrementString(String str) {
        char lastChar = str.charAt(str.length() - 1);
        System.out.println("STring: " + str);
        System.out.println("Last char: " + lastChar);
        if (Character.isDigit(lastChar)) {
            String substring = str.substring(0, str.length() - 2);
            System.out.println("Result: " + substring + (lastChar + 1));
            return substring + (lastChar + 1);
        }
        return str + "1";
    }

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
