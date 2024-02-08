

public class CheckerInput {
    String expression;

    public CheckerInput(String expression) {
        this.expression = expression;
    }

    public boolean checkBrackets() {
        char[] expressionBySymbols = expression.toCharArray();
        int amountOfOpeningBrackets = 0;
        int amountOfClosingBrackets = 0;

        for (char sym : expressionBySymbols) {
            if (sym == '{' || sym == '}' || sym == '[' || sym == ']') {
                return false;
            }
            if (sym == '(') {
                amountOfOpeningBrackets += 1;
            }
            if (sym == ')') {
                amountOfClosingBrackets += 1;
            }
        }
        return amountOfOpeningBrackets == amountOfClosingBrackets;
    }

    public String convertUsualMinusToUnaryMinus() {
        char[] expressionBySymbols = expression.toCharArray();
        for (int i = 1; i <= expressionBySymbols.length; i++) {
            if (expressionBySymbols[i-1] == '(' && expressionBySymbols[i] == '-') {
                expressionBySymbols[i] = '~';
            }
        }
        String exp = "";
        for (char sym : expressionBySymbols) {
            exp += sym;
        }
        return exp;

    }


}