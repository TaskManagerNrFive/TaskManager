package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andrew on 5/14/16.
 */
@Controller
public class UserTasksController {
    @Autowired
    @Qualifier("JDBC_TaskDAO")
    private TaskDAO taskDAO;

    @Autowired
    @Qualifier("JDBC_UserDAO")
    private UserDAO userDAO;

    @RequestMapping(value = "/userTasks", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {
        List<Object> list = new ArrayList<>();
        List<Task> allTasks = new ArrayList<Task>();

        try {
            int userId = Integer.parseInt(req.getParameter("userId"));
            Long longUserId = Long.parseLong(req.getParameter("userId"));
            allTasks = taskDAO.getAllTasksByUserId(userId);
            list.add(allTasks);

            User user = null;
            user = userDAO.getById(longUserId);

            list.add(user);

        } catch (Exception e) {
            System.out.println(e);
        }

        return new org.springframework.web.servlet.ModelAndView("/userTasks", "data", list);
    }
}
