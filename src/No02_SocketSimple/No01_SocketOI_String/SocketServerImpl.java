package No02_SocketSimple.No01_SocketOI_String;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class SocketServerImpl {
    private int port = 19999;

    public SocketServerImpl() {
        System.err.println("server object has been created!");
    }

    public void start() {
        try (ServerSocket ss = new ServerSocket(port)) {
            while (true) {
                Socket socket = ss.accept();//阻塞 只到有远端连接接入
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintStream pw = new PrintStream(socket.getOutputStream(), true);
                String msg = null;
                while ((msg = br.readLine()) != null) {
                    System.out.println("received msg: " + msg);
                    pw.println("hello client!");
                    System.out.println("======== msg send back =======");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        SocketServerImpl socketServer = new SocketServerImpl();
        socketServer.start();
    }
}



