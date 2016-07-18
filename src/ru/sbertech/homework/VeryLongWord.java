package ru.sbertech.homework;
// Входные данные состоят из единственной строки — исходный текст. Разделителями считаются пробелы.
// вывести единственное число — количество букв в наидлинейшем слове в данном тексте.
import java.util.Scanner;
public class VeryLongWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("String: ");
        String text = sc.nextLine();
        int maxLenght = 0;
        int num = -1;
        String[] parts = text.split(" ");
        for(int i = 0; i < parts.length; i++) {
            if (parts[i].length() > maxLenght) {
                num = i;
                maxLenght = parts[i].length();
            }
        }
        if (num >= 0) {
            System.out.print("Very long world: " + parts[num] + "\nLength: " + maxLenght);
        }

    }
}