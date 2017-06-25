package No01_SocketSimple.No03_SocketRPC_ctrl;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 */
public class Socket_C {
    private String add = "127.0.0.1";
    private int port = 19999;
    private Socket socket = null;
    public void startCli() {

        try {
            socket = new Socket(add, port);
            {
                RefBean refBean = new RefBean();
                refBean.setClazzName("MessageBean");
                refBean.setMethonName("getMsg");
                refBean.setValue("cmd from client");
                ObjectOutputStream oo = new ObjectOutputStream(socket.getOutputStream());
                oo.writeObject(refBean);
                while (true){

                }


            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Socket_C().startCli();
    }
}
