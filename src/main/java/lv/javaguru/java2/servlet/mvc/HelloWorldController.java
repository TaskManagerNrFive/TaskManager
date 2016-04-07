package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by NightStranger on 3/29/2016.
 */

@Component
public class HelloWorldController implements MVCController {

    @Autowired
    private UserDAO userDAO;

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        return new MVCModel("/helloWorld.jsp", "Hello from MVC!");
    }

}
