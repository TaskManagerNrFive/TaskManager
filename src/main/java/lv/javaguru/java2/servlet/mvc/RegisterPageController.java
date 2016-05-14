package lv.javaguru.java2.servlet.mvc;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RegisterPageController implements MVCController {

    @Override
    public ModelAndView processRequest(HttpServletRequest req) {
        return new ModelAndView("/registerPage.jsp", null);
    }


}

