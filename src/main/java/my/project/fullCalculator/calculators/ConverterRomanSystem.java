package my.project.fullCalculator.calculators;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConverterRomanSystem {

    public static int romanToInt(String s) {
        char[] romanNum = {'I', 'V', 'X', 'L', 'C', 'D', 'M'}; // Задается массив римский цифр
        int[] arabicNum = {1, 5, 10, 50, 100, 500, 1000}; // Массив арабских цифр
        int romanToArab = 0; // Переменная для суммирования значения римских цифр
        int[] arrRomanToArab = new int[s.length()]; // создается массив, который хранит арабские цифры,
        // соответствующие введенным римским
        for (int i = 0; i < s.length(); i++) { //Проверяем каждую введенную римскую цифру
            char sumbOfInput = s.charAt(i); // Записвается каждая римская цифра в переменную
            for (int j = 0; j < romanNum.length; j++) { // Поиск введеных значений в массиве римских цифр
                if (sumbOfInput == romanNum[j]) { // Если введенный символ соответствует, значению в массиве
                    arrRomanToArab[i] = arabicNum[j]; // записываем в новый массив значение арабский цифры, того же
                    // индекса
                }
            }
        }
        for (int i = 1; i < arrRomanToArab.length; i++) { //Итерируется новый массив, чтобы найти случаи вычитания
            if (arrRomanToArab[i - 1] < arrRomanToArab[i]) { //Сравниваются элементы между собой 0 и 1, 1 и 2...
                arrRomanToArab[i-1] = arrRomanToArab[i - 1] * (-1); // Если левое число меньше, значит вычитание - * -1
                //Меняется значение в созданном массиве.
            }
        }
        for (int j : arrRomanToArab) { // Итерируем последнюю версию массива с вычитанием
            romanToArab = romanToArab + j; //Чтобы сложить все цифры в массиве
        }
        return romanToArab;
    }



    public static String numberToRoman(long number) {
        Map<Long, String> arabAndRoman = new LinkedHashMap<>();
        arabAndRoman.put(1000L, "M");
        arabAndRoman.put(900L, "CM");
        arabAndRoman.put(500L, "D");
        arabAndRoman.put(400L, "CD");
        arabAndRoman.put(100L, "C");
        arabAndRoman.put(90L, "XC");
        arabAndRoman.put(50L, "L");
        arabAndRoman.put(40L, "XL");
        arabAndRoman.put(10L, "X");
        arabAndRoman.put(9L, "IX");
        arabAndRoman.put(5L, "V");
        arabAndRoman.put(4L, "IV");
        arabAndRoman.put(1L, "I");

        StringBuilder romanNumberBuilder = new StringBuilder();

        while (number > 0) {
            for (Long num : arabAndRoman.keySet()) {
                if (number >= num) {
                    romanNumberBuilder.append(arabAndRoman.get(num));
                    number = number - num;
                    break;
                }
            }

        }
        return romanNumberBuilder.toString();
    }
}
