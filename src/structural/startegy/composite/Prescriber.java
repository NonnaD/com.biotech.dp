package structural.startegy.composite;

public interface Prescriber {
    boolean isAllowedToPrescribe();
}

class AllowedToPrescribe implements Prescriber{

    @Override
    public boolean isAllowedToPrescribe() {
        System.out.println("This provider allowed to prescribe");
        return true;
    }
}


class NotAllowedToPrescribe implements Prescriber{

    @Override
    public boolean isAllowedToPrescribe() {
        System.out.println("This provider not allowed to prescribe");
        return false;
    }
}
