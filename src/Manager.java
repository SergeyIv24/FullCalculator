import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SortedMap;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    CheckerInput checkerInput;
    OrdinaryCalculator calculator;

    public void userMenu() {
        System.out.println("Выберите, действие: ");
        System.out.println("1 - Решить выражение.");
        System.out.println("2 - Перевод выражения в обратную польскую запись.");
        System.out.println("3 - Перевод в другую систему счисления.");
        System.out.println("4 - Вычислить выражение в другой СИ");
        System.out.println("5 - Перевод десятичной системы счисления в римскую");
        System.out.println("6 - Перевод из римской системы счисления в десятичную");
        System.out.println("7 - Выход");
    }
    public void interactionWithUser() {

        int selectionCalculator = 0;
        while (true) {
            try {
                userMenu();
                selectionCalculator = Integer.parseInt(scanner.next());
                break;
            } catch (Exception exception) {
                System.out.println("Введено не число!");
            }
        }




        switch (selectionCalculator) {
            case 1:
                System.out.println("Доступные операции: +, -, *, /, ^.");
                System.out.println("Отрицательные числа вводить в скобках - (-5)");
                System.out.println("Введите выражение: ");

                String expression = scanner.next();
                checkerInput = new CheckerInput(expression);
                try {
                    checkerInput.checkInput();
                    String exp = checkerInput.convertUsualMinusToUnaryMinus();
                    calculator = new OrdinaryCalculator(exp);
                    System.out.println("Результат: " + calculator.solvePolandNotation());
                } catch (UserInoutException exception) {
                    System.out.println(exception.getMessage());
                } finally {
                    interactionWithUser();
                }
                break;

            case 2:
                System.out.println("Введите выражение: ");
                System.out.println("Отрицательные числа вводить в скобках - (-5)");
                String expressionForPoland = scanner.next();
                checkerInput = new CheckerInput(expressionForPoland);
                try {
                    checkerInput.checkInput();
                    String exp1 = checkerInput.convertUsualMinusToUnaryMinus();
                    calculator = new OrdinaryCalculator(exp1);
                    System.out.println("Результат: " + calculator.makeInvertPolandNotation());
                } catch (UserInoutException exception) {
                    System.out.println(exception.getMessage());
                } finally {
                    interactionWithUser();
                }
                break;

            case 3:

                int systemFrom = 0;
                while (true) {
                    try {
                        System.out.println("Введите систему счисления из которой нужен перевод: ");
                        systemFrom = Integer.parseInt(scanner.next());
                        break;
                    } catch (Exception e) {
                        System.out.println("Неверный ввод");
                    }
                }
                int systemTo = 0;
                while (true) {
                    try {
                        System.out.println("Введите систему счисления в которую нужно перевести: ");
                        systemTo = Integer.parseInt(scanner.next());
                        break;
                    } catch (Exception e) {
                        System.out.println("Неверный ввод");
                    }
                }

                System.out.println("Введите число: ");

                if (systemFrom == 10) {
                    int number = scanner.nextInt();
                    System.out.println(ConvertToDifferentSystem.convertToDiffSystemFrom10(number, systemTo));
                } else if (systemTo == 10) {
                    String numStr = scanner.next();
                    System.out.println(ConvertToDifferentSystem.convertFromDiffSystemTo10(numStr, systemFrom));
                } else {
                    String numStr = scanner.next();
                    long numIn10 = ConvertToDifferentSystem.convertFromDiffSystemTo10(numStr, systemFrom);
                    System.out.println(ConvertToDifferentSystem.convertToDiffSystemFrom10(numIn10, systemTo));
                }
                break;

            case 4:
                int userSystem = 0;
                while (true) {
                    System.out.println("Укажите систему счисления в которой нужно получить результат:");
                    try {
                        userSystem = Integer.parseInt(scanner.next());
                        break;
                    } catch (Exception e) {
                        System.out.println("Введено не число!");
                    }
                }

                System.out.println("Введите математическое выражение для расчета (в десятичной системе:)");
                String userExp = scanner.next();
                checkerInput = new CheckerInput(userExp);
                try {
                    checkerInput.checkInput();
                    System.out.println(ConvertToDifferentSystem.calculateTotal(userExp, userSystem));
                } catch (UserInoutException exception) {
                    System.out.println(exception.getMessage());
                } finally {
                    interactionWithUser();
                }
                break;
            case 7:
                System.out.println("Выход...");
                break;
            default:
                System.out.println("Неизвестная команда");
                break;
        }

    }

}
