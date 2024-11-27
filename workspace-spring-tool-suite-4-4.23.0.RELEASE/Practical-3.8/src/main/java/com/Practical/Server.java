package com.Practical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket socket;
    private ServerSocket server;
    private BufferedReader br;
    private PrintWriter out;

    public Server() {
        try {
            System.out.println("Server is ready to accept the connection!");
            server = new ServerSocket(8012);
            System.out.println("Waiting for client to connect...");
            socket = server.accept();
            System.out.println("Client connected!");

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
        System.out.println("Server - Reader starting");
        Runnable read = () -> {
            try {
                String msg;
                while ((msg = br.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(msg)) {
                        System.out.println("Client terminated!");
                        socket.close();
                        break;
                    }
                    System.out.println("Client: " + msg);
                }
            } catch (IOException e) {
                System.out.println("Connection is closed");
            }
        };
        new Thread(read).start();
    }

    public void startWriting() {
        System.out.println("Server - Writer starting");
        Runnable write = () -> {
            try (BufferedReader bris = new BufferedReader(new InputStreamReader(System.in))) {
                String recdata;
                while ((recdata = bris.readLine()) != null) {
                    out.println(recdata);
                    if ("exit".equalsIgnoreCase(recdata)) {
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
        System.out.println("Server Start!");
        new Server();
    }
}