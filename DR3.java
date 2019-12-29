package ru.geekbrains.java_one.lesson_с.game;

import java.util.Random;
import java.util.Scanner;

    /** Домашнее работа 3.
     * Филимонов Дмитрий Николаевич
     * Дата сдачи работы: 14.12.2019г
     **/

    /* 1. Полностью разобраться с кодом;
     *
     * 2. Переделать проверку победы, чтобы она не была реализована просто набором условий;
     *
     * 3.* Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и
     * количества фишек 4;
     *
     * 4.*** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока и
     * пытаться выиграть сам.*/

public class DR3 {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private static final int TO_WIN = 4;
    private static final int SIZE_X = 5;
    private static final int SIZE_Y = 5;
    private static char[][] field = new char[SIZE_Y][SIZE_X];


    private static void initFields() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print(" ");
        for (int i = 0; i < SIZE_X * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? " " : i / 2 + 1);
        System.out.println();

        for (int i = 0; i < SIZE_X; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("--------------");
    }

    private static void setSym(int y, int x, char sym) {
        field[y][x] = sym;
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты: X (от 1 до " + SIZE_X + "); Y (от 1 до " + SIZE_Y + ")");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x));
        setSym(y, x, DOT_HUMAN);
    }

    /* 2. Переделать проверку победы, чтобы она не была реализована просто набором условий;
     * 3.* Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и
     * количества фишек 4 */

    private static boolean checkWin(char sym) {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (checkLine(i, j, 0, 1,  sym)) return true;  // проверим линию по х
                if (checkLine(i, j, 1, 1,  sym)) return true;  // проверим по диагонали х у
                if (checkLine(i, j, 1, 0,  sym)) return true;  // проверим линию по у
                if (checkLine(i, j, -1, 1, sym)) return true;  // проверим по диагонали х -у
            }
        }
        return false;
    }
    // проверка линии
    private static boolean checkLine(int y, int x, int ly, int lx, char sym) {
        int lineX = x + (TO_WIN - 1) * lx;
        int lineY = y + (TO_WIN - 1) * ly;
        if (lineX < 0 || lineY < 0 || lineX > SIZE_X - 1 || lineY > SIZE_Y - 1) return false;
        for (int i = 0; i < TO_WIN; i++) {
            int itemY = y + i * ly;
            int itemX = x + i * lx;
            if (field[itemY][itemX] != sym) return false;
        }
        return true;
    }

    //4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.

    private static void aiTurn() {
        // Проверка компа на выигрыш
        for (int i = 0; i < SIZE_Y; i++)
            for (int j = 0; j < SIZE_X; j++) {
                if (isCellValid(i, j)) {
                    setSym(i, j, DOT_AI);
                    if (checkWin(DOT_AI))
                        return;
                    setSym(i, j, DOT_EMPTY);
                }
            }
        // Проверка игрока на выигрыш
        for (int i = 0; i < SIZE_Y; i++)
            for (int j = 0; j < SIZE_X; j++) {
                if (isCellValid(i, j)) {
                    setSym(i, j, DOT_HUMAN);
                    if (checkWin(DOT_HUMAN)) {
                        setSym(i, j, DOT_AI);
                        return;
                    }
                    setSym(i, j, DOT_EMPTY);
                }
            }
        //Если нет выигрышных ходов
        int x , y;
        do {
            x = random.nextInt(SIZE_X);
            y = random.nextInt(SIZE_Y);
        } while (!isCellValid(y, x));
        setSym(y, x, DOT_AI);
    }

    private static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
            return false;
        }
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean isFuelFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initFields();
        printField();

        while (true) {
            humanTurn();
            printField();
            if (checkWin(DOT_HUMAN)) {
                System.out.println("HUMAN WIN!");
                break;
            }
            if (isFuelFull()) {
                System.out.println("DRAW!");
                break;
            }
            aiTurn();
            printField();
            if (checkWin(DOT_AI)) {
                System.out.println("COMP WIN!");
                break;
            }
            if (isFuelFull()) {
                System.out.println("DRAW!");
                break;
            }
        }

    }

}