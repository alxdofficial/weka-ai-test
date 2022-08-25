//TCPServer.java
package ui;

import java.io.*;
import java.net.*;
import java.util.Objects;

import model.*;


class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            String text = "empty text";
            while(!text.equals("quit")) {
                System.out.println("inside read loop");
                text = reader.readLine();
                System.out.println("read something, but might be null");
                System.out.println(text);
//                String reverseText = new StringBuilder(text).reverse().toString();
                writer.println("Server: " + "java app got the message");
            }
            System.out.println("exited while loop");

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

class TCPServer {
    public static void main(String argv[]) throws Exception
    {
        int port = 12069;
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                new ServerThread(socket).start();
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}