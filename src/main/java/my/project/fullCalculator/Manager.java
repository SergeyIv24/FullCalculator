package my.project.fullCalculator;
import my.project.fullCalculator.calculators.CheckerInput;
import my.project.fullCalculator.calculators.ConvertToDifferentSystem;
import my.project.fullCalculator.calculators.ConverterRomanSystem;
import my.project.fullCalculator.calculators.OrdinaryCalculator;
import my.project.fullCalculator.exception.UserInoutException;

import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
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
        int selectionCalculator;
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

                try {
                    CheckerInput.checkInput(expression);
                    String exp = CheckerInput.convertUsualMinusToUnaryMinus(expression);
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
                try {
                    CheckerInput.checkInput(expressionForPoland);
                    String exp1 = CheckerInput.convertUsualMinusToUnaryMinus(expressionForPoland);
                    calculator = new OrdinaryCalculator(exp1);
                    System.out.println("Результат: " + calculator.makeInvertPolandNotation());
                } catch (UserInoutException exception) {
                    System.out.println(exception.getMessage());
                } finally {
                    interactionWithUser();
                }
                break;

            case 3:
                int systemFrom;
                while (true) {
                    try {
                        System.out.println("Введите систему счисления из которой нужен перевод: ");
                        systemFrom = Integer.parseInt(scanner.next());
                        break;
                    } catch (Exception e) {
                        System.out.println("Неверный ввод");
                    }
                }
                int systemTo;
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
                    int number;
                    while (true) {
                        try {
                            number = Integer.parseInt(scanner.next());
                            break;
                        } catch (Exception e) {
                            System.out.println("Ошибка ввода");
                        }
                    }
                    System.out.println(ConvertToDifferentSystem.convertToDiffSystemFrom10(number, systemTo));
                } else if (systemTo == 10) {

                    try {
                        String numStr = scanner.next();
                        CheckerInput.checkInput(numStr);
                        System.out.println(ConvertToDifferentSystem.convertFromDiffSystemTo10(numStr, systemFrom));
                    } catch (UserInoutException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        interactionWithUser();
                    }

                } else {
                    try {
                        String numStr = scanner.next();
                        CheckerInput.checkInput(numStr);
                        long numIn10 = ConvertToDifferentSystem.convertFromDiffSystemTo10(numStr, systemFrom);
                        System.out.println(ConvertToDifferentSystem.convertToDiffSystemFrom10(numIn10, systemTo));
                    } catch (UserInoutException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        interactionWithUser();
                    }
                }
                break;

            case 4:
                int userSystem;
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
                try {
                    CheckerInput.checkInput(userExp);
                    System.out.println(ConvertToDifferentSystem.calculateTotal(userExp, userSystem));
                } catch (UserInoutException exception) {
                    System.out.println(exception.getMessage());
                } finally {
                    interactionWithUser();
                }
                break;

            case 5:
                long numberToConvert;
                while (true) {
                    try {
                        System.out.println("Введите число в десятичной системе (от 1 до 3999 включительно):");
                        numberToConvert = Long.parseLong(scanner.next());
                        if ((numberToConvert > 3999) | (numberToConvert < 1)) {
                            System.out.println("Введенное число менее 1 или более 3999");
                            continue;
                        }
                        System.out.println("Результат: " + ConverterRomanSystem.numberToRoman(numberToConvert));
                        break;
                    } catch (Exception e) {
                        System.out.println("Неверный ввод!");
                    } finally {
                        interactionWithUser();
                    }
                }
                break;

            case 6:
                System.out.println("Введите число в римской системе счисления:");
                String romanNumber = scanner.next();
                System.out.println("В десятичной системе: " + ConverterRomanSystem.romanToInt(romanNumber));
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
