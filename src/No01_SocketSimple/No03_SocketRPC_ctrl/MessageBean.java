package No01_SocketSimple.No03_SocketRPC_ctrl;

import java.io.Serializable;

/**
 *
 */
public class MessageBean implements Serializable {
    private String msg = "hello";

    @Override
    public String toString() {
        return "MessageBean{" +
                "msg='" + msg + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void printMsg() {
        System.out.println(msg);
    }


}
