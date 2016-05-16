package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    @Qualifier("JDBC_UserDAO")
    UserDAO userDAO;

    public void createUser(User user) {
        try {
            userDAO.create(user);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public boolean loginUser(String login, String passw) {
        User user = new User();
        try {
            user = userDAO.getByLogin(login);
        } catch (DBException e) {
            e.printStackTrace();
        }

        return user.getPassword().equals(passw);
    }
}
