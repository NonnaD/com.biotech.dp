package creational.abstractfactory;

import creational.abstractfactory.beans.Medication;

public class MedicationFactory {

    public Medication getMedication(AbstractMedicationFactory object){
        return object.getMedicationObject();
    }
}
