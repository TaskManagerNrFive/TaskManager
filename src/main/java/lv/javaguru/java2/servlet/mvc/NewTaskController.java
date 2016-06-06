package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskTypeDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.TaskType;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 5/1/16.
 */
@Controller
public class NewTaskController {

    @Autowired
    @Qualifier("ORM_TaskTypeDAO")
    private TaskTypeDAO taskTypeDAO;

    @Autowired
    @Qualifier("JDBC_UserDAO")
    private UserDAO userDAO;

    private List<Object> list = new ArrayList<>();

    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "/newTask", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {

        User sessionUser = accountManager.getUserFromSession(req.getSession());
        if (sessionUser == null) {
            return new ModelAndView("/redirect", "data", "");
        }

        ModelAndView mvcModel;
        try {
            List<TaskType> allTaskTypes = new ArrayList<TaskType>();
            allTaskTypes = taskTypeDAO.getAll();
            list.add(allTaskTypes);

            List<User> allResponsibles = new ArrayList<User>();
            allResponsibles = userDAO.getAll();
            list.add(allResponsibles);

            mvcModel = new ModelAndView("/newTaskForm", "data", list);
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/editTaskForm", "data", "Save error has occured, try later.");
        }
        return mvcModel;
    }
}
