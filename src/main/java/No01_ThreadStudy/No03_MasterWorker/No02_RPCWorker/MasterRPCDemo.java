package No01_ThreadStudy.No03_MasterWorker.No02_RPCWorker;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class MasterRPCDemo {
    final private static int PORT = 19999;
    private static ServerSocket serverSocket = null;

    public static void startServerSocket() {
        if (serverSocket == null) {
            synchronized (MasterRPCDemo.class) {
                if (serverSocket == null) {
                    try {
                        serverSocket = new ServerSocket(PORT);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        while (true) {
            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))
            ) {
                String info = null;
                while ((info = in.readLine()) != null) {


                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}