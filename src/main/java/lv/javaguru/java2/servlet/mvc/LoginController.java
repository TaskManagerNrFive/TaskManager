package lv.javaguru.java2.servlet.mvc;
import lv.javaguru.java2.services.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "login", method = {RequestMethod.GET})
    public ModelAndView processGetRequest(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("mustlogin", "model", null);
    }
}

