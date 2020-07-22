package com.dsantanaleal.teach.client_connection;

import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        String host = "";
        int port = 0;
        if(args.length > 0) {
            host = args[0].split(":")[0];
            port = Integer.parseInt(args[0].split(":")[1]);
        } else {
            throw new UnsupportedOperationException("You should specify host and port.");
        }

        try(Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            Object fromServer;
            if(socket.isConnected()) {
                while((fromServer = in.readObject()) != null) {
                    System.out.println(fromServer);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
