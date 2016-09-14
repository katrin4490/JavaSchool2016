package ru.sbertech.homework.patterns_lesson19.command;


public interface Command {
    void excecute(Photo photo);
    void undo(Photo photo);
}
