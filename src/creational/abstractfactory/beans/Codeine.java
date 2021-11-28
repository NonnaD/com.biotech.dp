package creational.abstractfactory.beans;

public class Codeine implements Opioid {

    @Override
    public String getDosage() {
        return className + " Codeine " + "250 g";
    }
}
