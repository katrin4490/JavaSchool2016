package ru.sbertech.socket_lesson15.second;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static final int DEFAULT_PORT = 3333;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (true) {
            Socket accept = serverSocket.accept();
            executorService.execute(new Worker(accept));
        }

    }
}
