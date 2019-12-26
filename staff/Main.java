package ru.geekbrains.java_one.lesson_d.staff;

    /** Домашнее работа 4.
     * Филимонов Дмитрий Николаевич
     * Дата сдачи работы: 15.12.2019г
     **/


    /**
     * 1.    Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
     * 2.    Конструктор класса должен заполнять эти поля при создании объекта;
     * 3.    Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
     * 5.    Вывести при помощи методов из пункта 3 ФИО и должность.
     * 6.    Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
     * 7.    * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
     * 8.    *** Продумать конструктор таким образом, чтобы при создании каждому сотруднику
             присваивался личный уникальный идентификационный порядковый номер
     */

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Staff[] staffArray = new Staff[sizeArray()];
        fillArray(staffArray);
        for (int j = 0; j < staffArray.length; j++) {
            System.out.println(staffArray[j].getId() + " | " + staffArray[j].getName() + " | "
                    + staffArray[j].getJob() + " | " + staffArray[j].getPhoneNumber() + " | "
                    + staffArray[j].getSalary() + " | " + staffArray[j].getAge());
        }
        System.out.println("--------------------");
        for (int i = 0; i < staffArray.length; i++) {
            if (staffArray[i].getAge() > 45)
                staffArray[i].setIncreaseSalary(5000);
        }
        for (int i = 0; i < staffArray.length; i++) {
            if (staffArray[i].getAge() > 40)
                staffArray[i].infoStaff();
        }

        printStaff(staffArray);
    }

    private static int sizeArray() {
        System.out.println("Set the number of employees: ");
        int size = scanner.nextInt();
        scanner.nextLine();
        return size;
    }

    private static void fillArray(Staff[] array) {
        for (int j = 0; j < array.length; j++) {
            System.out.print("Enter full name ");
            String name = scanner.nextLine();
            System.out.print("Enter job ");
            String job = scanner.nextLine();
            System.out.print("Enter phone number ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter salary ");
            int salary = scanner.nextInt();
            System.out.print("Enter birth year ");
            int birthYear = scanner.nextInt();
            array[j] = new Staff(name, job, phoneNumber, salary, birthYear);
            scanner.nextLine();
        }
    }

    public static void printStaff(Staff[] staffArray) {
        System.out.println("Staff:");
        for (Staff emp : staffArray) {
            System.out.println("Staff: " + emp.getName() + ", Job: " + emp.getJob());
        }
    }
}







































































