package com.dsantanaleal.teach.java_language.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private String nombre;
    private Socket client;
    private ObjectOutputStream out;
    private BufferedReader in;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            System.out.println("Started!!!");
            out = new ObjectOutputStream(client.getOutputStream());
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out.writeObject("BIENVENIDO A UNA NUEVA SESION DE JAVA");
            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrarCliente() throws IOException {
        String id;
        do {
            out.writeObject("Por favor ingresa tu nombre: ");
            id = in.readLine();
            System.out.println(id);
        } while(id == null);
        nombre = id;
    }
}
