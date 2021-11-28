package creational.factory;

/** Use Factory design pattern when you want to define the class of an object at runtime.
 It also allows you to encapsulate object creation so that you can keep all object creation code in one place.
 Example: When creating new Provider User provides Provider type at runtime
 */
public class Factory {
    Provider provider;

    public Provider generateProvider(String type){
        switch (type){
            case "Physician": return new PrimaryPhysician();
            case "Nurse Practitioner": return new NursePractitioner();
            case "Dentist": return new Dentist();
            default: return null;
        }
    }
}

