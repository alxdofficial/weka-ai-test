//TCPServer.java
package ui;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.List;
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
                text = reader.readLine();
                System.out.println(text);

                writer.println("Server: " + "java app got the message");
            }
            System.out.println("exited while loop");

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }


    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void demoinputClassifyData(List<EntryC> loce, String entryInput) {
        System.out.println("id  name  color  length  thickness   warmth   fabric-stitch-density   shiny?"
                + "num-of-colors   body-contour-line   stiffness   water-resistance    material"
                + "fit     pattern   contrast");
        List<String> inputSplit = Arrays.asList(entryInput.split(","));
        for (String s:inputSplit) {
            s = s.trim();
        }
        EntryC newEntryC = new EntryC(inputSplit.get(0),inputSplit.get(1),inputSplit.get(2),
                inputSplit.get(3),inputSplit.get(4),inputSplit.get(5),inputSplit.get(6),
                inputSplit.get(7),Integer.parseInt(inputSplit.get(8)),inputSplit.get(9),
                inputSplit.get(10),
                inputSplit.get(11),inputSplit.get(12),inputSplit.get(13),inputSplit.get(14),
                inputSplit.get(15));
        loce.add(newEntryC);
    }



    public static void democlassify(List<EntryC> loce) throws Exception {
        MLAlgorithm mla = new MLAlgorithm();
        mla.naiveBayesClassification("default_garments.arff", loce);
        List<EntryC> results = mla.getCatEntries();
        for (EntryC e : results) {
            System.out.print(e.id + "   ");
            System.out.print(e.itemName + "   ");
            System.out.print(e.classifcication);
            System.out.println("");
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

