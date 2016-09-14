package ru.sbertech.homework.patterns_lesson19.command;

/**
 * Created by программист on 14.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Photo photo = new Photo();
        photo.setName("Photo1");
        photo.setTitle("надпись на фото 1");
        photo.setColor("Зеленый");
        photo.setEffect("Черно-белый");
        System.out.println(photo.toString());

        PhotoEditor photoEditor = new PhotoEditor(photo);
        EditTitleCommand editTitleCommand = new EditTitleCommand("новая надпись");
        photoEditor.excecute(editTitleCommand);

        System.out.println(photo.toString());
        editTitleCommand.setNewValue("еще надпись поменяли");
        photoEditor.excecute(editTitleCommand);
        System.out.println(photo.toString());

        photoEditor.undo();
        System.out.println(photo.toString());
    }
}
