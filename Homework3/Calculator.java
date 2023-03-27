package org.example;

import java.util.Scanner;

public class Calculator {
    public static double summarize(double number1, double number2) {
        return number1 + number2;
    }

    public static double subtract(double number1, double number2) {
        return number1 - number2;
    }

    public static double multiply(double number1, double number2) {
        return number1 * number2;
    }

    public static double divide(double number1, double number2) {
        if (number2 == 0) {
            System.out.println("Делить на 0 нельзя!");
            throw new ArithmeticException("can't divide by zero");
        }
        return number1 / number2;
    }

    public static boolean isNumber(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }


    public static void select(String action, double number1, double number2) {
        switch (action) {
            case "+":
                System.out.println("Результат равен " + Calculator.summarize(number1, number2));
                break;
            case "-":
                System.out.println("Результат равен " + Calculator.subtract(number1, number2));
                break;
            case "*":
                System.out.println("Результат равен " + Calculator.multiply(number1, number2));
                break;
            case "/":
                try {
                    System.out.println("Результат равен " + Calculator.divide(number1, number2));
                } catch (ArithmeticException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Неверный ввод операции!");
        }
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите первое число: ");
            String str1 = scanner.nextLine();

            if (Calculator.isNumber(str1)) {
                System.out.println("Введите второе число: ");
                String str2 = scanner.nextLine();
                if (Calculator.isNumber(str2)) {
                    double number1 = Double.parseDouble(str1);
                    double number2 = Double.parseDouble(str2);
                    System.out.println("Выберите операцию: \n + (сложить) \n - (вычитать) \n * (умножить) \n" +
                            " / (делить)");
                    String action = scanner.next();
                    Calculator.select(action, number1, number2);
                } else {
                    System.out.println("Вы ввели не число, повторите ввод!");
                }
            } else {
                System.out.println("Вы ввели не число, повторите ввод!");
            }
        }
    }
}
