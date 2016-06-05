package lv.javaguru.java2.servlet.mvc;

/**
 * Created by NightStranger on 6/3/2016.
 */
public class FilterItem {

    Long id;
    String name;

    public Long getId() {
        return id;
    }

    public FilterItem(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }
}
