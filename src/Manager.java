import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    CheckerInput checkerInput;
    OrdinaryCalculator calculator;

    public void interactionWithUser() {
        System.out.println("Выберите, действие: ");
        System.out.println("1 - Решить выражение.");
        System.out.println("2 - Перевод выражения в обратную польскую запись.");
        System.out.println("3 - Перевод в другую систему счисления.");
        System.out.println("4 - Вычислить выражение в другой СИ");

        int selectionCalculator = scanner.nextInt();

        switch (selectionCalculator) {
            case 1:
                System.out.println("Доступные операции: +, -, *, /, ^.");
                System.out.println("Отрицательные числа вводить в скобках - (-5)");
                System.out.println("Введите выражение: ");
                String expression = scanner.next();
                checkerInput = new CheckerInput(expression);
                boolean checkBrackets = checkerInput.checkBrackets();
                String exp = checkerInput.convertUsualMinusToUnaryMinus();
                if (checkBrackets) {
                    calculator = new OrdinaryCalculator(exp);
                    System.out.println("Результат: " + calculator.solvePolandNotation());
                } else {
                    System.out.println("Проверьте ввод и попробуйте еще раз!");
                }
                break;

            case 2:
                System.out.println("Введите выражение: ");
                System.out.println("Отрицательные числа вводить в скобках - (-5)");
                String expressionForPoland = scanner.next();
                checkerInput = new CheckerInput(expressionForPoland);
                boolean checkBracketsExp = checkerInput.checkBrackets();
                String exp1 = checkerInput.convertUsualMinusToUnaryMinus();
                if (checkBracketsExp) {
                    calculator = new OrdinaryCalculator(exp1);
                    System.out.println("Результат: " + calculator.makeInvertPolandNotation());
                } else {
                    System.out.println("Проверьте ввод и попробуйте еще раз!");
                }
                break;

            case 3:
                System.out.println("Введите систему счисления из которой нужен перевод: ");
                int systemFrom = scanner.nextInt();
                System.out.println("Введите систему счисления в которую нужно перевести: ");
                int systemTo = scanner.nextInt();

                System.out.println("Введите число: ");

                if (systemFrom == 10) {
                    int number = scanner.nextInt();
                    System.out.println(ConvertToDifferentSystem.convertToDiffSystemFrom10(number, systemTo));
                } else if (systemTo == 10) {
                    String numStr = scanner.next();
                    System.out.println(ConvertToDifferentSystem.convertFromDiffSystemTo10(numStr, systemFrom));
                } else {
                    String numStr = scanner.next();
                    int numIn10 = ConvertToDifferentSystem.convertFromDiffSystemTo10(numStr, systemFrom);
                    System.out.println(ConvertToDifferentSystem.convertToDiffSystemFrom10(numIn10, systemTo));
                }
                break;

            case 4:
                System.out.println("Введите математическое выражение для расчета:");
                String userExp = scanner.next();
                System.out.println("Укажите систему счисления:");
                int userSystem = scanner.nextInt();
                System.out.println(ConvertToDifferentSystem.calculateTotal(userExp, userSystem));
                break;




        }

    }

}
