package No02_SocketSimple.No04_SocketIO_MultThread;

import java.io.*;
import java.net.Socket;

/**
 *
 */
public class Socket_C {
    int port = 19999;
    String address = "127.0.0.1";

    public void stratClient() throws IOException, InterruptedException {
        Socket s = null;
        s = new Socket(address, port);
        System.out.println("client start!");
        // 网络通信中，输入流和输出流要有对应关系，
        PrintStream out = new PrintStream(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        out.println("hello Server , I am a client! 1");//注意是println 不是print 也不是 write
        System.err.println("msg has send!");
        String msg = null;
        while (true) {
            msg = in.readLine();// 也会存在阻塞状态
            if (msg != null) {
                System.out.println("received msg from server: " + msg);
            } else {
                System.out.println("waiting...");
                Thread.sleep(1000);
            }
        }


    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new Socket_C().stratClient();
    }
}
