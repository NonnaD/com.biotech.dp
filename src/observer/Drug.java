package observer;

//this should implement some medication Interface
//so we can get different kind of drugs implement it
//but for now we'll keep it simple
public class Drug {
    String name;
    //national drug code identifier
    long ndc;

    public Drug(String name, long ndc) {
        this.name = name;
        this.ndc = ndc;
    }

    public String getName() {
        return name;
    }

    public long getNdc() {
        return ndc;
    }
}
