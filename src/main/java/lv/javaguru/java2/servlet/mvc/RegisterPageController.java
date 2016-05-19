package lv.javaguru.java2.servlet.mvc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RegisterPageController {

    @RequestMapping(value = "/registration", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {
        return new ModelAndView("/registerPage", "data", null);
    }
}

    /*@Autowired
    @Qualifier("ORM_UserDAO")
    private UserDAO userDAO;

    @RequestMapping(value = "register", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");

        if (request.getMethod().equals("POST")) {

            User user = createUser(request.getParameter("firstName"),
                    request.getParameter("lastName"),
                    request.getParameter("email"),
                    request.getParameter("login"),
                    request.getParameter("password"));

            if(checkFields(user)) return modelAndView.addObject("model", "Заполните все поля!");
            if (checkIfUserExists(user)) {
                try {
                    userDAO.create(user);
                } catch (DBException e) {
                    e.printStackTrace();
                    return modelAndView.addObject("model","Something gone wrong with DB.");
                }
            } else {
                return modelAndView.addObject("model", "Такой пользователь уже есть!");
            }
        }
        modelAndView.addObject("model", null);
        return modelAndView;
    }

    private User createUser(String firstName, String lastName, String email,
                            String login, String password) {

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        return user;
    }

    private boolean checkFields(User user) {
        return (user.getFirstName().isEmpty()
                || user.getLastName().isEmpty()
                || user.getLogin().isEmpty()
                || user.getPassword().isEmpty()
                || user.getEmail().isEmpty());
    }

    private boolean checkIfUserExists(User user) {

        User testUser = null;
        try {
            testUser = userDAO.getByLogin(user.getLogin());
        } catch (DBException e) {
            e.printStackTrace();
        }

        if (testUser == null) return true;
        else return false;
    }*/

