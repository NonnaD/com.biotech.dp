package observer;

import observer.pharmacies.CSVPharm;
import observer.pharmacies.Walblues;
import observer.pharmacies.WalnutPharmacy;

public class AppRunner {

    /**
     * The observer pattern is a software design pattern in which an object, named the subject,
     * maintains a list of its dependents, called observers, and notifies them automatically of
     * any state changes, usually by calling one of their methods.
     *
     * In this example: FDA will be a Subject, and it will notify all subscribed Pharmacies when new drug is released
     * Once the pharmacy receives notification it will either add the drug to it's list or can ignore the new deug release
     * Pharmacies are allowed to unsubscribe from the FDA notification at anytime

     */
    public static void main(String[] args) {
        Subject fda = new FDA();

        Subscriber cvsPharm = new CSVPharm(fda);
        Subscriber walblues = new Walblues(fda);
        Subscriber walnutPhar = new WalnutPharmacy(fda);

        fda.subscribe(cvsPharm);
        fda.subscribe(walblues);
        fda.subscribe(walnutPhar);

        fda.approveNewDrug("AntiInflm", 38484848);

        //cvsPharm wants to unsubscribe from fda news
        //it will not receive any notifications when  new drugs are approved
        cvsPharm.getSubject().unsubscribe(cvsPharm);

        fda.approveNewDrug("Digestin", 34777575);
    }



}
