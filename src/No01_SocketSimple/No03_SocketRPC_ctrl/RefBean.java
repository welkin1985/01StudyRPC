package No01_SocketSimple.No03_SocketRPC_ctrl;

import java.io.Serializable;

/**
 *
 */
public class RefBean implements Serializable{
    private String clazzName = "";
    private String methonName = "";
    private String value = "";

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getMethonName() {
        return methonName;
    }

    public void setMethonName(String methonName) {
        this.methonName = methonName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
