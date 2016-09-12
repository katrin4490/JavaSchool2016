package ru.sbertech.homework.patterns_lesson18.proxy;

import java.io.File;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<IImage> images = new ArrayList<>();
        String destDirectory = System.getProperty("user.dir") + "\\destFolder\\";
        File sourceDirectory = new File(System.getProperty("user.dir") + "\\sourceFolder");
        File[] imageSources = sourceDirectory.listFiles();

        // без прокси
        long start = System.currentTimeMillis();
        for (int i = 0; i < imageSources.length; i++){
            Image image = new Image(imageSources[i].getAbsolutePath(), destDirectory + UUID.randomUUID().toString() + "." + getFileExtension(imageSources[i]));
            images.add(image);
        }
        double finish = (System.currentTimeMillis() - start) / (double)1000;
        System.out.println("Время выполнения: " + finish + " сек");
        // images.get(0).show();

        System.out.println("-------------------------------");


        // с прокси
        start = System.currentTimeMillis();
        for (int i = 0; i < imageSources.length; i++){
            ProxyImage image = new ProxyImage(imageSources[i].getAbsolutePath(), destDirectory + UUID.randomUUID().toString() + "." + getFileExtension(imageSources[i]));
            images.add(image);
        }
        finish = (System.currentTimeMillis() - start) / (double)1000;
        System.out.println("Время выполнения: " + finish + " сек");
       // images.get(5).show();
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return fileName.substring(fileName.lastIndexOf(".")+1);
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";
    }
}
