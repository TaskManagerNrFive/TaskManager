package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by andrew on 5/1/16.
 */
@Component
public class ShowTaskController implements MVCController {

    @Autowired
    @Qualifier("JDBC_TaskDAO")
    private TaskDAO taskDAO;

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        MVCModel mvcModel;
        try {
            int taskId = Integer.parseInt(req.getParameter("taskId"));
            Task task = null;

            task = taskDAO.getById(taskId);
            mvcModel = new MVCModel("/showTask.jsp", task);
        }
        catch (Exception e) {
            mvcModel = new MVCModel("/newTaskTypeForm.jsp", "Save error has occured, try later.");
        }
        return mvcModel;
    }
}
