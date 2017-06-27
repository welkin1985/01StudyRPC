package No01_ThreadStudy.No02_Future.No04_DomaticProxyFuture____;

/**
 *
 */
public class DataBean implements IData {
    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
