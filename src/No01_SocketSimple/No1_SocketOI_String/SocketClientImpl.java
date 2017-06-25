package No01_SocketSimple.No1_SocketOI_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 */
public class SocketClientImpl {
    int port = 19999;
    String address = "127.0.0.1";

    public void stratClient() throws IOException {
        Socket s = new Socket(address, port);
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        pw.println("hello Server , I am a client!");
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.err.println("msg has send!");
        String msg = null;
        while ((msg = br.readLine()) != null) {
            System.out.println("received msg from server: " + msg);
        }

    }

    public static void main(String[] args) throws IOException {
        SocketClientImpl socketClient = new SocketClientImpl();
        socketClient.stratClient();
    }
}
