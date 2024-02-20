package Scaler.systemdesign.module2.Solid.DesignPatterns.Singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
class ConnectionPoolTest {

    @DisplayName("Instance Creation using Global access point.")
    @Test
    void TestStaticInit(){
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        assertNotNull(connectionPool);
    }

    @DisplayName("Test case Single Instance: If The instance is Singleton, it should only create same instance object")
    @Test
    void testSingleInstance(){
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        ConnectionPool connectionPool2=ConnectionPool.getInstance();
        assertEquals(connectionPool,connectionPool2);
    }
}