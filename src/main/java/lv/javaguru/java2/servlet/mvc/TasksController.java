package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.*;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andrew on 4/30/16.
 */
@Component
public class TasksController implements MVCController {

    @Autowired
    @Qualifier("JDBC_TaskDAO")
    private TaskDAO taskDAO;

    @Autowired
    @Qualifier("JDBC_UserDAO")
    private UserDAO userDAO;

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        List<Map> list = new ArrayList<>();
        Map<String,List> tasksMap = new HashMap<>();
        Map<Long,String> usersMap = new HashMap<>();

        List<Task> allTasks = new ArrayList<Task>();

        try {

            allTasks = taskDAO.getAll();
            tasksMap.put("tasks", allTasks);
            list.add(tasksMap);

            List<User> users = new ArrayList<User>();
            users = userDAO.getAll();

            for(User uu:users) {
                usersMap.put(uu.getUserId(), uu.getFullName());
            }

            list.add(usersMap);

        } catch (Exception e) {
            System.out.println(e);
        }

        return new MVCModel("/tasks.jsp", list);
    }
}
