package creational.builder;

import java.util.Arrays;

public class Patient {
    private String fullName;
    private int age;
    private double temp;
    private String[] allergies;
    private int[] bmi;

    public Patient(String fullName, int age, double temp, String[] allergies, int[] bmi) {
        this.fullName = fullName;
        this.age = age;
        this.temp = temp;
        this.allergies = allergies;
        this.bmi = bmi;
    }

    public String getFullName() { return fullName; }
    public int getAge() { return age; }
    public double getTemp() { return temp; }
    public String[] getAllergies() { return allergies; }
    public int[] getBmi() { return bmi; }

    @Override
    public String toString() {
        return "Patient{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", temp=" + temp +
                ", allergies=" + Arrays.toString(allergies) +
                ", bmi=" + Arrays.toString(bmi) +
                '}';
    }

    /**
     * Builder created as an inner static class
     */
    public static class PatientBuilderImpl implements PatientBuilder{
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
}
