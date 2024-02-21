package Scaler.systemdesign.module2.Solid.DesignPatterns.Decorator;

public  class CompressionDecorator extends BaseDecorator{
    public  CompressionDecorator(Datasource datasource){
        super(datasource);
    }

    @Override
    public String read() {
        String compressed = nextLayer.read();
        return deCompress(compressed);
    }

    @Override
    public void write(String value) {
        String compressed =compress(value);
        nextLayer.write(compressed);
    }

    private String compress(String value){
        return value+" - Compressed";
    }
    private String deCompress(String value){
        return value+" - Decompressed";
    }
}
