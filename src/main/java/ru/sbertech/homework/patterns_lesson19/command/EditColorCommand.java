package ru.sbertech.homework.patterns_lesson19.command;


public class EditColorCommand implements Command {
    private String oldValue;
    private String newValue;

    public EditColorCommand(String newValue){
        this.newValue = newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    @Override
    public void excecute(Photo photo) {
        this.oldValue = photo.getColor();
        photo.setColor(newValue.toString());
    }

    @Override
    public void undo(Photo photo) {
        photo.setColor(oldValue);
    }
}
