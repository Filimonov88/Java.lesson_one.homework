package ru.geekbrains.java_one.lesson_e.Homework;

    /** Домашнее работа 5.
     * Филимонов Дмитрий Николаевич
     * Дата сдачи работы: 18.12.2019г
     **/

import java.util.Scanner;

/**
    1. Создать классы Собака, Лошадь, Птица и Кот
    с наследованием от класса Животное.

    2. Животные могут выполнять действия:
    бежать, плыть, перепрыгивать препятствие.
    В качестве параметра каждому методу передается величина,
    означающая или длину препятствия (для бега и плавания),
    или высоту (для прыжков).

    3. У каждого животного есть ограничения на действия
    (бег: кот 200 м., собака 500 м., Лошадь 1500 м., Птица 5 м.,;
    прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м. ;
    плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.).

    4. При попытке животного выполнить одно из этих действий,
    оно должно сообщить результат.
    (Например, dog1.run(150); -> результат: 'Пёсик пробежал!')

    5. * Добавить животным разброс в ограничениях.
    То есть у одной собаки ограничение на бег может быть 400 м.,
    у другой 600 м.
    */

public class Main {

        static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            Beast zoo[] = {new Cat("cat", "Murzik", 200, 2, 0),
                    new Dog("dog", "Bim", 500, 0.5f, 10),
                    new Horse("horse", "Mustang", 1500, 3f, 100),
                    new Bird("bird", "Fenix", 5, 0.2f, 0)};

            System.out.println("Введите дистанцию для бега");
            float distanceRun = scanner.nextFloat();
            System.out.println("Введите высоту для прыжка");
            float distanceJump = scanner.nextFloat();
            System.out.println("Введите дистанцию для заплыва");
            float distanceSwim = scanner.nextFloat();
            for (int i = 0; i < zoo.length; i++) {
                if(zoo[i].running(distanceRun)) {
                    System.out.println(zoo[i].getType() + " " + zoo[i].getName()
                            + " преодолел всю дистанцию в " + distanceRun + " м");
                } else {
                    System.out.println(zoo[i].getType() + " " + zoo[i].getName()
                            + " смог преодолеть только " + zoo[i].getRun() + " м");
                }
                if(zoo[i].jumping(distanceJump)){
                    System.out.println(zoo[i].getType() + " " + zoo[i].getName()
                            + " прыгнул на " + distanceJump + " м");
                } else {
                    System.out.println(zoo[i].getType() + " " + zoo[i].getName()
                            + " смог прыгнуть только на " + zoo[i].getJump() + " м");
                }
                if(zoo[i].swimming(distanceSwim)){
                    System.out.println(zoo[i].getType() + " " + zoo[i].getName()
                            + " проплыл " + distanceSwim + " м");
                } else if (zoo[i] instanceof Cat || zoo[i] instanceof Bird) {
                    System.out.println(zoo[i].getType() + " " + zoo[i].getName()
                            + " не умеет плавать");
                } else {
                    System.out.println(zoo[i].getType() + " " + zoo[i].getName()
                            + " смог проплыть только " + zoo[i].getSwim() + " м");
                }
            }
        }
}
