package creational.abstractfactory;

import creational.abstractfactory.beans.Medication;
import creational.abstractfactory.beans.Tramadol;

public class TramadolFactory implements AbstractMedicationFactory{

    @Override
    public Medication getMedicationObject() {
        return new Tramadol();
    }
}
