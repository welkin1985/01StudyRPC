package No09_ETL.com.ws.beans.impl;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 */

public class OrgLogBean implements Serializable {

    private HashMap<String, String> orgLogMap = new HashMap<>();

    public OrgLogBean() {}

    public OrgLogBean(HashMap<String, String> orgLogMap) {
        this.orgLogMap = orgLogMap;
    }

    public HashMap<String, String> getOrgLogMap() {
        return orgLogMap;
    }

    public void setOrgLogMap(HashMap<String, String> orgLogMap) {
        this.orgLogMap = orgLogMap;
    }


}
