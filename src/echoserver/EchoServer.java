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

            int nextByte;


            while(true){

                Socket client = sock.accept();
                // System.out.println("Got a request!");


                InputStream input = client.getInputStream();

                OutputStream output = client.getOutputStream();


                // PrintWriter writer = new PrintWriter(client.getOutputStream(),true);

                // writer.println(new java.util.Date().toString());

                while ((nextByte = input.read()) != -1) {
                    output.write(nextByte);
                    output.flush();
                    // int byteread = input.read();
                    // System.out.write(byteread);
                    // System.out.flush();
                  }

                client.close();
            }
            
        } catch (IOException ioe) {

            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }

    }

}