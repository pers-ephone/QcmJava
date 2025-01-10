package test;

import org.junit.jupiter.api.Test;
import service.LocalDataProvider;

import static org.junit.jupiter.api.Assertions.*;

class LocalDataProviderTest {

    @Test
    void getRandomQuestion() {
        LocalDataProvider provider = new LocalDataProvider();
        assertNotNull(provider.getRandomQuestion());
    }
}
