package ru.sbertech.homework.patterns_lesson19.chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        MyFile file = new MyFile("file.docx");
        IParser parser = new ExcelParser(new WordParser(new XmlParser()));
        parser.parse(file);

        MyFile file2 = new MyFile("file.xls");
        IParser parser2 = new ExcelParser(new WordParser(new XmlParser()));
        parser2.parse(file2);

        MyFile file3 = new MyFile("file.xml");
        IParser parser3 = new ExcelParser(new WordParser(new XmlParser()));
        parser3.parse(file3);

        MyFile file4 = new MyFile("file.odt");
        IParser parser4 = new ExcelParser(new WordParser(new XmlParser()));
        parser4.parse(file4);
    }
}
