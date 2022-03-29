package structural.facade;

/**
 * Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system.
 *  All client needs to do to order Medication is Provide ids and med name
 */
public class OrderFacade {

    String orderMedication(Long providerId, Long patientId, String medName){
        //get patient object by Id...I will just create new objects for this example
        var pat = new Patient(patientId);
        //get Provider object by id...I will just create new object for example
        var primary = new Provider(providerId);
        var med = new Medication(medName);
        if(pat.isEligibleForNarcotic() && primary.isHasPermission())
            if(!med.isNarcotic()) return String.format("Ordered medication %s for Patient: %s", med.getMedName(), pat.getName());
        return "Order failed";
    }
}
