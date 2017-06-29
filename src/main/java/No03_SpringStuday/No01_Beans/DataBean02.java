package No03_SpringStuday.No01_Beans;

import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class DataBean02 implements IData {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
