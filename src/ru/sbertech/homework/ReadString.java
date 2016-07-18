package ru.sbertech.homework;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ReadString {
    public static void main(String[] args) throws IOException {
        ArrayList<String> result = new ArrayList<String>();
        File fd = new File("file.txt");
        if (!fd.exists()) {
            System.out.print("File not exist");
            return;
        }
        Scanner fw = new Scanner(fd, "cp1251");
        while (fw.hasNextLine()) {
            result.add(fw.nextLine());
        }
        fw.close();
        Collections.sort(result);
        System.out.println("After Sorting:");
        for(String counter: result){
            System.out.println(counter);
        }
    }
}

