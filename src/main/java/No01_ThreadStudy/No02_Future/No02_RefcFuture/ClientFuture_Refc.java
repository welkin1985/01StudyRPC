package No01_ThreadStudy.No02_Future.No02_RefcFuture;

import No01_ThreadStudy.No02_Future.commBean.DataBean;

/**
 *
 */
public class ClientFuture_Refc {


    public AsData_Refc requestData(final String name) {
        final AsData_Refc asDataRefc = new AsData_Refc();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                DataBean dataBean = new DataBean();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dataBean.setName(name);
                asDataRefc.setDataBean(dataBean);

            }
        });
        thread.start();
        System.out.println("返回asData");
        return asDataRefc;
    }


    public static void main(String[] args) {
        ClientFuture_Refc clientFuture = new ClientFuture_Refc();
        /**
         * 下面这条语句新开启了一个线程，模拟的远端情况求，没有被阻塞
         * */
        AsData_Refc asDataRefc = clientFuture.requestData("give me some data");

        System.out.println("准备获取asData");
        /**
         * 下面这条语句模拟的是我们进行完了其他任务操作，
         * 在获取最终数据时，要等待另一个线程操作完毕，才能取值。
         * */
        DataBean dataBean = (DataBean) asDataRefc.getDataBean();//asData的get方法是阻塞的，当asData的值被set完毕后，此方法才能调用；
        System.out.println(dataBean.getName());


    }


}
