package structural.startegy.composite.beans;

import structural.startegy.composite.Prescriber;

public class Physician implements Provider{
    int npi;
    Prescriber prescriber;

    public int getNpi() {
        return npi;
    }

    public void setNpi(int npi) {
        this.npi = npi;
    }

    public Prescriber getPrescriber() {
        return prescriber;
    }

    public void setPrescriber(Prescriber prescriber) {
        this.prescriber = prescriber;
    }

    public boolean prescribe() {
        return prescriber.isAllowedToPrescribe();
    }

    public void setPrescriberRules(Prescriber prescriber) {
        this.prescriber = prescriber;
    }
}
