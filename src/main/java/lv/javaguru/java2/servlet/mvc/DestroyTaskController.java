package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.TaskTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by andrew on 5/1/16.
 */
@Component
public class DestroyTaskController implements MVCController {

    @Autowired
    @Qualifier("JDBC_TaskDAO")
    private TaskDAO taskDAO;

    public MVCModel processRequest(HttpServletRequest req) {
        MVCModel mvcModel;
        try {
            int taskId = Integer.parseInt(req.getParameter("taskId"));

            taskDAO.delete(taskId);
            /* temporary */ return new MVCModel("/helloWorld.jsp", "Task deleted!");
        }
        catch (Exception e) {
            mvcModel = new MVCModel("/newTaskTypeForm.jsp", "Save error has occured, try later.");
        }
        return mvcModel;
    }
}
