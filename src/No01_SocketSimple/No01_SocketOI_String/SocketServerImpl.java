package No01_SocketSimple.No01_SocketOI_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class SocketServerImpl   {
    int port = 19999;
    ServerSocket ss = null;

    public SocketServerImpl() throws IOException {
        System.err.println("server object has been created!");
    }

    public void start() throws IOException {
        ss = new ServerSocket(port);
        while (true) {
            Socket socket = ss.accept();//阻塞 只到有远端连接接入
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
            String msg = null;
            while ((msg = br.readLine()) != null) {
                System.out.println("received msg: " + msg);
                pw.println("hello client!");
            }


        }
    }

    public static void main(String[] args) throws IOException {
        SocketServerImpl socketServer = new SocketServerImpl();
        socketServer.start();
    }
}



