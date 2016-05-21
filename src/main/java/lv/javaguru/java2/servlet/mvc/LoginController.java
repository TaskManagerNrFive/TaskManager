package lv.javaguru.java2.servlet.mvc;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class LoginController {

    @Autowired
    @Qualifier("JDBC_UserDAO")
    private UserDAO userDAO;

    @RequestMapping(value = "/loginUser", method = {RequestMethod.POST})
    public ModelAndView processGetRequest(HttpServletRequest req){
        String message = null;

        try {

            String login = req.getParameter("login");
            String password = req.getParameter("password");

            User user = null;
            user = userDAO.getByLogin(login);

            if (user == null) {
               message = "Login or password is wrong";
            }

            if (user.getPassword().equals(password)) {
                req.getSession().setAttribute("User", user);
            } else {
                message = "Login or password is wrong";
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return new ModelAndView("helloWorld", "data", message);

    }
}

