package com.pkproject.internetcourse.server;

import com.pkproject.internetcourse.application.datebase.Operation;

import java.io.IOException;
import java.net.ServerSocket;


/**
 * Created by dominikzaq on 29.12.2016.
 */
public class Server {
    private Operation operation;
    static int portNumber = 1500;

    public Server() {
        this.operation = operation;
    }

    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);

            while(true) {

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {

    }

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
    }
}
