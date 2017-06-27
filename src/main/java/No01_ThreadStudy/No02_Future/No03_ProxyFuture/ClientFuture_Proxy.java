package No01_ThreadStudy.No02_Future.No03_ProxyFuture;


/**
 *
 */
public class ClientFuture_Proxy {


    public AsDataProxy requestData(final String name) {
        final AsDataProxy asDataProxy = new AsDataProxy(new DataBean());


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    asDataProxy.setName(name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        System.out.println("返回asData");
        return asDataProxy;
    }


    public static void main(String[] args) {
        ClientFuture_Proxy clientFuture = new ClientFuture_Proxy();
        /**
         * 下面这条语句新开启了一个线程，模拟的远端情况求，没有被阻塞
         * */
        AsDataProxy asDataProxy = clientFuture.requestData("give me some data");

        System.out.println("准备获取asData");
        /**
         * 下面这条语句模拟的是我们进行完了其他任务操作，
         * 在获取最终数据时，要等待另一个线程操作完毕，才能取值。
         * */
        System.out.println(asDataProxy.getName());


    }


}
