package structural.unknown;

public class AppRunner {
    public static void main(String[] args) {
        Prescription prescription = new Prescription();
        prescription.prescribeProtonPumpInhibitor(new Prilosec());

        System.out.println();
        System.out.println("New prescription policy applied");
        prescription.prescribeProtonPumpInhibitor(new EsomeprazoleAdapter(new Nexium()));


     
    }
}

class Prescription {

    void prescribeProtonPumpInhibitor(Omeprazole medication){
        System.out.println("Active ingredient: " + medication.activeIng());
        System.out.println("Dosage: " + medication.dosage());
    }
}




