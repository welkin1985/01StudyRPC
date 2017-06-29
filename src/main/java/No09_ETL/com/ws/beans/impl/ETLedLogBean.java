package No09_ETL.com.ws.beans.impl;

import No09_ETL.com.ws.commone.Constant;
import No09_ETL.com.ws.config.ConfigManger;
import scala.Serializable;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ETLedLogBean implements Serializable {
    private HashMap<String, String> etledLogMap;


    public ETLedLogBean() {
    }

    public ETLedLogBean(HashMap<String, String> etledLogMap) {
        this.etledLogMap = etledLogMap;
    }

    public HashMap<String, String> getEtledLogMap() {
        return etledLogMap;
    }

    public void setEtledLogMap(HashMap<String, String> etledLogMap) {
        this.etledLogMap = etledLogMap;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : etledLogMap.entrySet()) {
            sb.append(entry.getKey() + ConfigManger.getStr(Constant.SEP_AFTER_ETL) + entry.getValue());
        }

        return sb.substring(0, -1);
    }
}
