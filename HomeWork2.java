package ru.geekbrains.java_one.lesson_b;

import java.util.Arrays;

/** Домашнее задание N2.
     * Филимонов Дмитрий Николаевич
     * Дата сдачи работы: 08.12.2019г
     **/

public class HomeWork2 {

    public static void main(String[] args) {
        invertArray();
        fillArray();
        changeArray();
        findMinAndMax();
        fillDiagonalArray();

        int[] ar6 = {3, 2, 2, 4, 8, 1};
        System.out.println("#6 Проверить массив на равность левой и правой части: " + Arrays.toString(ar6));
        System.out.println("   Результат: " + checkBalance(ar6));

        int[] ar7 = {15, 4, 7, 9, 11};
        System.out.println("#7 Заданный массив:       " + Arrays.toString(ar7));
        int[] ar2 = arrayOffset(ar7, -4);
        printOut(ar2);
    }

    /* 1 Задать целочисленный массив, состоящий из элементов 0 и 1.
     *   Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     *   Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;*/

    private static void invertArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] ar2 = new int[10];
        System.out.println("#1 Дано:   " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            ar2[i] = (arr[i] == 0) ? 1 : 0;
            /* Второй способ:
             * switch (arr[i]) {
             *     case 0:
             *         arr[i] = 1;
             *         break;
             *     case 1:
             *         arr[i] = 0;
             * } */
        }
        System.out.println("   Замена: " + Arrays.toString(ar2));
    }

    /* 2 Задать пустой целочисленный массив размером 8. Написать метод,
     *   который с помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;*/

    private static void fillArray() {
        int[] array = new int[8];
        for (int i = 1; i < array.length; i++) {
            array[0] = 1;
            array[i] = array[i - 1] + 3;
        }
        System.out.println("#2 Заполнение: " + Arrays.toString(array));
    }

    /* 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод,
     * принимающий на вход массив и умножающий числа меньше 6 на 2;*/

    private static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] ar2 = new int[12];
        System.out.println("#3 Дано:      " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            ar2[i] = (arr[i] < 6) ? (arr[i] * 2) : arr[i];
        }
        System.out.println("   Изменения: " + Arrays.toString(ar2));
    }

    /* 4 Задать одномерный массив. Написать методы поиска в нём минимального и
     * максимального элемента;*/

    private static void findMinAndMax() {
        int[] a = {4, 3, 7, 1, 2, 9};
        int min = a[0];
        int max = a[0];
        System.out.println("#4 Дано:      " + Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        System.out.println("   Максимум = " + max);
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min)
                min = a[i];

        }
        System.out.println("   Минимум  = " + min);
    }

    /* 5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
     * заполнить его диагональные элементы единицами, используя цикл(ы);*/

    private static void fillDiagonalArray() {
        int[][] arr = new int[5][5];
        System.out.println("#5 Заполнение по диагонали единицами: ");
        for (int i = 0; i < 5; i++) {
            arr[i] = new int[5];
            for (int j = 0; j < 5; j++) {
                arr[i][j] = (i == j) ? 1 : 0;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* 6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true если в массиве есть место, в котором сумма левой и правой
     * части массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true,
     * checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 1, 2, 3, 4]) → true.
     * Абстрактная граница показана символами ||, эти символы в массив не входят.*/

    private static boolean checkBalance(int[] ar6) {
        int leftSum, rightSum;
        for (int i = 0; i < ar6.length + 1; i++) {
            leftSum = 0;
            rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += ar6[j];
            }
            for (int j = i; j < ar6.length; j++) {
                rightSum += ar6[j];
            }
            if (leftSum == rightSum) return true;
        }
        return false;
    }

    /* 7 *** Написать метод, которому на вход подаётся одномерный массив и число n (может
     * быть положительным, или отрицательным), при этом метод должен циклически сместить
     * все элементы массива на n позиций.
     * 8 **** Не пользоваться вспомогательным массивом при решении задачи 7.*/

    private static int[] arrayOffset(int[] ar7, int shift){
        int currentIndex, movedIndex, buffer;
        for (int i = 0; i < greatestCommonDivisor(shift, ar7.length); i++) {
            buffer = ar7[i];

            currentIndex = i;

            if(shift > 0){
                while (true) {
                    movedIndex = currentIndex + shift;
                    if (movedIndex >= ar7.length)
                        movedIndex = movedIndex - ar7.length;
                    if (movedIndex == i)
                        break;
                    ar7[currentIndex] = ar7[movedIndex];
                    currentIndex = movedIndex;
                }
            }
            else if(shift < 0){
                while (true) {
                    movedIndex = currentIndex + shift;
                    if (movedIndex < 0)
                        movedIndex = ar7.length + movedIndex;
                    if (movedIndex == i)
                        break;
                    ar7[currentIndex] = ar7[movedIndex];
                    currentIndex = movedIndex;
                }
            }
            ar7[currentIndex] = buffer;
        }
        return ar7;
    }

    public static void printOut(int[] incomingArray){
        for(int item: incomingArray){
        }
        System.out.println("   Массив после сдвига:   " + Arrays.toString(incomingArray));
    }

    private static int greatestCommonDivisor(int a, int b){
        if (b == 0)
            return a;
        else
            return greatestCommonDivisor(b, a % b);
    }


}

















