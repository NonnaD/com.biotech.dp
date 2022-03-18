package observer;

public interface Subject {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers();

    //this method signatures do not belong to the Subject logic
    //instead we have to create interface AbstractFDA implements Subject
    Drug getLatestApprovedDrug();
    void approveNewDrug(String drugName, long ndc);
}
