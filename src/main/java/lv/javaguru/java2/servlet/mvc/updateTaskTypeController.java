package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.jdbc.TaskTypeDAOImpl;
import lv.javaguru.java2.domain.TaskType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by andrew on 4/17/16.
 */
@Component
public class updateTaskTypeController implements MVCController {

    public MVCModel processRequest(HttpServletRequest req) {
        /* need to check form params here too */
        MVCModel mvcModel;
        try {

            long taskTypeId = Long.parseLong(req.getParameter("taskTypeId"));
            String newName = req.getParameter("name");

            TaskType taskType = null;

            TaskTypeDAOImpl taskTypeDAO = new TaskTypeDAOImpl();
            taskType = taskTypeDAO.getById(taskTypeId);

            taskType.setName(newName);
            taskTypeDAO.update(taskType);
            /* temporary */ return new MVCModel("/helloWorld.jsp", "Task type was updated!");
        }
        catch (Exception e) {
            mvcModel = new MVCModel("/newTaskTypeForm.jsp", "Save error has occured, try later.");
        }
        return mvcModel;
    }
}
