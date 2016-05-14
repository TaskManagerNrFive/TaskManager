package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RegisterUserController implements MVCController {

    @Autowired
    UserService userService;

    @Override
    public ModelAndView processRequest(HttpServletRequest req) {
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        userService.createUser(user);
        return new ModelAndView("/helloWorld.jsp", null);
    }
}
