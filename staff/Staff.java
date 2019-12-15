package ru.geekbrains.java_one.lesson_d.staff;

    /** 1. Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
     *  2. Конструктор класса должен заполнять эти поля при создании объекта;
     *  3. Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого
     *  поля;
     *  4. Вывести при помощи методов из пункта 3 ФИО и должность.
     *  5. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о
     *  сотрудниках старше 40 лет;
     *  6.* Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
     *  7.*** Продумать конструктор таким образом, чтобы при создании каждому сотруднику
     *  присваивался личный уникальный идентификационный порядковый номер */

    public class Staff {
        private static int idCount = 0;
        private int id;
        private String name;
        private String job;
        private String phoneNumber;
        private int salary;
        private int birthYear;

        private Staff() {
            idCount ++;
        }

        public Staff(String name, String job, String phoneNumber, int salary, int birthYear) {
            this();
            this.id = idCount;
            this.name = name;
            this.job = job;
            this.phoneNumber = phoneNumber;
            this.salary = salary;
            this.birthYear = birthYear;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getJob() {
            return job;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public int getSalary() {
            return salary;
        }

        public int getAge() {
            return 2019 - birthYear;
        }

        public void setIncreaseSalary(int sum) {
            this.salary += sum;
        }
        public void infoStaff (){
            System.out.printf("%d | %s | %s | %s | %d | %d\n", this.id, this.name, this.job, this.phoneNumber, this.salary, this.getAge());
        }
    }









