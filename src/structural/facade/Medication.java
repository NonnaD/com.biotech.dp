package structural.facade;

public class Medication {

    private String medName;
    private boolean isNarcotic;

    public Medication(String medName) {
        this.medName = medName;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public boolean isNarcotic() {
        return isNarcotic;
    }

    public void setNarcotic(boolean narcotic) {
        isNarcotic = narcotic;
    }
}
