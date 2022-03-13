package structural.startegy.composite.beans;

import structural.startegy.composite.Prescriber;

public class Nurse implements Provider{
    String specialization;
    Prescriber prescriber;

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public boolean prescribe() {
        return prescriber.isAllowedToPrescribe();
    }

    public void setPrescriberRules(Prescriber prescriber) {
        this.prescriber = prescriber;
    }
}
