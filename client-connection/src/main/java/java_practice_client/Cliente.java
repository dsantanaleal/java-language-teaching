package java_practice_client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

final class Cliente {

    private static Cliente cliente = new Cliente();
    private Socket clienteSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    private Cliente() {
    }

    private void startConnection(String ip, int port) throws IOException {
        clienteSocket = new Socket(ip, port);
        in = new ObjectInputStream(clienteSocket.getInputStream());
        out = new ObjectOutputStream(clienteSocket.getOutputStream());
    }

    public void sendMessage(String msg) throws IOException {
        out.writeObject(msg);
    }

    public Object readObject() throws ClassNotFoundException, IOException {
        return in.readObject();
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clienteSocket.close();
    }

    public static Cliente open(String ip, int port, String name) throws IOException {
        cliente.startConnection(ip, port);
        cliente.sendMessage(name);
        return cliente;
    }

    public static Cliente start() {
        try {
            Scanner io = new Scanner(System.in);
            System.out.print("Llamar a: ");
            String host = io.nextLine();
            System.out.print("scotiaID: ");
            String name = io.nextLine();
            io.close();
            String ip = host.split(":")[0];
            int port = Integer.parseInt(host.split(":")[1]);
            Cliente client = Cliente.open(ip, port, name);
            System.out.println(client.readObject());
            return client;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
