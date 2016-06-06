package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by NightStranger on 4/7/2016.
 */

@Controller
public class newTeamFormController {

    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "/newTeam") // method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {

        User sessionUser = accountManager.getUserFromSession(req.getSession());
        if (sessionUser == null) {
            return new ModelAndView("/redirect", "data", "");
        }

        return new ModelAndView("/newTeamRegistration", "data", null);
    }

}
