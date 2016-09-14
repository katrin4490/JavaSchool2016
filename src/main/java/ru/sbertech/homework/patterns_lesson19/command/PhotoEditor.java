package ru.sbertech.homework.patterns_lesson19.command;


import java.util.ArrayList;
import java.util.List;

public class PhotoEditor implements Editor{
    private Photo photo;
    List<Command> commands = new ArrayList<>();

    public PhotoEditor(Photo photo){
        this.photo = photo;
    }

    @Override
    public void excecute(Command command) {
        command.excecute(this.photo);
        commands.add(command);
    }

    @Override
    public void undo() {
        Command c = commands.remove(commands.size() - 1);
        c.undo(this.photo);
    }
}
