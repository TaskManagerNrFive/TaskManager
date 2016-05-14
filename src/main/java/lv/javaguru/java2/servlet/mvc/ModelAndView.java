package lv.javaguru.java2.servlet.mvc;


/**
 * Created by andrew on 3/29/16.
 */
public class ModelAndView {

    private String jspName;
    private Object data;

    public ModelAndView(String jspName, Object data) {
        this.jspName = jspName;
        this.data = data;
    }

    public String getJspName() {
        return jspName;
    }

    public Object getData() {
        return data;
    }

}