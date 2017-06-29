package No09_ETL.com.ws.beans.impl;

import No09_ETL.com.ws.commone.Constant;
import No09_ETL.com.ws.config.ConfigManger;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */

public class OrgLogBean implements Serializable {

    private HashMap<String, String> orgLogMap;

    public OrgLogBean() {
    }

    public OrgLogBean(HashMap<String, String> orgLogMap) {
        this.orgLogMap = orgLogMap;
    }

    public HashMap<String, String> getOrgLogMap() {
        return orgLogMap;
    }

    public void setOrgLogMap(HashMap<String, String> orgLogMap) {
        this.orgLogMap = orgLogMap;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : orgLogMap.entrySet()) {
            sb.append(entry.getKey() + ConfigManger.getStr(Constant.SEP_AFTER_ETL) + entry.getValue());
        }

        return sb.substring(0, -1);
    }
}
