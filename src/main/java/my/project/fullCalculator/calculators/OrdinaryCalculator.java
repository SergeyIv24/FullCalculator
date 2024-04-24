package my.project.fullCalculator.calculators;
import java.util.HashMap;
import java.util.Map;

public class OrdinaryCalculator implements Calculator {
    private final String expression; //Входное выражение
    private final char[] mathSymbols;
    private final Map<Character, Integer> mathSymbolPriority;
    private final Stack<Character> stackForChar;
    private final Stack<String> stackForNumbers; //todo изменить на стек для строк
    private String polandExpression = ""; //Выходная строка в польской нотации

    public OrdinaryCalculator(String expression) {
        this.expression = expression;
        mathSymbols  = new char[]{'(', ')', '+', '-', '*', '/'}; //Массив доступных математических операций
        mathSymbolPriority = new HashMap<>(); //Мапа для хранения приоритета математических операций
        mathSymbolPriority.put(')', 1);
        mathSymbolPriority.put('(', 1);
        mathSymbolPriority.put('+', 2);
        mathSymbolPriority.put('-', 2);
        mathSymbolPriority.put('*', 3);
        mathSymbolPriority.put('/', 3);
        mathSymbolPriority.put('^', 4); //Возведение в степень
        mathSymbolPriority.put('~', 5); //Унарный минус для обработки отрицательных операндов
        stackForChar = new Stack<>(); //Объект стек, для хранения операторов
        stackForNumbers = new Stack<>(); //Объект стек, для хранения чисел
    }

    //Проверка на двухзначные и n - значные числа //todo проверка на дробное число
    public int makeNum(char[] exp, int startIndex) { // Принимает индекс символа из выражения, который нужно проверить
        int indexContinue = 0; //Стартовое значение индекса для возврата
        for (int i = startIndex; i < exp.length; i++) { //Цикл по математическому выражению
            if (Character.isDigit(exp[i]) || (exp[i] == '.')) { //Если цифра
               polandExpression += exp[i]; //Добавление к выходной строке
                indexContinue = i; //Индекс проверенного элемента
            } else { //Если не цифра, завершение цикла, возврат индекса для продолжения цикла по выражению
                polandExpression += " ";
                return indexContinue;
            }
        }
        return indexContinue;
    }

    //Метод перевода инфиксной записи в постфиксную
    public String makeInvertPolandNotation() {
        char[] arrExpression = expression.toCharArray(); //Массив символов
        for (int i = 0; i < arrExpression.length; i++) { //Цикл по элементам выражения
            if (Character.isDigit(arrExpression[i])) { //Если символ цифра
                if (i > 0 && arrExpression[i - 1] != '~') {
                    polandExpression += " ";
                }

                i = makeNum(arrExpression, i); //Добавить число со всеми разрядами в выходную строку

            } else if (arrExpression[i] == '~') {
                polandExpression += arrExpression[i];
            } else { //Если символ, то добавление в стек
                polandExpression += " ";
                addToStack(arrExpression[i]); //Алгоритм управления стеком
            }
        }
        //Если элементы выражения закончились, а стек еще не пуст
        while (!stackForChar.getStack().isEmpty()) {
            char sym = stackForChar.pop(); //Выталкивание элемента
            if ((sym != ')') && (sym != '(')) { //Если не скобка
                polandExpression = polandExpression + " " + sym; //Добавление к выходной строке
            }
        }
        return polandExpression.trim().replaceAll("  ", " ").replaceAll("  ", " ")
                .replaceAll("  ", " ");// Удаление лишних пробелов
    }

