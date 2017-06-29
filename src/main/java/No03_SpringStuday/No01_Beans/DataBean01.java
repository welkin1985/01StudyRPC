package No03_SpringStuday.No01_Beans;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *
 */
@Repository
public class DataBean01 implements IData {
    private String name;
    private int age;

    @PostConstruct
    public void init() {

    }

    @PreDestroy
    public void atEnd() {

    }


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
