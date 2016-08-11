package ru.sbertech.homework.lesson9_serialization;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final int port = 5454;
    private static final String host = "127.0.0.1";

    private static String username = "Client1";

    public static void SendMessage() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите текст сообщения для отправки на сервер: ");
        String msg = bufferedReader.readLine();
        Message message = new Message(username, msg);

        Socket socket = new Socket(host, port);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(message);
        System.out.println("Сообщение отправлено на сервер...");
        socket.close();
    }

    public static void main(String[] args)throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String cmdExit = "0";
        String cmdSendMessage = "1";
        String cmd;

        System.out.println("Для отправки сообщения нажмите 1, для выхода нажмите 0");
        cmd = bufferedReader.readLine();

        while (!cmd.equals(cmdExit)) {
            if(cmd.equals(cmdSendMessage)) {
                SendMessage();
            }
            else if(cmd.equals(cmdExit)) {
                break;
            }
            else {
                System.out.println("Некорректная команда!!!");
            }
            System.out.println("Для отправки сообщения нажмите 1, для выхода нажмите 0");
            cmd = bufferedReader.readLine();
        }
    }
}
