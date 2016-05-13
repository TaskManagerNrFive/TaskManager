package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.TaskTypeDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.TaskType;
import lv.javaguru.java2.domain.User;
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
import java.util.logging.Logger;

/**
 * Created by andrew on 5/1/16.
 */

@Controller
public class EditTaskController {

    @Autowired
    @Qualifier("JDBC_TaskDAO")
    private TaskDAO taskDAO;

    @Autowired
    @Qualifier("ORM_TaskTypeDAO")
    private TaskTypeDAO taskTypeDAO;

    @Autowired
    @Qualifier("JDBC_UserDAO")
    private UserDAO userDAO;

//    private static Logger logger = Logger.getLogger(TaskTypesController.class.getName());
    @RequestMapping(value = "/editTask", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {
        ModelAndView mvcModel;
        List<Object> list = new ArrayList<>();

        try {
            int taskId = Integer.parseInt(req.getParameter("taskId"));
            Task task = null;

//            logger.info(req.getParameter("taskId"));

            task = taskDAO.getById(taskId);
            list.add(task);

            List<TaskType> allTaskTypes = new ArrayList<TaskType>();
            allTaskTypes = taskTypeDAO.getAll();
            list.add(allTaskTypes);

            List<User> allResponsibles = new ArrayList<User>();
            allResponsibles = userDAO.getAll();
            list.add(allResponsibles);

            mvcModel = new ModelAndView("/editTaskForm", "data", list);
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/editTaskForm", "data", "Save error has occured, try later.");
        }
        return mvcModel;
    }
}
