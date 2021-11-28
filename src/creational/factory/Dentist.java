package creational.factory;

public class Dentist implements Provider{
    @Override
    public String degree() {
        return "DMD";
    }

    @Override
    public String genNpi() {
       return "Dentist npi";
    }

    @Override
    public String[] procedures() {
        return new String[]{"Crown replacement", "3rd molar extraction", "Bone graphing"};
    }

    @Override
    public String[] permissions() {
        return new String[]{"Prescribe medication", "Give sedation", "Perform surgery"};
    }
}
