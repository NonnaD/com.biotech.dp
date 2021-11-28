package creational.prototype;

public class AppRunner {

    public static void main(String[] args) throws CloneNotSupportedException {
        Patient p1 = new Patient("Pat1");
        p1.setAge(32);
        p1.setProblemList(new Problem("Pollen Allergy"),
                          new Problem("Headache"),
                          new Problem("Flue"));


        Patient p2 = p1.clone();
        p1.getProblemList().remove(1);

        System.out.println(p1);
        System.out.println(p2);


    }
}
