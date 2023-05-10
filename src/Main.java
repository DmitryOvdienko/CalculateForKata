import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input");
        String str = scanner.nextLine();
        System.out.println(calculate(str));
    }

    public static String calculate(String str) {
        boolean isArabic = true;
        boolean isArabicA = true;
        boolean isArabicB = true;

        String[] array = str.split(" ");
        if (array.length < 3) {
            throw new ArithmeticException("Строка не является математической операцией");
        }
        if (array.length > 3) {
            throw new ArithmeticException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)  ");
        }
        String a = array[0];
        String action = array[1];
        String b = array[2];

        Romanian[] arrayRomanians = Romanian.values();

        for (int i = 0; i < arrayRomanians.length; i++) {
            if (arrayRomanians[i].name().equals(a)) {
                isArabicA = false;
                break;
            } else {
                isArabicA = true;
            }
        }
        for (int i = 0; i < arrayRomanians.length; i++) {
            if (arrayRomanians[i].name().equals(b)) {
                isArabicB = false;
                break;
            } else {
                isArabicB = true;
            }
        }
        if (isArabicA && isArabicB) {
            isArabic = true;
        } else if (!isArabicA && !isArabicB) {
            isArabic = false;
        } else {
            throw new ArithmeticException("Используются одновременно разные системы счисления");
        }

        if (isArabic) {
            int num1 = Integer.parseInt(array[0]);
            int num2 = Integer.parseInt(array[2]);
            int result = 0;
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                System.out.println("Введены значения не удовлетворяющие заданию");
            } else {
                if (action.equals("+")) {
                    result = num1 + num2;
                } else if (action.equals("-")) {
                    result = num1 - num2;
                } else if (action.equals("*")) {
                    result = num1 * num2;
                } else if (action.equals("/")) {
                    result = num1 / num2;
                } else {
                    throw new ArithmeticException("Введена неверная операция");
                }
                System.out.println("Output");
                String res = " " + result;
                return res;
            }
        }

        if (!isArabic) {
            Romanian rim1 = Romanian.valueOf(a);
            Romanian rim2 = Romanian.valueOf(b);
            int num1 = rim1.ordinal();
            int num2 = rim2.ordinal();
            int result = 0;
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                System.out.println("Введены значения не удовлетворяющие заданию");
            } else {
                if (action.equals("+")) {
                    result = num1 + num2;
                } else if (action.equals("-")) {
                    result = num1 - num2;
                } else if (action.equals("*")) {
                    result = num1 * num2;
                } else if (action.equals("/")) {
                    result = num1 / num2;
                } else {
                    throw new ArithmeticException("Введена неверная операция");
                }
                if (result < 0) {
                    throw new ArithmeticException("В римской системе нет отрицательных чисел");
                }
                String rimResult = arrayRomanians[result].name();
                System.out.println("Output");
                return rimResult;
            }
        }
        return str;
    }
}

