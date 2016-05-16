package lv.javaguru.java2.servlet.mvc;

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

    @RequestMapping(value = "/newTeam") // method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {
        return new ModelAndView("/newTeamRegistration", "data", null);
    }

}
