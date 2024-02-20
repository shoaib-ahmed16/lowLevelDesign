package Scaler.systemdesign.module2.Solid.DesignPatterns.Builder;

public class Database {

    private String name;
    private String userName;
    private String password;
    private Integer port;
    private DatabaseType type;
    private  Boolean isCompressed;

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Integer getPort() {
        return port;
    }

    public DatabaseType getType() {
        return type;
    }

    public Boolean getCompressed() {
        return isCompressed;
    }

    private Database(){}

    //Trick 1 - Builder method;
    public static Builder builder(){
        return  new Builder();
    }

    //Step 1: Create static inner class.
    public static class Builder{
        //Step 2:  copy all the fields from the outer class
        private String name;
        private String userName;
        private String password;
        private Integer port;
        private DatabaseType type;
        private  Boolean isCompressed;

        //Step 3: Create getter setter for our builder class

        public String getName() {
            return name;
        }
        public String getUserName() {
            return userName;
        }
        public Integer getPort() {
            return port;
        }
        public DatabaseType getType() {
            return type;
        }
        public Boolean getInCompressed() {
            return isCompressed;
        }
        public String getPassword() {
            return password;
        }

        //Trick 2: Fluent interfaces
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder withCredentials(String userName,String password) {
            this.userName = userName;
            this.password=password;
            return this;
        }
        public Builder port(Integer port) {
            this.port = port;
            return this;
        }
        public Builder mysql() {
            this.type = DatabaseType.MY_SQL;
            return this;
        }
        public Builder postgresql() {
            this.type = DatabaseType.POSTGRES;
            return this;
        }
        public Builder mongodb() {
            this.type = DatabaseType.MONGODB;
            return this;
        }
        public Builder compressed() {
            this.isCompressed = true;
            return this;
        }
        public Database build(){
            boolean isValid =validate();
            if(!isValid){
                throw  new RuntimeException("Wrong Port for Mysql database!");
            }
            Database database= new Database();
            database.name=this.name;
            database.type=this.type;
            database.port=this.port;
            database.isCompressed=this.isCompressed;
            database.userName=this.userName;
            database.password=this.password;
            return database;
        }

        private boolean validate(){
            if(this.type==DatabaseType.MY_SQL && this.port !=3306){
               return false;
            }
            return  true;
        }
    }
}
