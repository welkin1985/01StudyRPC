package No03_SpringStuday.No01_Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class Demo01 implements IData {

    @Autowired
    private IData dataBean01;

    @Autowired
    private IData dataBean02;


    public static void main(String[] args) {
        final AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IData demo01 = context.getBean("dataBean01", IData.class);
        System.out.println(demo01.toString());

        new Thread(new Runnable() {
            @Override
            public void run() {

                IData demo01 = context.getBean("dataBean01", IData.class);

                System.out.println(demo01.toString());
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                IData demo01 = context.getBean("dataBean01", IData.class);
                System.out.println(demo01.toString());
            }
        }).start();

        context.registerShutdownHook();

    }

}
