package creational.singleton;

public class EagerSingleton {
    DBDriver driver = DBDriver.getInstance();
}

class DBDriver{
    //create static instance of the class
    private static DBDriver driver = new DBDriver();

    //Override constructor to make it private
    private DBDriver() { }

    //provide public static method which returns static object of this class
    public static DBDriver getInstance(){
        return driver;
    }
}
