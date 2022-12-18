import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculateAR_KATA {
    static Scanner scn = new Scanner(System.in);
    static int number1, number2;
    static char operator;
    static int result;

    public static void main (String [] args) {

        System.out.println("KATA Akademy, введите арифметическое выражение дважды (спасибо за понимание)");
        Scanner scn = new Scanner(System.in);
        System.out.println(calc(scn.nextLine()));
    }
    public static String calc(String input) {
        String userInput = scn.nextLine();
        char [] operator_char = new char[10];
        for (int i=0; i<userInput.length(); i++) {
            operator_char[i] = userInput.charAt(i);
            if (operator_char[i] =='+') {
                operator = '+';
            }
            if (operator_char[i] =='-') {
                operator = '-';
            }
            if (operator_char[i] =='*') {
                operator = '*';
            }
            if (operator_char[i] =='/') {
                operator = '/';
            }
        }
        String operator_charString = String.valueOf(operator_char);
        String [] str1 = operator_charString.split("[+-/*]");
        String stable00 = str1[0];
        String stable01 = str1[1];
        String string03 = stable01.trim();
        number1 = romanToNumber(stable00);
        number2 = romanToNumber(string03);
        if (number1<0 && number2<0){
            result = 0;
        } else {
            result = calculated(number1, number2, operator);
            System.out.println("   Результат для римских  цифр");
            String resultRoman = convertNumToRoman(result);
            System.out.println(stable00 + " " + operator + " " + string03 + "=" + resultRoman);
        }
            number1 = Integer.parseInt(stable00);
            number2 = Integer.parseInt(string03);
            result = calculated(number1, number2, operator);
            System.out.println("   Результат для арабских  цифр");
            System.out.println(number1 + " " + operator + " " + number2 + "=" + result);

        return input;
    }
    private static String convertNumToRoman (int numArabian) {
        String [] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }
    private static int romanToNumber (String roman) {
        try {
            switch (roman) {
                case "I" -> {
                    return 1;
                }
                case "II" -> {
                    return 2;
                }
                case "III" -> {
                    return 3;
                }
                case "IV" -> {
                    return 4;
                }
                case "V" -> {
                    return 5;
                }
                case "VI" -> {
                    return 6;
                }
                case "VII" -> {
                    return 7;
                }
                case "VIII" -> {
                    return 8;
                }
                case "IX" -> {
                    return 9;
                }
                case "X" -> {
                    return 10;
                }
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Ошибка! Неверный формат ввода данных!");
        }
        return -1;
    }
    public static int calculated (int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> {
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Исключение :" + e);
                    System.out.println("Допускаются только целочисленные ненулевые значения");
                }
            }
            default -> throw new IllegalArgumentException("Неверный знак операции!");
        }
        return result;
    }
}
