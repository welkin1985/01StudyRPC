package No02_SocketSimple.No05_SocketIO_SimpleThreadPool___;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 */
public class HandlerAccept implements Runnable {
    private Socket socket;

    public HandlerAccept(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread start");
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintStream pw = new PrintStream(socket.getOutputStream())
        ) {
            String msg = null;
            while ((msg = br.readLine()) != null) {
                System.out.println("receive msg: " + msg);
                pw.println("i get your mgs:" + msg);
                System.out.println("has note client");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
