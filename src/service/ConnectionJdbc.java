package service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJdbc {
    private static Connection connection;  // Singleton

    private ConnectionJdbc() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/qcm",
                        "USERNAME",
                        "PASSWORD"
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
