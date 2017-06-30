package No09_ETL.com.ws.resolver.enginer;

import No09_ETL.com.ws.beans.LogBeanFactory;
import No09_ETL.com.ws.beans.impl.ETLedLogBean;
import No09_ETL.com.ws.beans.impl.OrgLogBean;
import No09_ETL.com.ws.commone.Constant;
import No09_ETL.com.ws.config.ConfigManger;
import org.junit.Test;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
public class ResolverEnginer {
    private ConcurrentLinkedQueue<ArgBean> argsQueue = new ConcurrentLinkedQueue<>();

    ResolverEnginer() {
    }


    ConcurrentLinkedQueue<ArgBean> getArgsQueue() {
        return argsQueue;
    }

    void setArgsQueue(ConcurrentLinkedQueue<ArgBean> argsQueue) {
        this.argsQueue = argsQueue;
    }

    public ETLedLogBean start(final OrgLogBean orgLogBean, final ETLedLogBean etLedLogBean) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (final ArgBean argBean : argsQueue) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(argBean.getResolverName());
                    System.out.println(argBean.getInFiled());
                    System.out.println(argBean.getOutFiled().toArray().toString());
                    System.out.println("==================");
                }
            });
        }
        executorService.shutdown();
        return etLedLogBean;
    }

    @Test
    public void demo() {
        ResolverEnginer enginer = ResolverEnginerFactory.getEnginer(ConfigManger.getStr(Constant.RESOLVERS));
        enginer.start(LogBeanFactory.setAngGetOrgLogBen("xxxxx"), LogBeanFactory.getInitETLBean());
    }

}
