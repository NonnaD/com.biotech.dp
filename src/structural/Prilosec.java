package structural;

public class Prilosec implements Omeprazole{

    @Override
    public String activeIng(){
        return  "Omeprazole";
    }

    @Override
    public int dosage() {
        return 500;
    }
}
