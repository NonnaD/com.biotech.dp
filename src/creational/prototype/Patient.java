package creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Patient implements Cloneable{
    private String patName;
    private int age;
    List<Problem> problemList;


    public Patient(String patName) {
        this.patName = patName;
        this.problemList = new ArrayList<>();
    }

    public List<Problem> getProblemList() { return problemList; }

    public void setProblemList(Problem ...problem) {
        if (problemList == null) this.problemList = new ArrayList<>();
        for(Problem p: problem ) problemList.add(p);
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Patient clone() throws CloneNotSupportedException {
        Patient cloned = new Patient(this.patName);
        cloned.age = this.age;
        /**
         * Deep cloning - for all reference type variables
         */
        for (Problem problem : this.getProblemList()) cloned.setProblemList(problem);

        return cloned;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patName='" + patName + '\'' +
                ", age=" + age +
                ", problemList=" + problemList +
                '}';
    }
}
