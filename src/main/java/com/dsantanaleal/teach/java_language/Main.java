package com.dsantanaleal.teach.java_language;

import com.dsantanaleal.teach.java_language.server.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private ServerSocket server;
    int counter = 0;
    Map<Integer, ClientHandler> clientes = new HashMap<>();

    public void start(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Escuchando desde: " + server.getInetAddress());
            while(true) {
                ClientHandler handler = new ClientHandler(server.accept());
                new Thread(handler).start();
                clientes.put(++counter, handler);
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


    public static void main(String[] args) {
        Main main = new Main();
        main.start(6666);
    }
}