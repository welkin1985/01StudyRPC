package No02_SocketSimple.No05_SocketIO_SimpleThreadPool___;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class Socket_S {
    private final int PORT = 19999;
    private static final int THREAD_POOL_SIZE = 10;

    public Socket_S() {

    }

    public void startServer() {
        try (
                ServerSocket ss = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = ss.accept();
                Thread thread = SimpleThreadPool.getThread();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

    }
}
