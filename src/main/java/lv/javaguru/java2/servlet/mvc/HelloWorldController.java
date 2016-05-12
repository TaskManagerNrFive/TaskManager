package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

//    @Autowired
//    private UserDAO userDAO;

    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {
        return new ModelAndView("/helloWorld", "data", null);
    }
}
