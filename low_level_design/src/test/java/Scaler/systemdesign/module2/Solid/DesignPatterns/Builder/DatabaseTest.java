package Scaler.systemdesign.module2.Solid.DesignPatterns.Builder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DatabaseTest {

    @Test
    void testDatabaseBuilder(){
        Database builder = Database.builder()
                .name("Rescaler")
                .withCredentials("root","root@123")
                .port(3306)
                .mysql()
                .compressed()
                .build();

        assertEquals(builder.getName(),"Rescaler");

    }

}