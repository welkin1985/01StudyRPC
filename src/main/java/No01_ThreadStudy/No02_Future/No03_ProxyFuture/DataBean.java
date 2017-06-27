package No01_ThreadStudy.No02_Future.No03_ProxyFuture;

/**
 *
 */
public class DataBean implements Asyncable {
    String name;

    public DataBean() {
    }

    public DataBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
