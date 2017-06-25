package No01_SocketSimple.No03_SocketRPC_ctrl;

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
    private ServerSocket ss = null;

    public Socket_S() {

    }

    public void startServer() throws ClassNotFoundException, NoSuchMethodException {
        try {
            ss = new ServerSocket(port);
            System.err.println("server started!");
            {
                while (true) {
                    Socket socket = ss.accept();
                    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                    Object object = objectInputStream.readObject();
                    RefBean refBean = (RefBean) object;
                    Class clazz = Class.forName(refBean.getClazzName());
                    Object o = clazz.newInstance();
                    Method method = clazz.getMethod(refBean.getMethonName(), clazz);
                    method.invoke()
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
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
