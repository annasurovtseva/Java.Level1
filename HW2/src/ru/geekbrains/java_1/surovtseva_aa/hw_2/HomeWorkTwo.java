package ru.geekbrains.java_1.surovtseva_aa.hw_2;

import java.util.Arrays;

public class HomeWorkTwo {

    // Задание 1
    private static void changeArrayValue (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? (arr[i] = 1) : (arr[i] = 0);
        }
    }

    // Задание 2
    // Про несколько управляющих переменных на самом уроке не рассказывали,
    // но этот материал есть в методичке
    private static void fillArray (int[] arr, int n) {
        for (int i = 0, j = 1; i < arr.length; i++, j+=n) {
            arr[i] = j;
        }
    }

    //Задание 3
    private static void multiplyArrayValue (int[] arr, int m, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < m) {
                arr[i] *= n;
            }
        }
    }

    // Задание 4
    private static int getArrayMin (int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    private static int getArrayMax (int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    // Задание 5
    private static void fillArrayDiagonal (int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0, k = arr[i].length - 1; j < arr[i].length; j++, k--) {
                arr[i][j] = (i == j || i == k) ? 1 : 0;
                System.out.printf("%2d", arr[i][j]);
            }
            System.out.println();
        }
    }

    // Задание 6
    private  static boolean pointBalance (int[] arr) {
        int leftSide = 0, rightSide = 0;
        for (int i = 0; i < arr.length; i++) {
            leftSide += arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            if (leftSide == rightSide) {
                return true;
            }
            leftSide -= arr[i];
            rightSide +=arr[i];
        }
        return false;
    }

    public static void main (String[] args) {

    // Задание № 1
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println();
        System.out.println("Задание № 1");
        System.out.println(Arrays.toString(arr1));
        changeArrayValue(arr1);
        System.out.println(Arrays.toString(arr1));

    // Задание № 2
        int [] arr2 = new int[8];
        fillArray(arr2, 3);
        System.out.println();
        System.out.println("Задание № 2");
        System.out.println(Arrays.toString(arr2));

    // Задание № 3
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println();
        System.out.println("Задание № 3");
        System.out.println(Arrays.toString(arr3));
        multiplyArrayValue(arr3, 6, 2);
        System.out.println(Arrays.toString(arr3));

    // Задание № 4
        int[] arr4 = {7, 5, 3, 2, 11, 4, 5, 15, 4, 8, 22, 18 };
        System.out.println();
        System.out.println("Задание № 4");
        System.out.println(Arrays.toString(arr4));
        System.out.println("Минимальное значение массива " + getArrayMin(arr4));
        System.out.println("Максимальное значение массива " + getArrayMax(arr4));

    // Задание 5
        int[][] arr5 = new int [4][4];
        System.out.println();
        System.out.println("Задание № 5");
        fillArrayDiagonal(arr5);

    // Задание 6
        int[] arr6 = {6, 2, 4, 1, 3};
        System.out.println();
        System.out.println("Задание № 6");
        System.out.println("В массиве есть точка равновесия? " + pointBalance(arr6));

    }
}
