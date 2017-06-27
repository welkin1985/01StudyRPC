package No01_ThreadStudy.No02_Future.No04_DomaticProxyFuture____;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 */
public class AsDataBean {
    public AsDataBean() {
    }

    public static Object getProxyObject() {
        IData iData = (IData) Proxy.newProxyInstance(AsDataBean.class.getClassLoader(), new Class[]{IData.class}, new InvocationHandler() {
            Object targ = new DataBean();

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = method.invoke(targ);
                return invoke;
            }
        });

        return iData;

    }


}


