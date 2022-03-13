package structural.startegy.composite;

import structural.startegy.composite.beans.Nurse;
import structural.startegy.composite.beans.Physician;
import structural.startegy.composite.beans.Provider;

import java.util.Collections;

public class AppRunner {
    public static void main(String[] args) {
        Provider nurse = new Nurse();
        nurse.setPrescriberRules(new NotAllowedToPrescribe());

        Provider primaryPhysician = new Physician();
        primaryPhysician.setPrescriberRules(new AllowedToPrescribe());

        nurse.prescribe();
        primaryPhysician.prescribe();
        Collections
    }
}

