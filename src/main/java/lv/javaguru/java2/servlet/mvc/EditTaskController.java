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

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by andrew on 5/1/16.
 */

@Component
public class EditTaskController implements MVCController {

    @Autowired
    @Qualifier("JDBC_TaskDAO")
    private TaskDAO taskDAO;

    @Autowired
    @Qualifier("ORM_TaskTypeDAO")
    private TaskTypeDAO taskTypeDAO;

    @Autowired
    @Qualifier("JDBC_UserDAO")
    private UserDAO userDAO;

    private static Logger logger = Logger.getLogger(TaskTypesController.class.getName());

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        MVCModel mvcModel;
        List<Object> list = new ArrayList<>();

        try {
            int taskId = Integer.parseInt(req.getParameter("taskId"));
            Task task = null;

            logger.info(req.getParameter("taskId"));

            task = taskDAO.getById(taskId);
            list.add(task);

            List<TaskType> allTaskTypes = new ArrayList<TaskType>();
            allTaskTypes = taskTypeDAO.getAll();
            list.add(allTaskTypes);

            List<User> allResponsibles = new ArrayList<User>();
            allResponsibles = userDAO.getAll();
            list.add(allResponsibles);

            mvcModel = new MVCModel("/editTaskForm.jsp", list);
        }
        catch (Exception e) {
            mvcModel = new MVCModel("/editTaskForm.jsp", "Save error has occured, try later.");
        }
        return mvcModel;
    }
}