    //Алгоритм добавления элементов в стек
    public void addToStack(char symbol) {
        //Если стек пуст, добавление символа в стек
        if (stackForChar.getStack().isEmpty()) {
            stackForChar.push(symbol);
            return;
        }
        //Если не скобка
        if ((symbol != ')') && (symbol != '(')) {
            int weightOfSymbol = mathSymbolPriority.get(symbol); //Приоритет входного символа
            for (int i = stackForChar.getStackIterator(); i >= 0; i--) { //Цикл по каждому элементу в стеке
                char symb = stackForChar.getStack().get(i); //Текущий символ
                int weightOfStack = mathSymbolPriority.get(symb); //Приоритет текущего символа
                if (weightOfSymbol <= weightOfStack) { //Если входной символ имеет приоритет меньше, чем текущий
                    char sym = stackForChar.pop(); //Выталкивание элемента из стека
                    if ((sym != ')') && (sym != '(')) {
                        polandExpression = polandExpression + " " + sym; //Если вытолкнута не скобка, добавление к выходной строке
                    }
                } else { //Если входной символ имеет приоритет больше, чем текущий
                    stackForChar.push(symbol); //Добавление в стек
                    return;
                }
            }
        }

        if (stackForChar.getStackIterator() != -1) { //Если закрывающая скобка
            if ((symbol == ')') && (stackForChar.getStack().contains('('))) { //И есть открывающая скобка
                for (int i = stackForChar.getStackIterator(); i >= -1; i--) { //Цикл по элементам стека
                    if (stackForChar.getStack().get(stackForChar.getStackIterator()) != '(') { //Выталкиваются все до первой
                        char sym = stackForChar.pop(); //Открывающей скобки
                        polandExpression = polandExpression + " " + sym;
                    } else {
                        stackForChar.pop(); //Открытая скобка выталкивается и не записывается в выходною строку
                        return;
                    }
                }
            }
        }
        stackForChar.push(symbol); //Если все условия не сработали добавление в стек
    }

    public double solvePolandNotation() {
        String polExp = makeInvertPolandNotation(); //Вызов метода преобразования в обратную польскую нотацию
        String[] arrPolandExp = polExp.split(" ");
        for (int i = 0; i < arrPolandExp.length; i++) {
            if (arrPolandExp[i].contains("~")) {
                arrPolandExp[i] = exchangeUniryMinus(arrPolandExp[i]);
            }
            if (isNumber(arrPolandExp[i])) { //Если число, включая отрицательные
                stackForNumbers.push(arrPolandExp[i]); //В стек
            } else if (arrPolandExp[i].isEmpty() || arrPolandExp[i].isBlank()) { //Если пробел //todo проверка пробелов больше не нужна
                stackForNumbers.push(arrPolandExp[i]); //В стек для разделения чисел
            } else {
                solveExpression(arrPolandExp[i]);
            }
        }
        double total = 0; //Результат
        if (stackForNumbers.getStackIterator() > -1) { //Если в стеке есть числа
            total = makeTotal(); //Вызов метода определения общего результата
        }

        return total;
    }

    //Метод решения обратной польской нотации
/*    public double solvePolandNotation1() {
        String polExp = makeInvertPolandNotation(); //Вызов метода преобразования в обратную польскую нотацию
        char[] arrPolandExp = polExp.toCharArray(); //Строку RPN в массив
        for (int i = 0; i < arrPolandExp.length; i++) { //Цикл по элементам массива
            if (Character.isDigit(arrPolandExp[i])) { //Если цифра
                stackForNumbers.push(Character.toString(arrPolandExp[i])); //В стек
            } else if (arrPolandExp[i] == '~') { //Если унарный минус в стек
                stackForNumbers.push(Character.toString('-')); //Добавляется знак обычного минуса
            } else if (arrPolandExp[i] == ' ') { //Если пробел
                stackForNumbers.push(Character.toString(arrPolandExp[i])); //В стек для разделения чисел
            } else {
                solveExpression(arrPolandExp[i]); //Если оператор, то вычисление двух последних чисел в стеке
            }
        }
        double total = 0; //Результат
        if (stackForNumbers.getStackIterator() > -1) { //Если в стеке есть числа
            total = makeTotal(); //Вызов метода определения общего результата
        }

        return total;
    }*/

