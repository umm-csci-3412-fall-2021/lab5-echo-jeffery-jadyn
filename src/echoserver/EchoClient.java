package echoserver;

import java.io.*;
import java.net.*;

public class EchoClient {

    public static final int portNumber = 6013;

  public static void main(String[] args) throws IOException {
    String server;
    // Use "127.0.0.1", i.e., localhost, if no server is specified.
    if (args.length == 0) {
      server = "127.0.0.1";
    } else {
      server = args[0];
    }

    try {
      // Connect to the server
      Socket socket = new Socket(server, portNumber);


      //Gets input and output stream so we can read from the socket
      OutputStream output = socket.getOutputStream();

      InputStream input = socket.getInputStream();


      int nextByte;

      
      //Check if there is something to be read from the user 
      while ((nextByte = System.in.read()) != -1) {
        //Sends data to the server
        output.write(nextByte);
        output.flush();
        int byteread = input.read();
        //reads it from the server and writes it out
        System.out.write(byteread);
        System.out.flush();
      }

      //tells the socket no more information from the user is coming 
      socket.shutdownOutput();

      //checks if anything is still being sent from the server
      while ((nextByte = input.read()) != -1) {
        int byteread = input.read();
        System.out.write(byteread);
        System.out.flush();
      }

      // Close the socket when we're done reading from it
      socket.close();

    // Provide some minimal error handling.
    } catch (ConnectException ce) {
      System.out.println("We were unable to connect to " + server);
      System.out.println("You should make sure the server is running.");
    } catch (IOException ioe) {
      System.out.println("We caught an unexpected exception");
      System.err.println(ioe);
    }
  }
}