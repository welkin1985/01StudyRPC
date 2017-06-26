package No01_ThreadStudy.No01_MultThreads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 */
public class ThreadSimple {
    private static int i = 0;
    private static int j = 0;
    public List<String> arrayList = Collections.synchronizedList(new ArrayList<String>());
    public ConcurrentHashMap map = new ConcurrentHashMap();
    CopyOnWriteArrayList list = new CopyOnWriteArrayList();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i <= 300) {
                    i++;
                    System.out.println(i);
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i <= 300) {
                    i++;
                    System.out.println(i);
                }
            }
        });
        t2.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i <= 300) {
                    i++;
                    System.out.println(i);
                }
            }
        }).start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i <= 300) {
                    i++;
                    System.out.println(i);
                }
            }
        });
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("=================");
        Thread t4 = new Thread(new Runnable() {
            @Override
            public synchronized void run() {

                while (j <= 300) {
                    j++;
                    System.out.println("j: " + j);
                }
            }
        });
        t4.start();

        Thread t5 = new Thread(new Runnable() {
            @Override
            public synchronized void run() {

                while (j <= 300) {
                    j++;
                    System.out.println("j: " + j);
                }
            }
        });
        t5.start();
    }
}
