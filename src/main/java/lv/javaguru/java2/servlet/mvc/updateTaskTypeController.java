package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskTypeDAO;
import lv.javaguru.java2.domain.TaskType;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by andrew on 4/17/16.
 */
@Controller
public class updateTaskTypeController {

    @Autowired
    @Qualifier("ORM_TaskTypeDAO")
    private TaskTypeDAO taskTypeDAO;

    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "/updateTaskType", method = {RequestMethod.POST})
    public ModelAndView processRequest(HttpServletRequest req) {
        /* need to check form params here too */

        User sessionUser = accountManager.getUserFromSession(req.getSession());
        if (sessionUser == null) {
            return new ModelAndView("/redirect", "data", "");
        }

        ModelAndView mvcModel;
        try {

            int taskTypeId = Integer.parseInt(req.getParameter("taskTypeId"));
            String newName = req.getParameter("name");
            String newDescription = req.getParameter("description");

            TaskType taskType = null;

            taskType = taskTypeDAO.getById(taskTypeId);

            taskType.setName(newName);
            taskType.setDescription(newDescription);
            taskTypeDAO.update(taskType);
            /* temporary */ return new ModelAndView("/helloWorld", "data", "Task type was updated!");
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/newTaskTypeForm", "data", "Save error has occured, try later.");
        }
        return mvcModel;
    }
}
