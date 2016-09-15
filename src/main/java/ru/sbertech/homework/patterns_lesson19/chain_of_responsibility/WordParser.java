package ru.sbertech.homework.patterns_lesson19.chain_of_responsibility;

/**
 * Created by программист on 15.09.2016.
 */
public class WordParser implements IParser{
    private final IParser next;

    public WordParser (){
        this.next = null;
    }
    public WordParser (IParser next){
        this.next = next;
    }

    @Override
    public void parse(MyFile file) {
        if (file.getExt().equals("docx") || file.getExt().equals("docx")){
            System.out.println("Распарсили файл Word");
        }
        else if (next != null){
            next.parse(file);
        }
    }
}
