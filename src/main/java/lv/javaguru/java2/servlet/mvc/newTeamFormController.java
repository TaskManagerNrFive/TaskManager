package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by NightStranger on 4/7/2016.
 */
public class newTeamFormController implements MVCController {

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        return new MVCModel("/newTeamRegistration.jsp", null);
    }

}
