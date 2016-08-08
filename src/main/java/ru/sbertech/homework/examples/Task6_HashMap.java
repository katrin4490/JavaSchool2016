package ru.sbertech.homework.examples;

import ru.sbertech.homework.initial.StringArrayInit;

import java.util.*;

/**
 * Created by программист on 21.07.2016.
 */
public class Task6_HashMap {
    public static void main(String[] args) {

        Map<Integer, String> strings = new HashMap<>();
        StringArrayInit.init(strings);
        ArrayList<Integer> num = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите номера строк, которые необходимо распечатать (в строку через запятую): ");
        if(sc.hasNext()) {
            String str = sc.next();
            try {
                int[] numArr = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
                StringArrayInit.printByNumber(strings, numArr);
            }
            catch (NumberFormatException ex) {
                System.out.print("NumberFormatException: " + ex.getMessage());
            }
        }


       //StringArrayInit.print(strings);
    }
}
