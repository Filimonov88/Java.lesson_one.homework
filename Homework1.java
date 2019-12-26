package ru.geekbrains.homework1;

    /** Домашнее задание N1.
     * Филимонов Дмитрий Николаевич
     * Дата сдачи работы: 05.12.2019г
     * P.S. Дико извиняюсь за задержку сдачи ДЗ.
     **/

public class Homework1 {

    public static void main(String[] args) {
        System.out.println(calculate(4, 2, 6, 2));
        System.out.println(sum(7, 8));
        isPositiveOrNegative(-5);
        greetings("Иван");
        leapYear(2000);
    }

    public static float calculate(int a, int b, int c, int d) {
        int result;
        result = a * (b + (c / d));
        return result;
    }

    public static boolean sum(int x1, int x2) {
        int result;
        result = x1 + x2;
        if (result >= 10 && result <= 20)
            return true;
        else
            return false;
    }

    public static void isPositiveOrNegative(int x) {
        if(x >= 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }
    }

    public static void greetings(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void leapYear(int y){
        if (y % 4 == 0) {
            if ((y % 100 != 0) || (y % 400 == 0)) {
                System.out.println("Год высокосный");
            } else {
                System.out.println("Не высокосный");
            }
        }
    }

    /* 1) Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат
       с плавающей точкой, где a, b, c, d – целочисленные входные параметры этого метода;

       2) Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма
       лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном
       случае – false;

       3) Написать метод, которому в качестве параметра передается целое число, метод
       должен проверить положительное ли число передали, или отрицательное.
       Замечание: ноль считаем положительным числом.
       Результат работы метода вывести в консоль;

       4) Написать метод, которому в качестве параметра передается строка, обозначающая
       имя, метод должен вернуть приветственное сообщение «Привет, переданное_имя!»;
       Вывести приветствие в консоль;

       5) Написать метод, который определяет является ли год високосным. Каждый 4-й год
       является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
       Для проверки работы вывести результаты работы метода в консоль*/

}
