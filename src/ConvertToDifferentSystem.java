import java.util.ArrayList;

public class ConvertToDifferentSystem {

    //Перевод в любую систему счисления до 10 из 10
    public static String convertToDiffSystemFrom10(long number10, int systemTo) {
        String result = "";
        int surplus;

        while (number10 > 1) {
            surplus = (int) (number10 % systemTo);
            number10 = number10 / systemTo;
            result += surplus;
        }

        StringBuilder revResult = new StringBuilder(result).reverse();
        return number10 + revResult.toString();
    }

    //Перевод из любой системы счисления до 10 в 10
    public static int convertFromDiffSystemTo10(String expNot10, int systemFrom) {
        int result = 0;
        char[] arrExp = expNot10.toCharArray();
        int j = arrExp.length - 1;
        for (int i = 0; i < arrExp.length; i++, j--) {
            result = (int) (result + Integer.parseInt(String.valueOf(arrExp[i])) * Math.pow(systemFrom, j));
        }
        return result;
    }

    public static String convertExpressionInSystem10(String exp, int systemFrom) {
        char[] numAndSymbols = exp.toCharArray();
        String newExpression = "";
        String number = "";
        for (char symbol : numAndSymbols) {
            if (Character.isDigit(symbol)) {
                number = number + symbol;
            } else {
                if (!number.isEmpty()) {
                    newExpression = newExpression + convertFromDiffSystemTo10(number, systemFrom);
                }
                newExpression = newExpression + symbol;
                number = "";
            }
        }
        newExpression = newExpression + convertFromDiffSystemTo10(number, systemFrom);

        return newExpression;
    }

    public static String calculateTotal(String exp, int systemFrom) {
        String expression = convertExpressionInSystem10(exp, systemFrom);
        OrdinaryCalculator calculator = new OrdinaryCalculator(expression);
        return convertToDiffSystemFrom10(calculator.solvePolandNotation(), systemFrom);
    }
}
