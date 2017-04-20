package com.pkproject.internetcourse.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by dominikzaq on 30.12.2016.
 */
public class Client {
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    private Socket socket;
    private int port;



    public boolean connectIntoServer() {

        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean registration() {
        return true;
    }

    public void disconnectServer() {

    }

}
