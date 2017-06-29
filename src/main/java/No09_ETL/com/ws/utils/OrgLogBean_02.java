package No09_ETL.com.ws.utils;

import No09_ETL.com.ws.commone.Constant;
import No09_ETL.com.ws.config.ConfigManger;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */

public class OrgLogBean_02 implements Serializable {

    private String logSep = ConfigManger.getStr(Constant.SEP_IN_LOG);
    private String keyValueSep = ConfigManger.getStr(Constant.SEP_IN_KEY_VALUE);
    private String[] nginxFields = ConfigManger.getStr(Constant.NGINX_FIELDS).trim().split("[\t;,]");
    private String[] requestBodyFields = ConfigManger.getStr(Constant.REQUESTBODY_FIELDS).trim().split("[\t;,]");
    private HashMap<String, String> orgFieldMap;


    public OrgLogBean_02() {
        init();
    }


    public void init() {
        this.orgFieldMap = null;
    }


    public void setOrgFieldValue(String log) {
        int nginxFieldNum = nginxFields.length;
        String[] logFields = log.trim().split(logSep);

        /*设置nginx字段*/
        for (int i = 0; i < nginxFieldNum; i++) {
            orgFieldMap.put(
                    nginxFields[i],
                    logFields[i]);
        }

        /*设置requestBody字段*/
        for (int i = nginxFieldNum; i < logFields.length; i++) {
            int index_sep = logFields[i].indexOf(ConfigManger.getStr(Constant.SEP_IN_KEY_VALUE));
            orgFieldMap.put(
                    logFields[i].substring(0, index_sep),
                    logFields[i].substring(index_sep).replace(ConfigManger.getStr(Constant.SEP_IN_KEY_VALUE), "")
            );
        }
    }


    public Map getOrgFieldMap() {
        return orgFieldMap;
    }
}
