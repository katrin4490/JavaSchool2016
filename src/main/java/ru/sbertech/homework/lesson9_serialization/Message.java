package ru.sbertech.homework.lesson9_serialization;


import java.io.Serializable;

public class Message implements Serializable{
    final static long serialVersionUID = 0L;
    long id;
    String user;
    String message;

    public Message(String user, String message) {
        this.id = System.currentTimeMillis();
        this.user = user;
        this.message = message;
    }
}
