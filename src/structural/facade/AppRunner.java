package structural.facade;

public class AppRunner {

    public static void main(String[] args) {
        //CASE: Client wants to order medication for Patient
        //instead of writing complex logic of medication order all client needs to do is call orderMedication from facade
        OrderFacade order = new OrderFacade();
        order.orderMedication(3828443535L, 29494844L, "Codeine");
    }
}
