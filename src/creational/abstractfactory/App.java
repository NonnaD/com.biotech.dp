package creational.abstractfactory;

import creational.abstractfactory.beans.Medication;

/**
 * Provides and interface for creating of families of related
 * or dependent object without specifying they concrete classes
 *
 * Unlike factory method pattern which constructs single object
 *
 * What if instead of 3 provider types we have 1000
 * and ant to add more?
 * In this case Factory method pattern gets complicated to maintain and update
 *
 */
public class App {

    public static void main(String[] args) {
        //Get Codeine class object
        Medication opioidCodeine = new MedicationFactory().getMedication(new CodeineFactory());
        //Get Tramadol class object
        Medication opioidTramadol = new MedicationFactory().getMedication(new TramadolFactory());
        //Get Amoxicillin class object
        Medication antibioticAmoxicillin = new MedicationFactory().getMedication(new AmoxicillinFactory());
    }
}
