package my.project.fullCalculator.calculators;
import java.util.HashMap;
import java.util.Map;

public class OrdinaryCalculator implements Calculator {
    private final String expression; //Входное выражение
    private final Map<Character, Integer> mathSymbolPriority;
    private final Stack<Character> stackForChar;
    private final Stack<String> stackForNumbers;
    private String polandExpression = ""; //Выходная строка в польской нотации
    private final StringBuilder polandExpBuilder = new StringBuilder();

    public OrdinaryCalculator(String expression) {
        this.expression = expression;
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

    //Проверка на двухзначные и n - значные числа
    public int makeNum(char[] exp, int startIndex) { // Принимает индекс символа из выражения, который нужно проверить
        int indexContinue = 0; //Стартовое значение индекса для возврата
        for (int i = startIndex; i < exp.length; i++) { //Цикл по математическому выражению
            if (Character.isDigit(exp[i]) || (exp[i] == '.')) { //Если цифра
                polandExpBuilder.append(exp[i]); //Добавление к выходной строке
                indexContinue = i; //Индекс проверенного элемента
            } else { //Если не цифра, завершение цикла, возврат индекса для продолжения цикла по выражению
                polandExpBuilder.append(" ");
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
                    polandExpBuilder.append(" ");
                }
                i = makeNum(arrExpression, i); //Добавить число со всеми разрядами в выходную строку
            } else if (arrExpression[i] == '~') {
                polandExpBuilder.append(arrExpression[i]);
            } else { //Если символ, то добавление в стек
                polandExpBuilder.append(" ");
                addToStack(arrExpression[i]); //Алгоритм управления стеком
            }
        }
        //polandExpression = polandExpBuilder.toString();
        //Если элементы выражения закончились, а стек еще не пуст
        while (!stackForChar.getStack().isEmpty()) {
            char sym = stackForChar.pop(); //Выталкивание элемента
            if ((sym != ')') && (sym != '(')) { //Если не скобка
                polandExpBuilder.append(" ").append(sym); //Добавление к выходной строке
            }
        }
        polandExpression = polandExpBuilder.toString();
        return polandExpression.trim().replaceAll(" {2}", " ").replaceAll(" {2}", " ")
                .replaceAll(" {2}", " ");// Удаление лишних пробелов
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
                        polandExpBuilder.append(" ").append(sym); //Если вытолкнута не скобка, добавление к выходной строке
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
                        polandExpBuilder.append(" ").append(sym);
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
                arrPolandExp[i] = exchangeUnaryMinus(arrPolandExp[i]);
            }
            if (isNumber(arrPolandExp[i])) { //Если число, включая отрицательные
                stackForNumbers.push(arrPolandExp[i]); //В стек
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

    @Override
    public Double makeTotal() {
        StringBuilder totalStrBuilder = new StringBuilder();
        while (stackForNumbers.getStackIterator() != - 1) { //Пока стек не пустой
            String totalSym = stackForNumbers.pop().trim(); //Выталкивание из стека
            if (!totalSym.isBlank()) { //Если не пробел totalSym != ' '
                totalStrBuilder.append(totalSym); //Добавление к строке
            }
        }
        return Double.parseDouble(totalStrBuilder.toString());
    }

    public void solveExpression(String mathSymbol) {
        double number1 = parseNumberFromStack();
        double number2 = parseNumberFromStack();
        double result = 0;
        String resultStr = "";

        //Переключение математической операции
        result = switch (mathSymbol) {
            case "+" -> number1 + number2;
            case "-" -> number2 - number1;
            case "*" -> number1 * number2;
            case "/" -> number2 / number1;
            case "^" -> Math.pow(number2, number1);
            default -> result;
        };
        resultStr = " " + resultStr + result;
        stackForNumbers.push(resultStr); //Возврат значения в стек
    }

    public double parseNumberFromStack() {
        if (!stackForNumbers.isEmpty()) {
            return Double.parseDouble(stackForNumbers.pop());
        }
        return 0.0;
    }

    private static String exchangeUnaryMinus(String inputNum) {
        return inputNum.replaceAll("~", "-");
    }

    //Проверка является ли строка числом
    private static boolean isNumber(String inputNum) {
        try {
            Double number = Double.parseDouble(inputNum);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
