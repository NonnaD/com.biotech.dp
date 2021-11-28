package creational.abstractfactory;

import creational.abstractfactory.beans.Amoxicillin;
import creational.abstractfactory.beans.Medication;

public class AmoxicillinFactory implements AbstractMedicationFactory{

    @Override
    public Medication getMedicationObject() {
        return new Amoxicillin();
    }
}
