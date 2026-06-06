package demo.conart;

import demo.conart.other.DatabaseConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TestConnectionDB {

    @Test
    void testConnection() {
        int value = 0;

        if(DatabaseConnection.getInstance() != null){
            value = 1;
        }

        Assertions.assertEquals(1, value);
    }

}
