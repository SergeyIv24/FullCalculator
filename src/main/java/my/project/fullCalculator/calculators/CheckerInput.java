package my.project.fullCalculator.calculators;

import my.project.fullCalculator.exception.UserInoutException;

public class CheckerInput {

    public static void checkInput(String expression) {
        char[] arrExp = expression.toCharArray();
        for (char symbol : arrExp) {
            if (Character.isLetter(symbol)) {
                throw new UserInoutException("Выражение содержит буквы");
            }
        }
        if (!checkBrackets(expression)) {
            throw new UserInoutException("Не равное количество скобок");
        }
    }



    public static boolean checkBrackets(String expression) {
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

    public static String convertUsualMinusToUnaryMinus(String expression) {
        char[] expressionBySymbols = expression.toCharArray();
        for (int i = 1; i <= expressionBySymbols.length; i++) {
            if (expressionBySymbols[i-1] == '(' && expressionBySymbols[i] == '-') {
                expressionBySymbols[i] = '~';
            }
        }
        StringBuilder exp = new StringBuilder();
        for (char sym : expressionBySymbols) {
            exp.append(sym);
        }
        return exp.toString();

    }


}
