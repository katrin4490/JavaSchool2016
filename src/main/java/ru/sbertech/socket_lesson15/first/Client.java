package ru.sbertech.socket_lesson15.first;

import java.io.*;
import java.net.Socket;

public class Client {
    public static final String HOST = "localhost";
    public static final int PORT = 3333;
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(HOST, PORT);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Hello");
        bufferedWriter.write("\n");
        bufferedWriter.flush();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(bufferedReader.readLine());

        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
