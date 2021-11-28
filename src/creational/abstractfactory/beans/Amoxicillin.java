package creational.abstractfactory.beans;

public class Amoxicillin implements Antibiotics{
    @Override
    public String getAntibioticClass() {
        return "Penicillin-like antibiotics";
    }

    @Override
    public String getDosage() {
        return "Antibiotic: Amoxicillin - 500mg";
    }

}
