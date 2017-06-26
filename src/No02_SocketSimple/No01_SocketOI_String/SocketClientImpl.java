package No02_SocketSimple.No01_SocketOI_String;

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

    public void stratClient() {
        try (
                Socket s = new Socket(address, port);
                PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        ) {

            pw.println("hello Server , I am a client!");
            System.out.println("==========msg has send!=============");
            String msg = null;
            while (true) {
                msg = br.readLine();
                if (msg != null) {
                    System.out.println("received msg from server: " + msg);

                } else {
                    System.out.println("==== waiting =====");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("连接失败");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        SocketClientImpl socketClient = new SocketClientImpl();
        socketClient.stratClient();
    }
}
