package Scaler.systemdesign.module2.Solid.DesignPatterns.Decorator;

public class EncryptionDecorator extends BaseDecorator{
    @Override
    public String read() {
        String value= nextLayer.read();
        return decrypt(value);
    }

    @Override
    public void write(String value) {
        String encrypted=encrypt(value);
        nextLayer.write(encrypted);
    }
    private String encrypt(String value){
        return value+"- Encrypted";
    }
    private String decrypt(String value){
        return value+" - Decrypted";
    }
    public EncryptionDecorator(Datasource nextLayer){
        super(nextLayer);
    }
}
