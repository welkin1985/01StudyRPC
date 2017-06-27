package No01_ThreadStudy.No02_Future.No01_NormalFuture;

import No01_ThreadStudy.No02_Future.commBean.DataBean;

import java.io.Serializable;

/**
 *AsData设计要点
 * 1、 implements Serializable
 * 2、 组合要处理的类
 * 3、 设置判断标记
 * 4、 get和Set方法要加锁，并有相互间的notify()和wait
 */
public class AsData implements Serializable {
    private DataBean dataBean;
    private boolean isSetted = false;

    public AsData() {
    }


    public synchronized void setDataBean(DataBean dataBean) {
        isSetted = false;
        this.dataBean = dataBean;
        isSetted = true;
        notify();
    }

    public synchronized DataBean getDataBean() {
        while (!isSetted) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.dataBean;
    }


}
