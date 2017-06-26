package No02_SocketSimple.No02_SocketIO_Obj;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 */
public class Socket_C {
    private String add = "127.0.0.1";
    private int port = 19999;

    public void startCli() {

        try (Socket socket = new Socket(add, port);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ) {
            MessageBean msg = new MessageBean();
            msg.setMsg("new msg");
            objectOutputStream.writeObject(msg);
            System.out.println("object has send");
            while (true) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Socket_C().startCli();
    }
}
