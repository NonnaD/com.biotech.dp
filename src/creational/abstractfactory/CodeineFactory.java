package creational.abstractfactory;

import creational.abstractfactory.beans.Codeine;
import creational.abstractfactory.beans.Medication;

public class CodeineFactory implements AbstractMedicationFactory{
    @Override
    public Medication getMedicationObject() {
        return new Codeine();
    }
}
