package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by NightStranger on 5/19/2016.
 */
@Controller
public class DeleteTeamUserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/deleteTeamUser") //, method = {RequestMethod.POST})
    @Transactional
    public ModelAndView processRequest(HttpServletRequest req) {

        ModelAndView mvcModel;
        try {
            long teamId = Long.parseLong(req.getParameter("teamId"));
            long userId = Long.parseLong(req.getParameter("userId"));
            userService.updateTeamId(userId, 0);
            mvcModel = new ModelAndView("/redirect", "data", "editTeamUsers?teamId=" + teamId);
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/helloWorld", "data", "Error!");
        }
        return mvcModel;
    }

}
