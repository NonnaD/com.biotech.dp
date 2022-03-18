package observer.pharmacies;

import observer.Drug;
import observer.Subject;
import observer.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class WalnutPharmacy implements Subscriber {
    //we keep reference to subject in subscriber to allow us to unsubscribe later
    Subject subject;
    List<Drug> drugs = new ArrayList<>();

    public WalnutPharmacy(Subject subject) {
        this.subject = subject;
    }

    @Override
    /**
     * We repeat the same functionality for drug update
     * instead we can create some Drugregister class
     * and allow for each pharmacy HAS-A relationship
     */
    public void updateDrugRegister() {
        Drug newDrug = getSubject().getLatestApprovedDrug();
        drugs.add(newDrug);
        System.out.println("New Drug approved by FDA" + newDrug.getName());
    }


    @Override
    public Subject getSubject() {
        return subject;
    }
}
