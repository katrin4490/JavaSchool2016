package ru.sbertech.homework;
// задача: Заданы два массива целых чисел: a и b
// вывести элементы массива а, которые встречаются в b
import java.util.Scanner;
public class SearchSecondArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arrayString = "";
        System.out.print("Length first array: ");
        if(sc.hasNextInt()) {
            int sizeFirstArray = sc.nextInt();
            int firstArray[] = new int[sizeFirstArray];
            System.out.println("Input first array:");
            for (int i = 0; i < sizeFirstArray; i++) {
                System.out.println("Enter " + (i + 1) + " element array:");
                if(sc.hasNextInt()) {
                    firstArray[i] = sc.nextInt();
                    arrayString = arrayString + "a[" + (i + 1) + "] = " + Integer.toString(firstArray[i]) + "  ";
                }
            }
            System.out.println(arrayString);
            System.out.print("Length second array: ");
            if(sc.hasNextInt()) {
                int sizeSecondArray = sc.nextInt(); ;
                int secondArray[] = new int[sizeSecondArray];
                arrayString = "";
                System.out.println("Input first array:");
                for (int i = 0; i < sizeSecondArray; i++) {
                    System.out.println("Enter " + (i + 1) + " element array:");
                    if(sc.hasNextInt()) {
                        secondArray[i] = sc.nextInt();
                        arrayString = arrayString + "b[" + (i + 1) + "] = " + Integer.toString(secondArray[i]) + "  ";
                    }
                }
                System.out.println(arrayString);
                arrayString = "";
                for (int i = 0; i < sizeFirstArray; i++) {
                    for (int j = 0; j < sizeSecondArray; j++) {
                        if (firstArray[i] == secondArray[j]) {
                            arrayString = arrayString + Integer.toString(firstArray[i]) + "  ";
                        }
                    }
                }
                System.out.println("Result:");
                System.out.println(arrayString);
            }
        }
    }
}