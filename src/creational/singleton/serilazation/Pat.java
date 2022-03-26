package creational.singleton.serilazation;

import java.io.*;

public class Pat implements Serializable {
    private String name;
    private int age;

    public Pat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Runner{

    /**
     * Serialization in java is a mechanism of writing the state of an object into a byte stream.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Pat p1 = new Pat("Alex", 34);

        //Serialize object to byte stream
        File piFile = new File("pat.ser");
        FileOutputStream fos = new FileOutputStream(piFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p1);

        //Deserialize object from file
        FileInputStream fis = new FileInputStream(piFile);
        ObjectInputStream ois = new ObjectInputStream(fis);

        /**
         * Note p1 and p2 are not reference to the same object in memory
         * They are 2 different objects - that's why we want to override readResolve() function
         */
        Pat p2 = (Pat) ois.readObject();
        p1.setName("Test");
        System.out.println(p2.getName());
        System.out.println(p1.getName());
    }
}
