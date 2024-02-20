import java.util.HashMap;

//Todo нет проверки алфавита СИ в двоичную можно записать ABCD

public class ConvertToDifferentSystem {

    private static final HashMap<Long, Character> lettersForNumber = new HashMap<>(); //Число - буква

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
            lettersForNumber.put(i, alphabet[k]); //Заполнение мапы ключами и буквами
        }
    }


    //Перевод в любую систему счисления из 10
    public static String convertToDiffSystemFrom10(long number10, int systemTo) {

       boolean isNegative = false;
        if (number10 < 0) {
            isNegative = true;
            number10 = number10 * (-1);
        }
        String result = "";
        fillMap(systemTo);

        if (systemTo >= 10 && number10 < systemTo) {
            if (lettersForNumber.containsKey(number10)) {
                return result + lettersForNumber.get(number10);
            }

        }

        long surplus;

        while (number10 >= systemTo) {
            surplus =  (number10 % systemTo);
            number10 = number10 / systemTo;

            if (systemTo > 10) { //Если СИ больше 10
                if (lettersForNumber.containsKey(surplus)) { //Если ключ есть в мапе
                    result += lettersForNumber.get(surplus);
                } else {
                    result += surplus;
                }
            } else {
                result += surplus;
            }
        }
        StringBuilder revResult = new StringBuilder(result).reverse();

        if (isNegative) {
            return "-" + number10 + revResult;
        }

        return number10 + revResult.toString();
    }

    //Перевод из любой системы счисления в 10
    public static long convertFromDiffSystemTo10(String expNot10, int systemFrom) {
        fillMap(systemFrom);
        long result = 0;
        char[] arrExp = expNot10.toCharArray();

        boolean isNegative = false;
        if (arrExp[0] == '-') {
            isNegative = true;
        }

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


    //Перевод выражения из пользовательской СИ в 10
    public static String convertExpressionInSystem10(String exp, int systemFrom) {
        char[] numAndSymbols = exp.toCharArray();
        String newExpression = "";
        String number = "";
        for (char symbol : numAndSymbols) {
            if (Character.isDigit(symbol)) { //Если цифра
                number = number + symbol; //К выходной строке
            } else { //Если символ
                if (!number.isEmpty()) { //Если строка не пустая
                    newExpression = newExpression + convertFromDiffSystemTo10(number, systemFrom); //Числов в десятичную
                }
                newExpression = newExpression + symbol; //Добавление символа
                number = ""; //Обнуление строки числа
            }
        }
        newExpression = newExpression + convertFromDiffSystemTo10(number, systemFrom); //Если number содержит значение

        return newExpression;
    }

    //Вычисления выражения, конвертация в пользовательскую СИ
    public static String calculateTotal(String exp, int systemFrom) {
        String expression = convertExpressionInSystem10(exp, systemFrom);
        OrdinaryCalculator calculator = new OrdinaryCalculator(expression);
        return convertToDiffSystemFrom10(calculator.solvePolandNotation(), systemFrom); //Вычисление, возврат в пользовательской СИ
    }
}
