package ru.sbertech.homework.lesson9_serialization;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int port = 5454;
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен...");

            while (true){
                Socket socket = serverSocket.accept();
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Message msg = (Message) in.readObject();
                System.out.println("Принято сообщение от: " + msg.user + "; ID сообщения: " + msg.id + "; Текст сообщения: " + msg.message);
                socket.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
