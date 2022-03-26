package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class User {
    private String username;
    private int password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public User(String username){
        this.username = username;
    }

    public User(String username, int password) {
        this.username = username;
        this.password = password;
    }

    boolean isEncrypted(){
        return true;
    }

}

class Runner{
    public static void main(String[] args) {
        //using reflection lib we can access any properties of our object at Runtime
        Method[]  methods = User.class.getMethods();
        Constructor[] constructors = User.class.getConstructors();
        Field[] fields = User.class.getDeclaredFields();



        //we can even brake the access modifier
        //for private fields I change access modifier to be public, and now I can directly access them
        //even if POJOS are not provided
        //It's just an example and should not be used in real app
        for(Field m: fields){
            System.out.println(m.getName());
            m.setAccessible(true);
        }

    }
}
