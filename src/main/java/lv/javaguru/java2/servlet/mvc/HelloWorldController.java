package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by NightStranger on 3/29/2016.
 */
public class HelloWorldController implements MVCController {

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        return new MVCModel("/helloWorld.jsp", "Hello from MVC!");
    }

}
