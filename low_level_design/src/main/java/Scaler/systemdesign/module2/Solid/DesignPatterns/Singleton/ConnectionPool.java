package Scaler.systemdesign.module2.Solid.DesignPatterns.Singleton;

public class ConnectionPool {

    //Step 3: Local attribute
    // Eager Initialisation
    private static ConnectionPool INSTANCE=new ConnectionPool();

    //Step 1: Constructor Hidding
    private ConnectionPool(){}

    //Step 2: Global Access Point
    //Lazy Initialisation
    public static  ConnectionPool getInstance(){
    //Step 4: If INSTANCE is not null return
    //        ELSE - Create, Store and return
        if(INSTANCE==null){
            synchronized (ConnectionPool.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectionPool();
                } // Double lock check approach
            }
        }
        return INSTANCE;
    }
}
