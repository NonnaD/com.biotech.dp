package creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LazySingleton {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /**
         * Multithreading access
         */
        //Lambda initialization of anonymous runnable
        Thread thread1 = new Thread(() -> { DBDriverLazy driver = DBDriverLazy.getInstance(); });

        //old way of Runnable functional interface call
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                DBDriverLazy driver1 = DBDriverLazy.getInstance();
            }});

        thread1.start();
        thread2.start();

        /** Handling serialization - by default deserialization returns new object*/
        DBDriverLazy driverObject = DBDriverLazy.getInstance();
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("object.ser")));
        os.writeObject(driverObject);

        //we overrideed readResolve() function and it should return the same instance
        DBDriverLazy driverObject2 = (DBDriverLazy) new ObjectInputStream(new FileInputStream(new File("object.ser"))).readObject();
        System.out.println(driverObject2 == driverObject); //will return true


        /** Java Reflection is another thing that can break our Singleton
         * It allows us to change the access type for Constructor at runtime*/
         Constructor[] constructors = DBDriverLazy.class.getDeclaredConstructors();
         DBDriverLazy newObjectFroSingleton = null;

         for (Constructor c: constructors){
             //changed access to public
             c.setAccessible(true);
             try {
                 newObjectFroSingleton = (DBDriverLazy) c.newInstance();
             } catch (InstantiationException | InvocationTargetException | IllegalAccessException exc) {
                 exc.printStackTrace();
             }
         }

        System.out.println(driverObject.hashCode() == driverObject2.hashCode());        //false
        System.out.println(newObjectFroSingleton.hashCode() == driverObject.hashCode()); //false
    }


}

class DBDriverLazy implements Serializable, Cloneable {
    //declare static instance of the class do not init
    // volatile keyword here makes sure that
    // the changes made in one thread are
    // immediately reflect in other thread
    private volatile static DBDriverLazy driver;
    private DBDriverLazy() {
        System.out.println("DB driver Initialized");
    }

    /**
     * Provide public static method which returns static object of this class
     * before return object check if driver == null (object called for the first time)
     * create new object and return
     * else return existing object
     *
     * To avoid multithreading conflict when 2 threads enter at the same time
     * Use double check locking
     *
     * We can use synchronized but it's very resource consuming each thread should wait until previous complete
     */
    public static DBDriverLazy getInstance(){
        if (driver == null) {
            /**
             * We add synchronized block only at driver creation step
             * instead of synchronize the entire function and blocking it for other threads
             */
            synchronized (DBDriverLazy.class){
                if (driver == null) driver = new DBDriverLazy();
            }
        }
        return driver;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton object - Clone is not supported");
    }

    @Serial
    public Object readResolve(){
        return driver;
    }
}
