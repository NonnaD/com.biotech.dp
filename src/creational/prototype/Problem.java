package creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class Problem {


    String problemName;

    public Problem(String problemName) {
        this.problemName = problemName;
    }


    @Override
    public String toString() {
        return "problemName='" + problemName;
    }
}
