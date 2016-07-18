package ru.sbertech.homework;
// посчитать сумму двух целых чисел
import java.util.Scanner;
public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int c = 0;
        System.out.print("First integer: ");
        if(sc.hasNextInt()) {
            a = sc.nextInt();
            System.out.print("Second integer: ");
            if(sc.hasNextInt()) {
                b = sc.nextInt();
                System.out.println("Sum a+b:");
                System.out.println(a+b);
            }
            else System.out.println("Error! Is not an integer");
        }
        else System.out.println("Error! Is not an integer");
    }
}
