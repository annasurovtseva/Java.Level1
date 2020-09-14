package ru.geekbrains.java_1.surovtseva_aa.hw_1;

public class HomeWorkOne {

    public static float calc (int a, int b, int c, int d) {
        return a * (b + ((float) c / d));
    }

    public static boolean checkSum (int a, int b) {
        if ((a+b >= 10) && (a+b <= 20)) {
            return true;
        } else {
            return false;
        }
    }

    public static void checkNumber (int a) {
        if (a < 0) {
            System.out.println("Число " + a + " отрицательное");
        } else {
            System.out.println("Число " + a + " положительное");
        }
    }

    public static void greeting (String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void checkLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " високосный год");
        } else {
            System.out.println(year + " обычный год");
        }
    }

    public static void main (String[] args) {
        System.out.println(calc(5,7,5,2));
        System.out.println(checkSum(7, 13));
        checkNumber(50);
        greeting("Иван");
        checkLeapYear(2020);
    }
}
