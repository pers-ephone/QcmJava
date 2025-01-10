package test;

import org.junit.jupiter.api.Test;
import service.ConnectionJdbc;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionJdbcTest {

    @Test
    void getConnection() {
        Connection connection = ConnectionJdbc.getConnection();
        assertNotNull(connection);
    }
}
