package creational.singleton;

public class LazySingleton {

    public static void main(String[] args) {


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


    }


}

class DBDriverLazy{
    //declare static instance of the class do not init
    private static DBDriverLazy driver;
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
}
