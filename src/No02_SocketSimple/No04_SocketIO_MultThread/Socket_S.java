package No02_SocketSimple.No04_SocketIO_MultThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class Socket_S {
    private int port = 19999;
    private ServerSocket serverSocket;

    public void start() {
        try {
            //new ServerSocket(port)不要放到循环中
            serverSocket = new ServerSocket(port);
            System.out.println(Thread.currentThread().getName() + "  server started!");
            {
                while (true) {
                    //虽然进程在此处等待，但是一旦有连接请求接入，可以直接交由线程处理，
                    //不妨碍后去连接接入
                    try {

                        Socket accept = serverSocket.accept();
                        {
                            new Thread(new HandlerAccept(accept)).start();
                            System.out.println("当前线程数" + Thread.activeCount());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Socket_S().start();
    }

}
