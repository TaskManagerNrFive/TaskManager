package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.jdbc.TaskTypeDAOImpl;
import lv.javaguru.java2.domain.TaskType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by andrew on 4/17/16.
 */
@Component
public class showTaskTypeController implements MVCController  {

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        MVCModel mvcModel;
        try {
            int taskTypeId = Integer.parseInt(req.getParameter("taskTypeId"));
            TaskType taskType = null;

            TaskTypeDAOImpl taskTypeDAO = new TaskTypeDAOImpl();
            taskType = taskTypeDAO.getById(taskTypeId);
            mvcModel = new MVCModel("/showTaskType.jsp", taskType);
        }
        catch (Exception e) {
            mvcModel = new MVCModel("/newTaskTypeForm.jsp", "Save error has occured, try later.");
        }
        return mvcModel;
    }
}
