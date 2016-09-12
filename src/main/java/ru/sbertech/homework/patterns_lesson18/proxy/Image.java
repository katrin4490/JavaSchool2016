package ru.sbertech.homework.patterns_lesson18.proxy;


import java.awt.*;
import java.io.*;
import java.nio.file.Files;

public class Image implements IImage {

    private String source;
    private String dest;

    public Image(String source, String dest)throws InterruptedException{
        this.source = source;
        this.dest = dest;
        this.load();
    }


    private void load() throws InterruptedException {
        System.out.println("Загрузка изображения с " + this.source + " в " + this.dest);
        Thread.sleep(1500);

        File file = new File(this.source);
        if (file.exists()){
            try (FileOutputStream os = new FileOutputStream(dest)) {
                Files.copy(file.toPath(), os);
                os.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void show() {
        Desktop desktop = null;
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }
        try {
            desktop.open(new File(dest));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
