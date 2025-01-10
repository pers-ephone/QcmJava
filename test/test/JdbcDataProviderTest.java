package test;

import org.junit.jupiter.api.Test;
import service.JdbcDataProvider;

import static org.junit.jupiter.api.Assertions.*;
class JdbcDataProviderTest {

    @Test
    void getRandomQuestion() {
        JdbcDataProvider provider = new JdbcDataProvider();
        assertNotNull(provider.getRandomQuestion());
    }
}