    public Double makeTotal() {
        String totalStr = "";
        while (stackForNumbers.getStackIterator() != - 1) { //Пока стек не пустой
            String totalSym = stackForNumbers.pop().trim(); //Выталкивание из стека
            if (!totalSym.isBlank()) { //Если не пробел totalSym != ' '
                totalStr = totalStr + totalSym; //Добавление к строке
            }
        }
        //return Double.parseDouble(totalStr);

/*        StringBuilder totalReverse = new StringBuilder(totalStr).reverse(); //Реверс выражения, так как pop идет с конца
        String totalNum = totalReverse.toString();
        return Double.parseDouble(totalNum);*/
        return Double.parseDouble(totalStr);
    }


    public void solveExpression(String mathSymbol) {
/*        double number1 = findNumberOne(); //Вызов метода преобразования символов стека в число
        double number2 = findNumberTwo(); //Вызов метода преобразования символов стека в число*/
        double number1 = parseNumberFromStack();
        double number2 = parseNumberFromStack();
        double result = 0;
        String resultStr = "";

        //Переключение математической операции
        switch (mathSymbol) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number2 - number1;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number2 / number1;
                break;
            case "^":
                result = Math.pow(number2, number1);
                break;
        }

        resultStr = " " + resultStr + result;
        //stackForNumbers.push(resultStr);
        char[] resArr = resultStr.toCharArray();
        stackForNumbers.push(resultStr); //Возврат значения в стек


/*        for (char num : resArr) {
            stackForNumbers.push(Character.toString(num)); //Возврат значения в стек
        }*/
    }


    public double parseNumberFromStack() {
        String numberOne = "";
        if (!stackForNumbers.isEmpty()) {
            return Double.parseDouble(stackForNumbers.pop());
        }
        return 0.0;
    }

    public double findNumberOne() {
        String numberOne = "";
        int countSpaces = 0; //Разряды числа определяются от пробела до пробела. Крайнее число имеет 2 пробела - до и после числа

        while (countSpaces < 2 && stackForNumbers.getStackIterator() > -1) {
            String symbol = stackForNumbers.pop();
            if (OrdinaryCalculator.isNumber(symbol)) { //Если цифра //todo старый кодCharacter.isDigit(symbol) || symbol == '.'
                numberOne = numberOne + symbol; //Добавление к выходной строке
            } /*else if (symbol == '-') { //Если унарный минус
                numberOne = numberOne + symbol; //Добавление к выходной строке
            }*/ else {
                countSpaces += 1; //Счет количества пробелов
            }
        }

/*        StringBuilder number = new StringBuilder(numberOne);
        number.reverse();
        String num1 = number.toString();
        return Double.parseDouble(num1);*/
        return Double.parseDouble(numberOne);
    }

    public double findNumberTwo() {
        String numberTwo = "";
        int countSpaces = 0; //Разряды числа определяются по количеству пробелов. Для второго числа - один пробел слева.

        while (countSpaces < 2 && stackForNumbers.getStackIterator() > -1) {
            String symbol = stackForNumbers.pop();
            if (OrdinaryCalculator.isNumber(symbol)) { //Если цифра
                numberTwo = numberTwo + symbol; //Добавление к выходной строке
            } /*else if (symbol == '-') { //Если унарный минус
                numberTwo = numberTwo + symbol;
            } */else {
                countSpaces += 1; //Счет количества пробелов
            }
        }

/*        StringBuilder number = new StringBuilder(numberTwo);
        number.reverse();
        String num2 = number.toString();
        return Double.parseDouble(num2);*/
        return Double.parseDouble(numberTwo);
    }

    private static String exchangeUniryMinus(String inputNum) {
        return inputNum.replaceAll("~", "-");
    }


    //Проверка является ли строка числом
    private static boolean isNumber(String inputNum) {
        String num = inputNum;
        if (inputNum.contains("~")) {
            num = exchangeUniryMinus(inputNum);
        }
        try {
            Double number = Double.parseDouble(num);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}