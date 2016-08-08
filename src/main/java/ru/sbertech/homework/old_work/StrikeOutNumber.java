package ru.sbertech.homework.old_work;
// Дана последовательность из n чисел a1, a2,..., an.
// C ней последовательно производят k операций: на i-ом шаге из этой последовательности
// одновременно вычеркивают все числа, стоящие на позициях с номерами, кратными bi (позиции нумеруются с 1).
// задача — промоделировать это процесс и вывести массив после выполения всех операций.
import java.util.Scanner;
import java.util.ArrayList;
public class StrikeOutNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lenght = 0;
        int countAct = 0;
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        System.out.print("Length array: ");
        if(sc.hasNextInt()) {
            lenght = sc.nextInt();
            int temp;
            String arrayString = "array list: ";
            for (int i = 0; i < lenght; i++) {
                System.out.println((i + 1) + " array value: ");
                if(sc.hasNextInt()) {
                    temp = sc.nextInt();
                    list1.add(temp);
                    arrayString += temp + "  ";
                }
                else {
                    System.out.print("Error");
                    i--;
                }
            }
            System.out.println(arrayString);
            System.out.print("Count act: ");
            if(sc.hasNextInt()) {
                countAct = sc.nextInt();
                int positionArray[] = new int[countAct];
                for (int i = 0; i < countAct; i++) {
                    System.out.println((i + 1) + " position");
                    if(sc.hasNextInt()) {
                        positionArray[i] = sc.nextInt();
                    }
                    else {
                        System.out.print("Error");
                        i--;
                    }
                }
                int n;
                for (int i = 0; i < countAct; i++) {
                    n = positionArray[i];
                    for (int j = 0; j < list1.size(); j++) {
                        if ((j + 1) % n != 0) {
                            list2.add(list1.get(j));
                        }
                    }
                    list1.clear();
                    list1.addAll(list2);
                    list2.clear();
                }
                System.out.print("\nArray result:\n");
                for (int i = 0; i < list1.size(); i++) {
                    System.out.print(list1.get(i) + "  ");
                }
            }
        }
    }
}