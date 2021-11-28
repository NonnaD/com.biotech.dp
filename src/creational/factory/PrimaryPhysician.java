package creational.factory;

public class PrimaryPhysician implements Provider{
    @Override
    public String degree() {
        return "DM";
    }

    @Override
    public String genNpi() {
        return "Primary Physician npi";
    }

    @Override
    public String[] procedures() {
        return new String[]{"Diagnosis", "Prescribe medication", "Prescribe vaccine"};
    }

    @Override
    public String[] permissions() {
        return new String[]{"See patient", "Prescribe medication", "Perform minor surgery"};
    }
}
