package my.project.fullCalculator.calculators;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertToDifferentSystem {

    private static final HashMap<Long, Character> lettersForNumber = new HashMap<>(); //Число - буква
    private static final List<String> mathOperators = List.of("-", "+", "*", "/", "^", "(", ")", "Ln", "Lg");

    private static void fillMap(int system) {
        if (system < 11) {
            return;
        }

        char[] alphabet = new char[36]; //Алфавит для СИ больше 10
        int j = 0;
        for (char i = 'A'; i <= 'Z'; i++, j++) { //Заполнения алфавита заглавными латинскими буквами
            alphabet[j] = i;
        }

        int k = 0;
        for (long i = 10; i < system; i++, k++) {
            lettersForNumber.put(i, alphabet[k]); //Заполнение Map ключами и буквами
        }
    }


    //Перевод в любую систему счисления из 10
    public static String convertToDiffSystemFrom10(long number10, int systemTo) {
       boolean isNegative = false;
        if (number10 < 0) {
            isNegative = true;
            number10 = number10 * (-1);
        }

        StringBuilder resultBuilder = new StringBuilder();
        fillMap(systemTo);

        if (systemTo >= 10 && number10 < systemTo) {
            if (lettersForNumber.containsKey(number10)) {
                return "" + lettersForNumber.get(number10);
            }
        }
        long surplus;
        while (number10 >= systemTo) {
            surplus =  (int) (number10 % systemTo);
            number10 = number10 / systemTo;

            if (systemTo > 10) { //Если СИ больше 10
                if (lettersForNumber.containsKey(surplus)) { //Если ключ есть в Map
                    resultBuilder.append(lettersForNumber.get(surplus));
                } else {
                    resultBuilder.append(surplus);
                }
            } else {
                resultBuilder.append(surplus);
            }
        }

        if (isNegative) {
            return "-" + number10 + resultBuilder.reverse();
        }
        return number10 + resultBuilder.reverse().toString();
    }

    //Перевод числа из любой системы счисления в 10
    public static long convertFromDiffSystemTo10(String expNot10, int systemFrom) {
        fillMap(systemFrom);
        long result = 0;
        char[] arrExp = expNot10.toCharArray();

        boolean isNegative = arrExp[0] == '-';

        int j = arrExp.length - 1;
        for (int i = 0; i < arrExp.length; i++, j--) {
            if (!Character.isDigit(arrExp[i])) {
                for (long key : lettersForNumber.keySet()) {
                    if (lettersForNumber.get(key) == arrExp[i]) {
                        result = (long) (result + (key * Math.pow(systemFrom, j)));
                    }
                }
            } else {
                result = (long) (result + Integer.parseInt(String.valueOf(arrExp[i])) * Math.pow(systemFrom, j));
            }
        }
        if (isNegative) {
            result = result * (-1);
        }

        return result;
    }

    //Вычисления выражения, конвертация в пользовательскую СИ
    public static String calculateTotal(String exp, int systemFrom, int systemTo) {
        //String expression = convertExpressionInSystem10(exp, systemFrom);
        String expression = convertExpressionTo10System(exp, systemFrom);
        OrdinaryCalculator calculator = new OrdinaryCalculator(expression);
        return convertToDiffSystemFrom10((int) calculator.solvePolandNotation(), systemTo); //Вычисление, возврат в пользовательской СИ
    }

    //Конвертация выражения в десятичную систему
    public static String convertExpressionTo10System(String exp, int systemFrom) {
       String newExp = Arrays.stream(exp.split(""))
               .map(symbol -> {
                   if (isMathOperator(symbol)) {
                       return " " + symbol + " ";
                   }
                   return symbol;
               }).collect(Collectors.joining());

       return Arrays.stream(newExp.split(" "))
               .map(num -> {
                   if (!isMathOperator(num) && !num.isBlank()) {
                       return String.valueOf(convertFromDiffSystemTo10(num, systemFrom));
                   }
                   return num;
               })
               .filter(symbol -> !symbol.isBlank() && !symbol.isEmpty())
               .collect(Collectors.joining());
    }

    //Является ли строка математическим оператором
    private static boolean isMathOperator(String str) {
        return mathOperators.contains(str);
    }

}
