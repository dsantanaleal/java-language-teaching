package com.dsantanaleal.teach.java_language.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private String nombre;
    private Socket client;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            System.out.println("Started!!!");
            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());
            nombre = (String)in.readObject();
            out.writeObject("BIENVENIDO A UNA NUEVA SESION DE JAVA");
            in.close();
            out.close();
            client.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
