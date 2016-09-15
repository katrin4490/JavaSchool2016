package ru.sbertech.homework.patterns_lesson19.chain_of_responsibility;

/**
 * Created by программист on 15.09.2016.
 */
public class XmlParser implements IParser{
    private final IParser next;

    public XmlParser (){
        this.next = null;
    }
    public XmlParser (IParser next){
        this.next = next;
    }

    @Override
    public void parse(MyFile file) {
        if (file.getExt().equals("xml")){
            System.out.println("Распарсили файл Xml");
        }
        else if (next != null){
            next.parse(file);
        }
    }
}
