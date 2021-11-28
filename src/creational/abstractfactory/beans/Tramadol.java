package creational.abstractfactory.beans;

import creational.abstractfactory.AbstractMedicationFactory;

public class Tramadol implements Opioid {

    @Override
    public String getDosage() {
        return className + " Tramadol 100mg";
    }

}
