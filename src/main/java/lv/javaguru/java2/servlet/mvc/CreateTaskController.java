package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by andrew on 5/1/16.
 */
@Component
public class CreateTaskController implements MVCController {

    @Autowired
    @Qualifier("JDBC_TaskDAO")
    private TaskDAO taskDAO;

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        /* need to check form params here too */
        MVCModel mvcModel;
        try {
            Task task = new Task();

            String newTitle = req.getParameter("title");
            String newDescription = req.getParameter("description");
            String newTaskType = req.getParameter("taskType");
            Date newDoneDate = Date.valueOf(req.getParameter("doneDate"));
            Timestamp newdueDateTime = Timestamp.valueOf(req.getParameter("dueDateTime"));
            int newResponsibleId = Integer.parseInt(req.getParameter("responsibleId"));

            task.setTitle(newTitle);
            task.setTaskType(newTaskType);
            task.setDescription(newDescription);
            task.setDueDatetime(newdueDateTime);
            task.setDoneDate(newDoneDate);
            task.setResponsibleId(newResponsibleId);

            taskDAO.create(task);
            mvcModel = new MVCModel("/helloWorld.jsp", "Record created!");
        }
        catch (Exception e) {
            mvcModel = new MVCModel("/helloWorld.jsp", "Error!");
        }
        return mvcModel;
    }

}
