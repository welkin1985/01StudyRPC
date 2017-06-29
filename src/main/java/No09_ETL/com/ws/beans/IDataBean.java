package No09_ETL.com.ws.beans;

import java.io.Serializable;

/**
 *
 */

public abstract class IDataBean implements Serializable {

    private String[] fieldList;
    private String regexSep;
    private String log;

    public IDataBean() {
    }

    public IDataBean(String log) {
    }

    public void setFieldList(String[] fieldList) {
        this.fieldList = fieldList;
    }

    public String[] getFieldList() {
        return fieldList;
    }

    public String getRegexSep() {
        return regexSep;
    }

    public void setRegexSep(String regexSep) {
        this.regexSep = regexSep;
    }


}
