package ru.sbertech.homework.patterns_lesson19.chain_of_responsibility;

public class ExcelParser implements IParser {
    private final IParser next;

    public ExcelParser (){
        this.next = null;
    }
    public ExcelParser (IParser next){
        this.next = next;
    }

    @Override
    public void parse(MyFile file) {
        if (file.getExt().equals("xls") || file.getExt().equals("xlsx")){
            System.out.println("Распарсили файл Excel");
        }
        else if (next != null){
            next.parse(file);
        }
    }
}
