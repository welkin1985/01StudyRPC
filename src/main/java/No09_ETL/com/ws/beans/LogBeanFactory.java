package No09_ETL.com.ws.beans;

import No09_ETL.com.ws.beans.impl.ETLedLogBean;
import No09_ETL.com.ws.beans.impl.OrgLogBean;
import No09_ETL.com.ws.commone.Constant;
import No09_ETL.com.ws.config.ConfigManger;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * The type Log bean factory.
 */
public class LogBeanFactory {
    final private static String[] nginxFields = ConfigManger.getStr(Constant.FIELDS_IN_NGINX).trim().split("[\t;,]");
    final private static String[] requestBodyFields = ConfigManger.getStr(Constant.FIELDS_IN_REQUESTBODY).trim().split("[\t;,]");
    final private static String sepNginxKV = ConfigManger.getStr(Constant.SEP_BETWEEN_NGINX_KV);
    final private static String sepRequestBodyKV = ConfigManger.getStr(Constant.SEP_BETWEEN_REQUESTBODY_KV);
    final private static boolean isNginxAhead = ConfigManger.getBoolean(Constant.IS_NGINX_AHEAD_REQUEST_BODY);
    final private static boolean isNginxContainTitle = ConfigManger.getBoolean(Constant.IS_NGINX_CONTAIN_TITLE);
    final private static String[] etlFields = ConfigManger.getStr(Constant.FIELDS_AFTER_ETL).trim().split("[\t;,]");
    final private static String seqInLog = ConfigManger.getStr(Constant.SEP_IN_ALL_LOG_REGEX);
    final private static String seqBetweenKV = ConfigManger.getStr(Constant.SEP_BETWEEN_ALL_KV_REGEX);

    private static OrgLogBean orgLogBean;
    private static ETLedLogBean etledLogBean;
    private static Logger logger = Logger.getGlobal();

    private LogBeanFactory() {
    }


    public static OrgLogBean setAngGetOrgLogBen(String log) {
        /**
         * 切分log日志为String数组
         * */
        final String[] logKeyValues = log.trim().split(seqInLog);

        /**


         /**
         * 校验日志字段有效性
         * */
        // 长度不足 =>直接返回null
        if (logKeyValues.length < nginxFields.length) {
            logger.warning("日志切分结果无效");
            return orgLogBean;
        }

        //  nginx字段没有包含title情况下，却出现了=号           => 直接返回null
        //  nginx字段没有包含title情况下，也没有出现了=号       => 补全nginx字段的title

        if (!isNginxContainTitle) {
            if (isNginxAhead) {
                for (int i = 0; i < nginxFields.length; i++) {
                    if (logKeyValues[i].contains(sepNginxKV)) {
                        return null;
                    } else {
                        logKeyValues[i] = nginxFields[i] + sepNginxKV + logKeyValues[i];
                    }
                }
            } else {
                int nginxFieldPoint = logKeyValues.length - nginxFields.length;
                for (int i = nginxFieldPoint; i < logKeyValues.length; i++) {
                    if (logKeyValues[i].contains(sepNginxKV)) {
                        return null;
                    } else {
                        logKeyValues[i] = nginxFields[i-nginxFieldPoint] + sepNginxKV + logKeyValues[i];
                    }
                }
            }
        }

        /**
         * 将log载入Bean
         * */
        //  初始化orgLogBean容器，保证其初始字段内容完整，并设置默认值为“”，然后获得其Map字段
        initOrgLogBean();
        HashMap<String, String> orgFieldMap = orgLogBean.getOrgLogMap();
        for (String str : logKeyValues) {
            String replace = str.trim().replace(sepNginxKV, sepRequestBodyKV);
            orgFieldMap.put(
                    replace.trim().substring(0, replace.indexOf(sepRequestBodyKV)),
                    replace.trim().substring(replace.indexOf(sepRequestBodyKV)).replace(sepRequestBodyKV, "")
            );
        }
        return orgLogBean;
    }


    private static void initOrgLogBean() {
        if (orgLogBean == null) {
            synchronized (LogBeanFactory.class) {
                if (orgLogBean == null) {
                    orgLogBean = new OrgLogBean();
                }
            }
        }

        HashMap<String, String> logMap = orgLogBean.getOrgLogMap();
        for (String s : logMap.keySet()) {
            logMap.remove(s);
        }
        for (String str : nginxFields) {
            logMap.put(str, "");
        }

        for (String str : requestBodyFields) {
            logMap.put(str, "");
        }
    }


    public static ETLedLogBean getInitETLBean() {
        if (etledLogBean == null) {
            synchronized (LogBeanFactory.class) {
                if (etledLogBean == null) {
                    etledLogBean = new ETLedLogBean();
                }
            }
        }

        etledLogBean.getOutkeyValue().clear();
        for (String etlField : etlFields) {
            etledLogBean.getOutkeyValue().put(etlField, "-");
        }

        return etledLogBean;

    }


}
