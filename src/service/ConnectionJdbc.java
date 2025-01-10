package service;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionJdbc {
    private static Connection connection;  // Singleton
    private static final Logger logger = LogManager.getLogger(ConnectionJdbc.class);

    private ConnectionJdbc() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/qcm",
                        "USERNAME",
                        "PASSWORD"
                );
                logger.info("connected to mariadb");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
