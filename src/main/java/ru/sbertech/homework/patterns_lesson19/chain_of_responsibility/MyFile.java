package ru.sbertech.homework.patterns_lesson19.chain_of_responsibility;

public class MyFile {
    private final String fileName;
    private final String ext;

    public MyFile(String fileName){
        this.fileName = fileName;

        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            this.ext = fileName.substring(fileName.lastIndexOf(".")+1);
        else this.ext = "";
    }

    public String getExt() {
        return this.ext;
    }
}
