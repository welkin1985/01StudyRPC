package No02_SocketSimple.No02_SocketIO_Obj;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class Socket_S {
    private int port = 19999;
    private ServerSocket ss = null;

    public Socket_S() {

    }

    public void startServer() throws ClassNotFoundException {
        try {
            ss = new ServerSocket(port);
            System.err.println("server started!");
            {
                while (true) {
                    Socket socket = ss.accept();
                    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                    Object object = objectInputStream.readObject();
                    MessageBean msg = (MessageBean) object;
                    msg.printMsg();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new Socket_S().startServer();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
