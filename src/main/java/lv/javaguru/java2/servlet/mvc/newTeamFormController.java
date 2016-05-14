package lv.javaguru.java2.servlet.mvc;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by NightStranger on 4/7/2016.
 */

@Component
public class newTeamFormController implements MVCController {

    @Override
    public ModelAndView processRequest(HttpServletRequest req) {
        return new ModelAndView("/newTeamRegistration.jsp", null);
    }

}
