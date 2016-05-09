package lv.javaguru.java2.servlet.mvc;

/**
 * Created by Irrinka on 09-May-16.
 */

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RegisterPageController implements MVCController {

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        return new MVCModel("/registerPage.jsp", null);
    }

//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("register");
//
//        if (request.getMethod().equals("POST")) {
//
//            User user = createUser(request.getParameter("firstName"),
//                    request.getParameter("lastName"),
//                    request.getParameter("login"),
//                    request.getParameter("password"),
//                    request.getParameter("email"));
//
//            if (checkFields(user)) return modelAndView.addObject("model", "Заполните все поля!");
//
//            if (checkIfUserExists(user)) {
//                try {
//                    userDao.create(user);
//                } catch (DBException e) {
//                    e.printStackTrace();
//                    return modelAndView.addObject("model", "Something gone wrong with DB.");
//                }
//
//            } else {
//                return modelAndView.addObject("model", "Такой пользователь уже есть!");
//            }
//
//        }
//        modelAndView.addObject("model", null);
//        return modelAndView;
//    }
//
//    private User createUser(String firstName, String lastName, String login,
//                            String password, String email) {
//
//        User user = new User();
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setLogin(login);
//        user.setPassword(password);
//        user.setEmail(email);
//
//        return user;
//    }
//
//    private boolean checkFields(User user) {
//        return (user.getFirstName().isEmpty()
//                || user.getLastName().isEmpty()
//                || user.getLogin().isEmpty()
//                || user.getPassword().isEmpty()
//                || user.getEmail().isEmpty());
//    }
//
//    private boolean checkIfUserExists(User user) {
//
//        User testUser = null;
//        try {
//            testUser = userDao.getByLogin(user.getLogin());
//        } catch (DBException e) {
//            e.printStackTrace();
//        }
//
//        if (testUser == null) return true;
//        else return false;
//    }
}

