
package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;

@Component
public class AccountManager {
    @Autowired
    @Qualifier("ORM_UserDAO")
    private UserDAO userDAO;

    private User getUserFromDB(String login) {
        User user = null;
        try {
            user = userDAO.getByLogin(login);
        } catch (DBException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void authorize(String login, String password, HttpSession session) throws LoginException {
        User user = getUserFromDB(login);
        if (user == null) throw new LoginException("Incorrect login");

        if (user.getPassword().equals(password)) {
            session.setAttribute("User", user);
        } else throw new LoginException("Incorrect password");
    }

    public boolean isAuthorized(HttpSession session) {
        return (session.getAttribute("User") != null);
    }

    public void logOffUserFromSession(HttpSession session) {
        session.removeAttribute("User");
    }

    public User getUserFromSession(HttpSession session) {
        User user;
        try {
            user = (User) session.getAttribute("User");
        }
        catch (Exception e) {
            user = null;
        }
        return user;
    }

}

