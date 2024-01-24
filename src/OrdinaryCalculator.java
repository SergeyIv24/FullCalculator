
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
/*        for (Character sym : stack.getStack()) {
            if ((sym == symbol) && ((symbol != ')') && (symbol != '('))) {
                output = output + stack.pop();
                stack.push(symbol);
                return;
            }
        }*/

        if ((symbol != ')') && (symbol != '(') && (!stack.getStack().contains('('))) {
            char sym = stack.pop();
            if ((sym != ')') && (sym != '(')) {
                output = output + sym;
            }
            stack.push(symbol);
            return;
        }



        if (stack.getStackIterator() != -1) {
            if ((symbol == ')') && (stack.getStack().contains('('))) {
                for (int i = 0; i < stack.getStack().size(); i++) {
                    char sym = stack.pop();
                    if ((sym != ')') && (sym != '(')) {
                        output = output + sym;
                    }
                }
                if (!stack.getStack().isEmpty()) {
                    char sym = stack.pop();
                    if ((sym != ')') && (sym != '(')) {
                        output = output + sym;
                    }
                }
                return;
            }
        }


        stack.push(symbol);
    }











}



/*
        for (Character sym : stack.getStack()) {
                if ((sym == symbol) && ((symbol != ')') && (symbol != '('))) {
                output = output + stack.pop();
                stack.push(symbol);
                return;
                }
                }*/
