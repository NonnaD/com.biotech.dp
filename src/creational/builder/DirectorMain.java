package creational.builder;

public class DirectorMain {
    public static void main(String[] args) {
        Patient patient = new Patient.PatientBuilderImpl()
                        .addAge(22)
                        .addAllergies("Codeine", "Pollen")
                        .addFirstName("Pat")
                        .addLastName("Smith")
                        .addBmi(22,12,45)
                        .addTemp(37.2).build();

        System.out.println(patient);
        //Patient{fullName='Pat Smith', age=22, temp=37.2, allergies=[Codeine, Pollen], bmi=[22, 12, 45]}
    }
}
