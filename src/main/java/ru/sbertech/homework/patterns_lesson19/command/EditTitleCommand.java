package ru.sbertech.homework.patterns_lesson19.command;

public class EditTitleCommand implements Command {
    private String oldTitle;

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    private String newValue;

    public EditTitleCommand(String newValue){
        this.newValue = newValue;
    }

    @Override
    public void excecute(Photo photo) {
        this.oldTitle = photo.getTitle();
        photo.setTitle(newValue.toString());
    }

    @Override
    public void undo(Photo photo) {
        photo.setTitle(oldTitle);
    }
}
