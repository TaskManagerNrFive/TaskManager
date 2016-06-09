package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * Created by NightStranger on 6/9/2016.
 */

@Component
public class TestUtilities {

    public User createUser(String firstName, String lastName, String email,
                            String login, String password, Long teamId) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        return user;
    }

    public Task createTask(Date dueDate, Date doneDate, String title,
                           long userId, long responsibleId) {
        Task task = new Task();
        task.setDueDate(dueDate);
        task.setDoneDate(doneDate);
        task.setTitle(title);
        task.setUserId(userId);
        task.setResponsibleId(responsibleId);
        return task;
    }

}
