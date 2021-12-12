package structural;

public class Nexium implements Esomeprazole{

    @Override
    public String activePharmIngredient(){
        return "Esomeprazole";
    }

    @Override
    public int dosage() {
        return 200;
    }
}
