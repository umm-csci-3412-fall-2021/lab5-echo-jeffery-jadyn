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

            //Start listening on the specified port
            ServerSocket sock = new ServerSocket(portNumber); 

            int nextByte;

            //Run forever, which is common for server-style services
            while(true){

                //Wait until someone connects
                Socket client = sock.accept();

                //Gets input and output stream so we can read from the socket
                InputStream input = client.getInputStream();

                OutputStream output = client.getOutputStream();

                //reads data from the client socket
                while ((nextByte = input.read()) != -1) {
                    //writes back to the client 
                    output.write(nextByte);
                    output.flush();
                  }

                  //closes everything that needs to be closed
                  input.close();
                  output.close();

                client.close();
            }
        //very minimal error handling 
        } catch (IOException ioe) {

            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }

    }

}