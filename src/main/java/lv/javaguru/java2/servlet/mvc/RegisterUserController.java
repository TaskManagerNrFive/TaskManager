package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;


@Controller
public class RegisterUserController {

    @Autowired
    @Qualifier("ORM_UserDAO")
    private UserDAO userDAO;

    @Transactional
    @RequestMapping(value = "/registerUser", method = {RequestMethod.POST})
    public org.springframework.web.servlet.ModelAndView processRequest(HttpServletRequest req) {
        org.springframework.web.servlet.ModelAndView mvcModel;
        try {
            User user = new User();
            String newFirstName = req.getParameter("firstName");
            String newLastName = req.getParameter("lastName");
            String newEmail = req.getParameter("email");
            String newLogin = req.getParameter("login");
            String newPassword = req.getParameter("password");
            user.setFirstName(newFirstName);
            user.setLastName(newLastName);
            user.setEmail(newEmail);
            user.setLogin(newLogin);
            user.setPassword(newPassword);
            userDAO.create(user);
            /* temporary */
            return new org.springframework.web.servlet.ModelAndView("/helloWorld", "data", "New user created!");
        } catch (Exception e) {
            mvcModel = new org.springframework.web.servlet.ModelAndView("/registerUser", "data", "Error!");
        }
        return mvcModel;
    }
}

