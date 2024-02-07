import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String ex = "(~3)+(~4)";
        OrdinaryCalculator test = new OrdinaryCalculator(ex);
        System.out.println(test.solvePolandNotation());

        CheckerInput checkerInput = new CheckerInput(ex);
        System.out.println(checkerInput.convertUsualMinusToUnaryMinus());
        Manager manager = new Manager();
        manager.interactionWithUser();















    }
}
