package lv.javaguru.java2.servlet.mvc;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by NightStranger on 4/26/2016.
 */
@Component
public class IncorrectURLController implements MVCController {

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        return new MVCModel("/helloWorld.jsp", "Incorrect Page URL!");
    }

}
