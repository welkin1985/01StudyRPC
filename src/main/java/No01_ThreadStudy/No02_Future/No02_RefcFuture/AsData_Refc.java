package No01_ThreadStudy.No02_Future.No02_RefcFuture;

import java.io.Serializable;

/**
 *AsData设计要点
 * 1、 implements Serializable
 * 2、 组合要处理的类
 * 3、 设置判断标记
 * 4、 get和Set方法要加锁，并有相互间的notify()和wait
 */
public class AsData_Refc implements Serializable {
    private Object obj;
    private boolean isSetted = false;

    public AsData_Refc() {

    }


    public synchronized void setDataBean(Object dataBean) {
        isSetted = false;
        this.obj = dataBean;
        isSetted = true;
        notify();
    }

    public synchronized Object getDataBean() {
        while (!isSetted) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.obj;
    }


}
