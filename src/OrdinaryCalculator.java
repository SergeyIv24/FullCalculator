
public class OrdinaryCalculator implements Calculator {
    private String expression;
    private char[] mathSymbols;
    Stack<Character> stack;
    String output = "";

    public OrdinaryCalculator(String expression) {
        this.expression = expression;
        mathSymbols  = new char[]{'(', ')', '+', '-', '*'};
        stack = new Stack<>();
    }

    public String makeInvertPolandNotation() {

        char[] arrExpression = expression.toCharArray();
        for (int i = 0; i < arrExpression.length; i++) {
            boolean isThereMathSymbol = false;
            for (int j = 0; j < mathSymbols.length; j++) {
                if (arrExpression[i] == mathSymbols[j]) {
                    isThereMathSymbol = true;
                    addToStack(mathSymbols[j]);
                    break;
                }
            }
            if (!isThereMathSymbol) {
                output = output + arrExpression[i];
            }

        }
        if (!stack.getStack().isEmpty()) {
            output = output + stack.pop();
        }

        return output;

    }

    public void addToStack(char symbol) {
        if (stack.getStack().isEmpty()) {
            stack.push(symbol);
            return;
        }
        for (Character sym : stack.getStack()) {
            if ((sym == symbol) && ((symbol != ')') && (symbol != '('))) {
                output = output + symbol;
                return;
            }
        }
        if ((symbol == ')') && (stack.getStack().contains('('))) {
            for (int i = 0; i < stack.getStack().size(); i++) {
                char sym = stack.pop();
                if ((sym != ')') && (sym != '(')) {
                    output = output + sym;
                }
            }
            stack.clean();
            return;
        }
        stack.push(symbol);
    }





/*    public void checkStack() {
        if (stack.getStack().contains('(') && stack.getStack().contains(')')) {
            for (int i = 0; i < stack.getStack().size(); i++) {
                char symbol = stack.pop();
                if ((symbol != ')') && (symbol != '(')) {
                    output = output + symbol;
                }
            }
            stack.clean();
        }*/
/*        if (stack.getStack().size() > 1) {
            if ((stack.getStack().get(0) != null) && (stack.getStack().get(1) != null)) {
                if (stack.getStack().get(0) == stack.getStack().get(1)) {
                    output = output + stack.pop();
                }
            }
        }*/





}
/*
else if (stack.getStack().get(0) == stack.getStack().get(1)) {
        output = output + stack.pop();
        }*/


/*
        if (stack.getStack().size() > 1) {
                if ((stack.getStack().get(0) != null) && (stack.getStack().get(1) != null)) {
                if (stack.getStack().get(0) == stack.getStack().get(1)) {
                output = output + stack.pop();
                }
                }
                }*/
