package structural.adapter;

/**
 * Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.
 * The Adapter pattern allows otherwise incompatible classes to work together by converting the interface of one class into an interface expected by the clients.
 */
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
