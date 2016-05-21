package lv.javaguru.java2.servlet.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by andrew on 5/21/16.
 */
@Controller
public class LogOutController {

    @RequestMapping(value = "/logoutUser", method = {RequestMethod.GET})
    public ModelAndView processGetRequest(HttpServletRequest req){

        try {
            req.getSession().removeAttribute("User");

        } catch (Exception e) {
            System.out.println(e);
        }
        return new ModelAndView("helloWorld", "data", null);
    }
}
