package creational.builder;

/**
 * Buildr here is a separate class
 * but it can be implemented as inner static class in Patient class
 */
public class PatientBuilderImpl1 implements PatientBuilder{
    private String firstName;
    private String lastName;
    private int age;
    private double temp;
    private String[] allergies;
    private int[] bmi;

    public Patient build(){
        return new Patient(firstName + " " + lastName, age, temp, allergies, bmi); }

    @Override
    public PatientBuilder addFirstName(String firstName) {
        this.firstName = firstName;
        return this; }

    @Override
    public PatientBuilder addLastName(String lastName) {
        this.lastName = lastName;
        return this; }

    @Override
    public PatientBuilder addAge(int age) {
        this.age = age;
        return this; }

    @Override
    public PatientBuilder addTemp(double temp) {
        this.temp = temp;
        return this; }

    @Override
    public PatientBuilder addAllergies(String... allergies) {
        this.allergies = allergies;
        return this;
    }

    @Override
    public PatientBuilder addBmi(int... bmi) {
        this.bmi = bmi;
        return this; }
}
