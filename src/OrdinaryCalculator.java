import java.util.HashMap;
import java.util.Map;

public class OrdinaryCalculator implements Calculator {
    private String expression;
    private char[] mathSymbols;
    private Map<Character, Integer> mathSymbolPriority;
    private Stack<Character> stack;
    private String output = "";

    public OrdinaryCalculator(String expression) {
        this.expression = expression;
        mathSymbols  = new char[]{'(', ')', '+', '-', '*', '/'};
        mathSymbolPriority = new HashMap<>();
        mathSymbolPriority.put(')', 1);
        mathSymbolPriority.put('(', 1);
        mathSymbolPriority.put('+', 2);
        mathSymbolPriority.put('-', 2);
        mathSymbolPriority.put('*', 3);
        mathSymbolPriority.put('/', 3);
        stack = new Stack<>();
    }

    public int makeNum(char[] exp, int startIndex) {
        int indexContinue = 0;
        for (int i = startIndex; i < exp.length; i++) {
            if (Character.isDigit(exp[i])) {
               output += exp[i];
                indexContinue = i;
            } else {
                output += " ";
                return indexContinue;
            }
        }
        return indexContinue;
    }

    public String makeInvertPolandNotation() {
        char[] arrExpression = expression.toCharArray();
        for (int i = 0; i < arrExpression.length; i++) {
            if (Character.isDigit(arrExpression[i])) {
                output += " ";
                i = makeNum(arrExpression, i);

            } else {
                output += " ";
                addToStack(arrExpression[i]);
            }
        }
        while (!stack.getStack().isEmpty()) {
            char sym = stack.pop();
            if ((sym != ')') && (sym != '(')) {
                output = output + " " + sym;
            }

        }

        return output.trim().replaceAll("  ", " ").replaceAll("  ", " ")
                .replaceAll("  ", " ");

    }

    public void addToStack(char symbol) {
        if (stack.getStack().isEmpty()) {
            stack.push(symbol);
            return;
        }

        if ((symbol != ')') && (symbol != '(')) {
            int weightOfSymbol = mathSymbolPriority.get(symbol);
            for (int i = stack.getStackIterator(); i >= 0; i--) {
                char symb = stack.getStack().get(i);
                int weightOfStack = mathSymbolPriority.get(symb);
                if (weightOfSymbol <= weightOfStack) {
                    char sym = stack.pop();
                    if ((sym != ')') && (sym != '(')) {
                        output = output + " " + sym;
                    }
                } else {
                    stack.push(symbol);
                    return;
                }
            }
        }

        if (stack.getStackIterator() != -1) {
            if ((symbol == ')') && (stack.getStack().contains('('))) {
                for (int i = stack.getStackIterator(); i >= -1; i--) {
                    if (stack.getStack().get(stack.getStackIterator()) != '(') {
                        char sym = stack.pop();
                        output = output + " " + sym;
                    } else {
                        stack.pop();
                        return;
                    }
                }

            }
        }
        stack.push(symbol);
    }
}