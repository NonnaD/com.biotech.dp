package observer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FDA implements Subject{
    private List<Subscriber> subscriberList = new LinkedList<>();
    Stack<Drug> approvedDrugs = new Stack<>();

    @Override
    public void subscribe(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    @Override
    public void notifySubscribers(){
        for(Subscriber subscriber: subscriberList){
            subscriber.updateDrugRegister();
        }
    }

    public void approveNewDrug(String drugName, long ndc){
        //drug approval process
        //once new drug is approved its added to the list of approved drugs
        //I used stack DS so our subscribers can get the most recently approved drug
        Drug antiinflam = new Drug(drugName, ndc);
        approvedDrugs.add(antiinflam);
        //once new drug is approved we want to notify the Observers/subscribers
        notifySubscribers();
    }

    public Drug getLatestApprovedDrug() {
        //it's a bad idea to send the reference of the drug object
        //and allow subscriber to modify it
        //instead some drug metadata oo object stated can be transfered
        //but for this example we'll keep it as it is
        return approvedDrugs.peek();
    }
}
