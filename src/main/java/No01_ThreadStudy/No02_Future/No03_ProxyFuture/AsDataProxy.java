package No01_ThreadStudy.No02_Future.No03_ProxyFuture;


import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * AsData设计要点
 * 1、 implements Serializable
 * 2、 组合要处理的类
 * 3、 设置判断标记
 * 4、 get和Set方法要加锁，并有相互间的notify()和wait
 */
public class AsDataProxy implements Serializable, Asyncable {
    private Asyncable asyncable;
    private AtomicBoolean isSetted = new AtomicBoolean(false);

    public AsDataProxy(Asyncable asyncable) {
        this.asyncable = asyncable;
    }

    @Override
    public void setName(String name) {
        isSetted.set(false);
        this.asyncable.setName(name);
        isSetted.set(true);
    }

    @Override
    public String getName() {
        while (!isSetted.get()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.asyncable.getName();
    }
}
