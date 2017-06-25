package No02_SocketSimple.No05_SocketIO_SimpleThreadPool___;

import java.util.ArrayList;

/**
 *
 */
public class SimpleThreadPool {
    private static final int POOLSIZE = 10;
    private static ArrayList<Thread> pool = null;

    private SimpleThreadPool() {

    }


    public static Thread getThread() {
        if (pool == null) {
            synchronized (SimpleThreadPool.class) {
                if (pool == null) {
                    pool = new ArrayList<Thread>();
                    for (int i = 0; i < POOLSIZE; i++) {
                        pool.add(new Thread());
                    }

                }
            }
        }
        return pool.get(1);
    }
}
