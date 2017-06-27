package No01_ThreadStudy.No02_Future.No01_NormalFuture;

import No01_ThreadStudy.No02_Future.commBean.DataBean;

/**
 *
 */
public class ClientFuture {


    public AsData requestData(final String name) {
        final AsData asData = new AsData();
        /**
         * 此处相当于开启了一个新的线程请求，会直接返回一个asData对象，
         * 但是该对象的get方法不能被立即调用，需要等待被set后才能调用。
         * 因此此程序的运行情况应该是
         * 1、先直接显示了"返回asData"
         * 2、主程序显示准备获取asData
         * 3、等待5秒后，才获取成功。
         * */
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                DataBean dataBean = new DataBean();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dataBean.setName(name);
                asData.setDataBean(dataBean);

            }
        });
        thread.start();
        System.out.println("返回asData");
        return asData;
    }


    public static void main(String[] args) {
        ClientFuture clientFuture = new ClientFuture();
        /**
         * 下面这条语句新开启了一个线程，模拟的远端情况求，没有被阻塞
         * */
        AsData asData = clientFuture.requestData("give me some data");

        System.out.println("准备获取asData");
        /**
         * 下面这条语句模拟的是我们进行完了其他任务操作，
         * 在获取最终数据时，要等待另一个线程操作完毕，才能取值。
         * */
        DataBean dataBean = asData.getDataBean();//asData的get方法是阻塞的，当asData的值被set完毕后，此方法才能调用；
        System.out.println(dataBean.getName());


    }


}
