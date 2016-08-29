package ru.sbertech.socket_lesson15.multicast;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastServer {

    public static final int PORT = 3333;
    public static final int BUFFER_SIZE = 256;
    public static final String MULTICAST_GROUP = "224.0.0.22";

    public static void main(String[] args) throws IOException {
        try (MulticastSocket socket = new MulticastSocket(PORT)) {
            InetAddress multicastAddress = InetAddress.getByName(MULTICAST_GROUP);
            socket.joinGroup(multicastAddress);
            byte[] buffer = new byte[BUFFER_SIZE];
            String command = "";
            do {
                DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(datagramPacket);
                System.out.println("datagramPacket " + datagramPacket.getAddress());
                command = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println(command);
            } while (!command.equals("exit"));
            socket.leaveGroup(multicastAddress);
        }
    }
}
