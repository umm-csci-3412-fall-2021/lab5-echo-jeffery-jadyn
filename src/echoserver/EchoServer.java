package echoserver;

import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;
import java.net.*;

public class EchoServer {

    public static final int portNumber = 6013;

    public static void main(String[] args){

        try{

            ServerSocket sock = new ServerSocket(portNumber);


            while(true){

                Socket client = sock.accept();
                System.out.println("Got a request!");


                PrintWriter writer = new PrintWriter(client.getOutputStream(),true);

                writer.println(new java.util.Date().toString());

                client.close();
            }
            
        } catch (IOException ioe) {

            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }

    }

}