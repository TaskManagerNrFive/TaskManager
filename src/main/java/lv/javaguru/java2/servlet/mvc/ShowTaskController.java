package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by andrew on 5/1/16.
 */
@Component
public class ShowTaskController implements MVCController {

    @Autowired
    @Qualifier("JDBC_TaskDAO")
    private TaskDAO taskDAO;

    @Autowired
    @Qualifier("JDBC_UserDAO")
    private UserDAO userDAO;

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        MVCModel mvcModel;
        List<Object> list = new ArrayList<>();
        try {
            int taskId = Integer.parseInt(req.getParameter("taskId"));
            Task task = null;

            task = taskDAO.getById(taskId);
            list.add(task);

            User user = null;
            user = userDAO.getById(task.getUserId());
            list.add(user);

            User responsbile = null;
            responsbile = userDAO.getById(task.getresponsibleId());
            list.add(responsbile);

            mvcModel = new MVCModel("/showTask.jsp", list);
        }
        catch (Exception e) {
            mvcModel = new MVCModel("/newTaskTypeForm.jsp", "Save error has occured, try later.");
        }
        return mvcModel;
    }
}
