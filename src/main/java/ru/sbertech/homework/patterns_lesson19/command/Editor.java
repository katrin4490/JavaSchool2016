package ru.sbertech.homework.patterns_lesson19.command;


public interface Editor {
    void excecute(Command command);
    void undo();
}
