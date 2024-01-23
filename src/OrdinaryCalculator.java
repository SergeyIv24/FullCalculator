
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
                    stack.push(mathSymbols[j]);
                    checkStack();
                    break;
                }
            }
            if (!isThereMathSymbol) {
                output = output + arrExpression[i];
            }
        }
        return output;

    }


    public void checkStack() {
        if (stack.getStack().contains('(') && stack.getStack().contains(')')) {
            for (int i = 0; i < stack.getStack().size(); i++) {
                char symbol = stack.pop();
                if ((symbol != ')') && (symbol != '(')) {
                    output = output + symbol;
                }
            }
            stack.clean();
        }
    }

}
