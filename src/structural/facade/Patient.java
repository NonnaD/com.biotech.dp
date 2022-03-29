package structural.facade;

import creational.factory.Provider;

public class Patient {
    private String name;
    private Long id;
    private boolean IsEligibleForNarcotic;

    public Patient(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEligibleForNarcotic() {
        return IsEligibleForNarcotic;
    }

    public void setEligibleForNarcotic(boolean eligibleForNarcotic) {
        IsEligibleForNarcotic = eligibleForNarcotic;
    }
}
