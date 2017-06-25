package No01_SocketSimple.No01_SocketOI_String;

import java.io.*;
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
            PrintStream pw = new PrintStream(socket.getOutputStream(),true);
            String msg = null;
            while ((msg = br.readLine()) != null) {
                System.out.println("received msg: " + msg);
                pw.println("hello client!");
                System.out.println("======== msg send back =======");
            }


        }
    }

    public static void main(String[] args) throws IOException {
        SocketServerImpl socketServer = new SocketServerImpl();
        socketServer.start();
    }
}



