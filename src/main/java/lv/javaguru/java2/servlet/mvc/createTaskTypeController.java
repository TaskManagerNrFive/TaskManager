package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.jdbc.TaskTypeDAOImpl;
import lv.javaguru.java2.database.jdbc.TeamDAOImpl;
import lv.javaguru.java2.domain.TaskType;
import lv.javaguru.java2.domain.Team;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by andrew on 4/9/16.
 */
@Component
public class createTaskTypeController implements MVCController {

    public MVCModel processRequest(HttpServletRequest req) {
        /* need to check form params here too */
        MVCModel mvcModel;
        try {
            TaskType taskType = new TaskType();
            String newName = req.getParameter("name");
            taskType.setName(newName);
            TaskTypeDAOImpl taskTypeDAO = new TaskTypeDAOImpl();
            taskTypeDAO.create(taskType);
            /* temporary */ return new MVCModel("/helloWorld.jsp", "New Task type created!");
        }
        catch (Exception e) {
            mvcModel = new MVCModel("/newTaskTypeForm.jsp", "Save error has occured, try later.");
        }
        return mvcModel;
    }
}
