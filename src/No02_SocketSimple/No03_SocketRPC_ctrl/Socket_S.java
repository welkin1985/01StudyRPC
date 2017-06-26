package No02_SocketSimple.No03_SocketRPC_ctrl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class Socket_S {
    private int port = 19999;

    public Socket_S() {

    }

    public void startServer() throws ClassNotFoundException, NoSuchMethodException {
        try (
                ServerSocket ss = new ServerSocket(port);
        ) {//jdk7新特性，{}包裹io流则不用手动关闭，但必须以try开始
            System.err.println("server started!");
            while (true) {
                try (
                        Socket socket = ss.accept();
                        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())
                ) {
                    Object object = objectInputStream.readObject();
                    //解析操作命令，反射调用操作命令指示的类对象和方法
                    RefBean refBean = (RefBean) object;
                    Class clazz = Class.forName(refBean.getClazzName());
                    Object msg = clazz.newInstance();
                    Method method = clazz.getMethod(refBean.getMethonName(), String.class);
                    Object invoke = method.invoke(msg, refBean.getValue());
                    Method printMsg = clazz.getMethod("printMsg");
                    printMsg.invoke(msg);
                }
            }
        } catch (IOException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new Socket_S().startServer();
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
