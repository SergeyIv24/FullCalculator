import java.util.HashMap;
import java.util.Map;

public class OrdinaryCalculator implements Calculator {
    private final String expression; //Входное выражение
    private char[] mathSymbols;
    private Map<Character, Integer> mathSymbolPriority;
    private Stack<Character> stack;
    private String output = ""; //Выходная строка в польской нотации

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
        stack = new Stack<>(); //Объект стек, для хранения операторов
    }

    //Проверка на двухзначные и n - значные числа
    public int makeNum(char[] exp, int startIndex) { // Принимает индекс символа из выражения, который нужно проверить
        int indexContinue = 0; //Стартовое значение индекса для возврата
        for (int i = startIndex; i < exp.length; i++) { //Цикл по математическому выражению
            if (Character.isDigit(exp[i])) { //Если цифра
               output += exp[i]; //Добавление к выходной строке
                indexContinue = i; //Индекс проверенного элемента
            } else { //Если не цифра, завершение цикла, возврат индекса для продолжения цикла по выражению
                output += " ";
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
                output += " ";
                i = makeNum(arrExpression, i); //Добавить число со всеми разрядами в выходную строку

            } else { //Если символ, то добавление в стек
                output += " ";
                addToStack(arrExpression[i]); //Алгоритм управления стеком
            }
        }
        //Если элементы выражения закончились, а стек еще не пуст
        while (!stack.getStack().isEmpty()) {
            char sym = stack.pop(); //Выталкивание элемента
            if ((sym != ')') && (sym != '(')) { //Если не скобка
                output = output + " " + sym; //Добавление к выходной строке
            }
        }
        return output.trim().replaceAll("  ", " ").replaceAll("  ", " ")
                .replaceAll("  ", " ");// Удаление лишних пробелов
    }

    //Алгоритм добавления элементов в стек
    public void addToStack(char symbol) {
        //Если стек пуст, добавление символа в стек
        if (stack.getStack().isEmpty()) {
            stack.push(symbol);
            return;
        }
        //Если не скобка
        if ((symbol != ')') && (symbol != '(')) {
            int weightOfSymbol = mathSymbolPriority.get(symbol); //Приоритет входного символа
            for (int i = stack.getStackIterator(); i >= 0; i--) { //Цикл по каждому элементу в стеке
                char symb = stack.getStack().get(i); //Текущий символ
                int weightOfStack = mathSymbolPriority.get(symb); //Приоритет текущего символа
                if (weightOfSymbol <= weightOfStack) { //Если входной символ имеет приоритет меньше, чем текущий
                    char sym = stack.pop(); //Выталкивание элемента из стека
                    if ((sym != ')') && (sym != '(')) {
                        output = output + " " + sym; //Если вытолкнута не скобка, добавление к выходной строке
                    }
                } else { //Если входной символ имеет приоритет больше, чем текущий
                    stack.push(symbol); //Добавление в стек
                    return;
                }
            }
        }

        if (stack.getStackIterator() != -1) { //Если закрывающая скобка
            if ((symbol == ')') && (stack.getStack().contains('('))) { //И есть открывающая скобка
                for (int i = stack.getStackIterator(); i >= -1; i--) { //Цикл по элементам стека
                    if (stack.getStack().get(stack.getStackIterator()) != '(') { //Выталкиваются все до первой
                        char sym = stack.pop(); //Открывающей скобки
                        output = output + " " + sym;
                    } else {
                        stack.pop(); //Открытая скобка выталкивается и не записывается в выходною строку
                        return;
                    }
                }

            }
        }
        stack.push(symbol); //Если все условия не сработали добавление в стек
    }

    //Метод решения обратной польской нотации
}