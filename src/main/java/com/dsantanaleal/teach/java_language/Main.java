package com.dsantanaleal.teach.java_language;

import com.dsantanaleal.teach.java_language.server.ClientHandler;

import javax.net.ServerSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private ServerSocket server;
    int counter = 0;
    List<ClientHandler> clientes = new ArrayList<>();

    public void start(int port) {
        try {
            server = ServerSocketFactory.getDefault().createServerSocket(port, 10, getLocalIHost());
            System.out.println("Escuchando desde: " + server.getInetAddress().getHostAddress() + ":" + port);
            while(true) {
                ClientHandler handler = new ClientHandler(server.accept());
                new Thread(handler).start();
                clientes.add(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stop();
        }
    }

    public void stop() {
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static InetAddress getLocalIHost(){
        try {
            return InetAddress.getLocalHost();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.start(6666);
    }
}