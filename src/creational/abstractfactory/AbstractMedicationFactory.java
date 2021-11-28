package creational.abstractfactory;

import creational.abstractfactory.beans.Medication;

public interface AbstractMedicationFactory {
    Medication getMedicationObject();
}
