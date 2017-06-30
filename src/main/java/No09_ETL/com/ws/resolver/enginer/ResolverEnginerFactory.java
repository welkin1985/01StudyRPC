package No09_ETL.com.ws.resolver.enginer;

import No09_ETL.com.ws.commone.Constant;
import No09_ETL.com.ws.config.ConfigManger;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 *
 */
public class ResolverEnginerFactory {
    private static ResolverEnginer resolverEnginer;
    private static String[] argsArray = ConfigManger.getStr(Constant.RESOLVERS).split("[;]");
    private static String[] etledFields = ConfigManger.getStr(Constant.FIELDS_AFTER_ETL).split("[;]");

    public static void main(String[] args) {
        String[] argsArray = ConfigManger.getStr(Constant.RESOLVERS).split("[;]");
    }


    public static ResolverEnginer getEnginer(String args) {


        if (resolverEnginer == null) {
            synchronized (ResolverEnginerFactory.class) {
                if (resolverEnginer == null) {
                    resolverEnginer = new ResolverEnginer();
                }
            }
        }
        if (resolverEnginer.getArgsQueue() == null) {
            synchronized (ResolverEnginerFactory.class) {
                if (resolverEnginer.getArgsQueue() == null) {
                    resolverEnginer.setArgsQueue(new ConcurrentLinkedQueue<ArgBean>());
                }
            }
        }

        /**
         * 1 将每个解析器参数配置进ArgBean
         * 2 将每个ArgBean装配进ArgsQueue
         * */
        resolverEnginer.getArgsQueue().clear();
        for (String arg : argsArray) {
            ArgBean argBean = new ArgBean();
            /**
             * 1 提取解析器名
             * */
            argBean.setResolverName(StringUtils.substringBefore(arg, "("));

            /**
             * 2 配置解析器输入字段
             * */
            argBean.setInFiled(StringUtils.substringBetween("(", ")"));


            /**
             * 3 配置解析器输出字段
             */
            //提取全部要求的etl输出字段
            ArrayList<String> etledFieldArray = new ArrayList<>();
            etledFieldArray.addAll(Arrays.asList(etledFields));

            //提取解析器能够输出的字段
            ArrayList<String> resolverFieldArray = new ArrayList<>();

            try {
                String resolverPackagePath = "No09_ETL.com.ws.resolver.impl.";
                Class clazz = Class.forName(resolverPackagePath + argBean.getResolverName());
                Field[] resolverFields = clazz.getDeclaredFields();
                for (Field resolverField : resolverFields) {
                    resolverFieldArray.add(StringUtils.substringAfterLast(resolverField.toString(), "."));
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //交集提取该解析器要求输出的字段；
            resolverFieldArray.retainAll(etledFieldArray);
            argBean.setOutFiled(resolverFieldArray);
            resolverEnginer.getArgsQueue().add(argBean);
        }


        return resolverEnginer;
    }

}
