package creational.factory;

import java.util.Scanner;

public class ProviderCreator {
    public static void main(String[] args) {

        //Ask User to provide Provider type
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide provider type you want to create");
        String providerType = scanner.nextLine();

        //Create provider requested by User
        Provider provider = new Factory().generateProvider(providerType);
        System.out.println("Provider - " + provider.degree() + " been created");


    }
}
