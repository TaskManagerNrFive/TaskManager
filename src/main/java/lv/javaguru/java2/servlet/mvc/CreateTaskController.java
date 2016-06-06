package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.AccountManager;
import lv.javaguru.java2.services.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by andrew on 5/1/16.
 */
@Controller
public class CreateTaskController {

    @Autowired
    @Qualifier("JDBC_TaskDAO")
    private TaskDAO taskDAO;

    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "/createTask", method = {RequestMethod.POST})
    public ModelAndView processRequest(HttpServletRequest req) {
        /* need to check form params here too */

        User sessionUser = accountManager.getUserFromSession(req.getSession());
        if (sessionUser == null) {
            return new ModelAndView("/redirect", "data", "");
        }

        ModelAndView mvcModel;
        try {
            Task task = new Task();

            String newTitle = req.getParameter("title");
            String newDescription = req.getParameter("description");
            String newTaskType = req.getParameter("taskType");

            Date newDoneDate = Utilities.getDateFromString(req.getParameter("doneDate"));
            Date newdueDate = Utilities.getDateFromString(req.getParameter("dueDate"));
            int newResponsibleId = Integer.parseInt(req.getParameter("responsibleId"));

            User user = sessionUser;
            int userId = new BigDecimal(user.getUserId()).intValueExact();

            task.setTitle(newTitle);
            task.setTaskType(newTaskType);
            task.setDescription(newDescription);
            task.setDueDate(newdueDate);
            task.setDoneDate(newDoneDate);
            task.setResponsibleId(newResponsibleId);
            task.setUserId(userId);

            taskDAO.create(task);
            mvcModel = new ModelAndView("/helloWorld", "data", "Task created");
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/helloWorld", "data", "Error made "
                                        + e.getMessage());
        }
        return mvcModel;
    }

}
