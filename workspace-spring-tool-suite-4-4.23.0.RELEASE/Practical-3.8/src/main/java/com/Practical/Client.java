package com.Practical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedReader br;
    private PrintWriter out;

    public Client() {
        try {
            // Connect to the server on port 8012
            socket = new Socket("localhost", 8012);
            System.out.println("Connected to server!");

            // Initialize input and output streams
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Start reading and writing
            startReading();
            startWriting();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void startReading() {
        System.out.println("Client - Reader starting");
        Runnable read = () -> {
            try {
                String msg;
                while ((msg = br.readLine()) != null) {
                    System.out.println("Server: " + msg);
                    if ("exit".equalsIgnoreCase(msg)) {
                        System.out.println("Server terminated!");
                        socket.close();
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Connection is closed");
            }
        };
        new Thread(read).start();
    }

    public void startWriting() {
        System.out.println("Client - Writer starting");
        Runnable write = () -> {
            try (BufferedReader bris = new BufferedReader(new InputStreamReader(System.in))) {
                String msg;
                while ((msg = bris.readLine()) != null) {
                    out.println(msg);
                    if ("exit".equalsIgnoreCase(msg)) {
                        socket.close();
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Connection is closed");
            }
        };
        new Thread(write).start();
    }

    public static void main(String[] args) {
        System.out.println("Client Start!");
        new Client();
    }
}
