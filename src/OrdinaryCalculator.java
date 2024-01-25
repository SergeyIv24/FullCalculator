import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdinaryCalculator implements Calculator {
    private String expression;
    private char[] mathSymbols;
    private Map<Character, Integer> mathSymbolPriority = new HashMap<>();
    private List<Character> plus = new ArrayList<>();
    private List<Character> multy = new ArrayList<>();
    Stack<Character> stack;
    String output = "";

    public OrdinaryCalculator(String expression) {
        this.expression = expression;
        mathSymbols  = new char[]{'(', ')', '+', '-', '*', '/'};
        mathSymbolPriority.put(')', 0);
        mathSymbolPriority.put('(', 0);
        mathSymbolPriority.put('+', 1);
        mathSymbolPriority.put('-', 1);
        mathSymbolPriority.put('*', 3);
        mathSymbolPriority.put('/', 3);
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

        //mathSymbolPriority.get(stack.getStack().get(stack.getStackIterator() - 1));

        if ((symbol != ')') && (symbol != '(')) {
            int weightOfSymbol = mathSymbolPriority.get(symbol);
            int indexSym = stack.getStackIterator();
            char symb = stack.getStack().get(indexSym);
            int weightOfStack = mathSymbolPriority.get(symb);
            //int weightOfStack = mathSymbolPriority.get(stack.getStack().get(stack.getStackIterator() - 1));

            if (weightOfSymbol <= weightOfStack) {
                char sym = stack.pop();
                if ((sym != ')') && (sym != '(')) {
                    output = output + sym;
                }
                stack.push(symbol);
                return;
            } else {
                stack.push(symbol);
                return;
            }
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

        if ((symbol == ')') && (!stack.getStack().contains('('))) {
            char sym = stack.pop();
            if ((sym != ')') && (sym != '(')) {
                output = output + sym;
            }
            stack.push(symbol);
            return;
        }

        stack.push(symbol);









    }


/*    public void addToStack(char symbol) {
        if (stack.getStack().isEmpty()) {
            stack.push(symbol);
            return;
        }




        if ((symbol != ')') && (symbol != '(') && (!stack.getStack().contains('('))) { //Todo Убрать последнее условие
            if (mathSymbolPriority.get(symbol) <= mathSymbolPriority.get(stack.getStack().get(stack.getTopOfStack()))) {
                char sym = stack.pop();
                if ((sym != ')') && (sym != '(')) {
                    output = output + sym;
                }
                stack.push(symbol);
                return;
            } else {
                stack.push(symbol);
                return;
            }
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
    }*/











}



/*
        for (Character sym : stack.getStack()) {
                if ((sym == symbol) && ((symbol != ')') && (symbol != '('))) {
                output = output + stack.pop();
                stack.push(symbol);
                return;
                }
                }*/


/*        for (Character sym : stack.getStack()) {
            if ((sym == symbol) && ((symbol != ')') && (symbol != '('))) {
                output = output + stack.pop();
                stack.push(symbol);
                return;
            }
        }*/