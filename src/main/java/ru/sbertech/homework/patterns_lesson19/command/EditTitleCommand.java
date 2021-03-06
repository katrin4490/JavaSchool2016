package ru.sbertech.homework.patterns_lesson19.command;

public class EditTitleCommand implements Command {
    private String oldValue;
    private String newValue;

    public EditTitleCommand(String newValue){
        this.newValue = newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    @Override
    public void excecute(Photo photo) {
        this.oldValue = photo.getTitle();
        photo.setTitle(newValue.toString());
    }

    @Override
    public void undo(Photo photo) {
        photo.setTitle(oldValue);
    }
}
