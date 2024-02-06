import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String ex = "3-(2+(1+1))*(15/(7-(1+1)))*3-(2+(1+1))+15/(7-(1+1))*3-(2+(1+1))";
        OrdinaryCalculator test = new OrdinaryCalculator(ex);
        System.out.println(test.solvePolandNotation());















    }
}
