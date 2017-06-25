package No02_SocketSimple.No03_SocketRPC_ctrl;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
            {//jdk7新特性，{}包裹io流则不用手动关闭，但必须以try开始
                //封装一个操作命令的对象，包含了操作谁，什么方法，什么值
                RefBean refBean = new RefBean();
                refBean.setClazzName(MessageBean.class.getName());
                refBean.setMethonName("setMsg");
                refBean.setValue("cmd from client");
                ObjectOutputStream oo = new ObjectOutputStream(socket.getOutputStream());
                oo.writeObject(refBean);
                while (true) {

                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Socket_C().startCli();
    }
}
