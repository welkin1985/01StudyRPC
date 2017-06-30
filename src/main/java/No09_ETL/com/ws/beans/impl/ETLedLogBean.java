package No09_ETL.com.ws.beans.impl;

import scala.Serializable;

import java.util.LinkedHashMap;

/**
 *
 */
public class ETLedLogBean implements Serializable {
    private LinkedHashMap<String, String> outkeyValue = new LinkedHashMap<>();


    public ETLedLogBean() {
    }

    public LinkedHashMap<String, String> getOutkeyValue() {
        return outkeyValue;
    }

    public void setOutkeyValue(LinkedHashMap<String, String> outkeyValue) {
        this.outkeyValue = outkeyValue;
    }
}
