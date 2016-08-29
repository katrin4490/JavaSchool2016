package ru.sbertech.socket_lesson15.multicast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastClient {

    public static final String HOST = "localhost";
    public static final int PORT = 3333;

    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("224.0.0.22");
        try (
                DatagramSocket socket= new DatagramSocket();
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        )
        {
            String line;
            do {
                System.out.print("Enter message: ");
                line = console.readLine();
                byte[] bytes = line.getBytes();
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, PORT);
                socket.send(dp);
            } while (!line.equals("exit"));
        }
    }
}
