package structural;

public class EsomeprazoleAdapter implements Omeprazole{
    Esomeprazole esomeprazole;

    public EsomeprazoleAdapter(Nexium nexium) {
        this.esomeprazole = nexium;
    }

    @Override
    public int dosage() {
        return esomeprazole.dosage();
    }

    @Override
    public String activeIng() {
       return esomeprazole.activePharmIngredient();
    }
}
