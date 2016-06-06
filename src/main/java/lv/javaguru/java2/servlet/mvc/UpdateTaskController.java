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
import java.sql.Date;

/**
 * Created by andrew on 5/4/16.
 */
@Controller
public class UpdateTaskController {

    @Autowired
    @Qualifier("JDBC_TaskDAO")
    private TaskDAO taskDAO;

    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "/updateTask", method = {RequestMethod.POST})
    public ModelAndView processRequest(HttpServletRequest req) {

        User sessionUser = accountManager.getUserFromSession(req.getSession());
        if (sessionUser == null) {
            return new ModelAndView("/redirect", "data", "");
        }

        try {

            int taskId = Integer.parseInt(req.getParameter("taskId"));
            String newTitle = req.getParameter("title");
            String newDescription = req.getParameter("description");
            Date newDoneDate = Utilities.getDateFromString(req.getParameter("doneDate"));
            Date newdueDate = Utilities.getDateFromString(req.getParameter("dueDate"));
            String newTaskType = req.getParameter("taskType");
            int newResponsibleId = Integer.parseInt(req.getParameter("responsibleId"));

            Task task = null;

            task = taskDAO.getById(taskId);

            task.setTitle(newTitle);
            task.setDescription(newDescription);
            task.setDueDate(newdueDate);
            task.setDoneDate(newDoneDate);
            task.setTaskType(newTaskType);
            task.setResponsibleId(newResponsibleId);

            taskDAO.update(task);

            return new ModelAndView("/helloWorld", "data", "Task updated!");
        }
        catch (Exception e) {
           return new ModelAndView("/helloWorld", "data", "Error");
        }
    }
}
