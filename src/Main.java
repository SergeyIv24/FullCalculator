import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String ex = "((1+2)*(3+4))+10";
        OrdinaryCalculator test = new OrdinaryCalculator(ex);
        System.out.println(test.makeInvertPolandNotation());
        String test1 = "1235";
        char ch = test1.charAt(test1.length()-1);
        //System.out.println(ch);














    }
}
