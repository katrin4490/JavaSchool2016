//package ru.sbertech.homework.exception_lesson5;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.HttpURLConnection;
import java.util.*;
import java.io.InputStreamReader;
import java.net.URL;


public class ReadContent {
    public static void main (String[] args)  {
        System.out.println("Please enter URL");
        Scanner sc = new Scanner(System.in);
        String url = sc.nextLine();
        if (!Read(url)){
            System.out.println("Please enter an valid URL");
            sc = new Scanner(System.in);
            if (!Read(url))
                System.out.println("Sorry, you have twice entered incorrect URL!");
        }
        sc.close();
    }

    public static boolean Read(String url2) {
        URL url;
        try {
            url = new URL(url2);
            HttpURLConnection connection = null;
            if(!(url.openConnection() instanceof HttpURLConnection)) {
                return false;
            }
            LineNumberReader reader = new LineNumberReader(new InputStreamReader(url.openStream()));
            String current;
            while((current = reader.readLine()) != null) {
                System.out.println(current);
            }
            reader.close();
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }
}



