package structural.startegy.composite.beans;

import structural.startegy.composite.Prescriber;

public interface Provider {
    boolean prescribe();
    void setPrescriberRules(Prescriber prescriber);
}
