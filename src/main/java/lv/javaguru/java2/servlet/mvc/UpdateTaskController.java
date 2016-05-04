package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by andrew on 5/4/16.
 */
@Component
public class UpdateTaskController implements MVCController {

    @Autowired
    @Qualifier("JDBC_TaskDAO")
    private TaskDAO taskDAO;

    public MVCModel processRequest(HttpServletRequest req) {
        MVCModel mvcModel;
        try {

            int taskId = Integer.parseInt(req.getParameter("taskId"));
            String newTitle = req.getParameter("title");
            String newDescription = req.getParameter("description");
            Date newDoneDate = Date.valueOf(req.getParameter("doneDate"));
            Timestamp newdueDateTime = Timestamp.valueOf(req.getParameter("dueDateTime"));

            Task task = null;

            task = taskDAO.getById(taskId);

            task.setTitle(newTitle);
            task.setDescription(newDescription);
            task.setDueDatetime(newdueDateTime);
            task.setDoneDate(newDoneDate);

            taskDAO.update(task);
            /* temporary */ return new MVCModel("/helloWorld.jsp", "Task was updated!");
        }
        catch (Exception e) {
            mvcModel = new MVCModel("/editTaskForm.jsp", "Save error has occured, try later.");
        }
        return mvcModel;
    }
}
