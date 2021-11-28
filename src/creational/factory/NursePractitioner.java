package creational.factory;

public class NursePractitioner implements Provider{
    @Override
    public String degree() {
        return "NP";
    }

    @Override
    public String genNpi() {
        return "NP npi";
    }

    @Override
    public String[] procedures() {
        return new String[]{"Diagnose", "Prescribe medication", "Give Live style advice"};
    }

    @Override
    public String[] permissions() {
        return new String[]{"See patient", "Prescribe medication"};
    }
}
