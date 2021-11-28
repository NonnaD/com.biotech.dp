package creational.builder;

/*
 * Abstract/Interface Builder is not required if class itself is not part of inheritance hierarchy.
 * You can directly create concrete Builder
 */
public interface PatientBuilder {
    PatientBuilder addFirstName(String firstName);
    PatientBuilder addLastName(String lastName);
    PatientBuilder addAge(int age);
    PatientBuilder addTemp(double temp);
    PatientBuilder addAllergies(String... allergies);
    PatientBuilder addBmi(int... bmi);
    Patient build();
}
