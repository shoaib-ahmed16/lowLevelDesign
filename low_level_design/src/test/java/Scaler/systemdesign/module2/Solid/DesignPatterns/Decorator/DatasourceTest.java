package Scaler.systemdesign.module2.Solid.DesignPatterns.Decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Datasource encryptedDb = new EncryptionDecorator(db);
        Datasource compressedDb = new CompressionDecorator(encryptedDb);
        assertEquals("Base - Decrypted - Decompressed",compressedDb.read());
    }

}