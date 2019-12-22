package ru.geekbrains.java_one.lesson_f;

/** Домашняя работа 6.
 * Филимонов Дмитрий Николаевич
 * Дата сдачи работы: 22.12.2019г
 **/

import java.io.*;
import java.util.Scanner;

/** 1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом;
 *  2. Написать программу, «склеивающую» эти файлы, то есть вначале идет
 *  текст из первого файла, потом текст из второго;
 *  3. * Написать программу, которая проверяет присутствует ли указанное
 *  пользователем слово в файле;
 *  4. ** Написать метод, проверяющий, есть ли указанное слово в папке
 */

public class FileRead {
    public static void main(String[] args) {
        String str1 = "1. The first IT specialist was a British woman Ada Lovelace.\n" +
                      "It was she who wrote the algorithm for the analytical aggregator\n" +
                      "in the 19th century. This machine could solve Bernoulli's equation.\n" +
                      "Ada has developed a sequence of operations to solve the problem,\n" +
                      "which, in fact, is the writing of the program.\n";

        String str2 = "2. The Python programming language is not named after pythons,\n" +
                      "although file icons with scripts written on them or development\n" +
                      "environment logos often represent a snake's head. The author\n" +
                      "chose the name of the film because he was a fan of the sketch\n" +
                      "series <<Monty Python's Flying circus>>.";

        String nameDir = "C://Java//JAVAone";
        fillFiles(str1, str2);
        readFromTwoFileAndWriteToOneFile("Fact1.txt", "Fact2.txt");
        Scanner scanner = new Scanner(System.in);
        String searchWord = scanner.nextLine();
        System.out.println((wordSearch("Fact1.txt", searchWord)) ? "Found" : "Not found");
        System.out.println((searchInDir(nameDir, searchWord)) ? "Found" : "Not found");

    }

    private static void fillFiles(String str1, String str2) {
        try {
            FileOutputStream fos1 = new FileOutputStream("Fact1.txt");
            FileOutputStream fos2 = new FileOutputStream("Fact2.txt");
            for (int i = 0; i < 1; i++) {
                fos1.write(str1.getBytes());
                fos2.write(str2.getBytes());
                fos1.write('\n');
                fos2.write('\n');
            }
            fos1.close();
            fos2.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromTwoFileAndWriteToOneFile(String nameFile1, String nameFile2) {
        StringBuilder tempStr = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(nameFile2);
            FileOutputStream fos = new FileOutputStream(nameFile1, true);
            int i = 0;
            while ((i = fis.read()) != -1){
                fos.write(i);
            }
            fis.close();
            fos.close();
        } catch (IOException e){
            e.getMessage();
        }
    }

    private static boolean wordSearch(File file, String searchWord) throws IOException{
        try {
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            int i = 0;
            while ((i = fis.read()) != -1) {
                for (int j = 0; j < searchWord.getBytes().length; j++) {
                    if (i != searchWord.getBytes()[j]) {
                        break;
                    } else {
                        i = fis.read();
                    }
                    if (j == searchWord.getBytes().length - 1) {
                        return true;
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    private static boolean wordSearch(String fileName, String searchWord) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            int i = 0;
            while ((i = fis.read()) != -1){
                for (int j = 0; j < searchWord.getBytes().length; j++) {
                    if (i != searchWord.getBytes()[j]){
                        break;
                    } else {
                        i = fis.read();
                    }
                    if (j == searchWord.getBytes().length - 1){
                        return true;
                    }
                }
            }
            fis.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    private static boolean searchInDir(String nameDir, String searchWord) {
        File dir = new File(nameDir);
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                try {
                    if (wordSearch(files[i], searchWord)) return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
