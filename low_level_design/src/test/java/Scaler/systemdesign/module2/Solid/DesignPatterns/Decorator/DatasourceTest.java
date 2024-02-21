package Scaler.systemdesign.module2.Solid.DesignPatterns.Decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatasourceTest {

    @Test
    void testRead(){
        Datasource db = new FileDatasource();
        assertEquals("Base",db.read());
    }
    @Test
    void testEncryption(){
        //EncryptedDatasource
        Datasource db = new FileDatasource();
        Datasource encrptedDb = new EncryptionDecorator(db);
        Datasource compresseDb = new CompressionDecorator(encrptedDb);
        assertEquals("Base - Decrypted - Decompressed",compresseDb.read());
    }

}