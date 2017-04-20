package clientserver;

/**
 * Created by dominikzaq on 29.12.2016.
 */
import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] arg) {

        Employee employee = null;

        try {

            ServerSocket socketConnection = new ServerSocket(11111);

            System.out.println("Server Waiting");

            Socket pipe = socketConnection.accept();

            ObjectInputStream serverInputStream = new
                    ObjectInputStream(pipe.getInputStream());

            ObjectOutputStream serverOutputStream = new
                    ObjectOutputStream(pipe.getOutputStream());

            employee = (Employee )serverInputStream.readObject();

            employee .setEmployeeNumber(256);
            employee .setEmployeeName("John");

            serverOutputStream.writeObject(employee);

            serverInputStream.close();
            serverOutputStream.close();


        }  catch(Exception e) {System.out.println(e);
        }
    }

}