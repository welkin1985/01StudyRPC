import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;

/**
 *
 */
@Component
public class Utils {

    private static Logger log = Logger.getLogger(Utils.class.getName());
    private static ThreadPoolExecutor threadPoolExecutor;

    private Utils() {
    }


    public static ThreadPoolExecutor getExecutor() {
        if (threadPoolExecutor == null) {
            synchronized (Utils.class) {
                if (threadPoolExecutor == null) {
                    threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
                }
            }
        }
        return threadPoolExecutor;
    }

    public static BufferedReader getBufferReader(Socket socket) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            log.warning("获取socket连接异常");
            e.printStackTrace();
        }
        return br;
    }


}
