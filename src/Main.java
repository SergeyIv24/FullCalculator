import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        OrdinaryCalculator test = new OrdinaryCalculator("((1+2)*(3+4))+10");
        System.out.println(test.makeInvertPolandNotation());

       Map<Character, Integer> mathSymbolPriority = new HashMap<>();
        mathSymbolPriority.put(')', 0);
        mathSymbolPriority.put('(', 0);
        mathSymbolPriority.put('+', 1);
        mathSymbolPriority.put('-', 1);
        mathSymbolPriority.put('*', 3);
        mathSymbolPriority.put('/', 3);

        System.out.println(mathSymbolPriority.get('+'));
        System.out.println(mathSymbolPriority.get('-'));
        System.out.println(mathSymbolPriority.get('*'));
        System.out.println(mathSymbolPriority.get('/'));

    }
}
