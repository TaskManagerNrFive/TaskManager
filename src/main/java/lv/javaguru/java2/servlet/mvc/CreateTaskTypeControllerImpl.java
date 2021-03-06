package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskTypeDAO;
import lv.javaguru.java2.domain.TaskType;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created by andrew on 4/9/16.
 */
@Controller
public class CreateTaskTypeControllerImpl  {

    @Autowired
    @Qualifier("ORM_TaskTypeDAO")
    private TaskTypeDAO taskTypeDAO;

    @Autowired
    AccountManager accountManager;

    @Transactional
    @RequestMapping(value = "/createTaskType", method = {RequestMethod.POST})
    public ModelAndView processRequest(HttpServletRequest req) {
        /* need to check form params here too */

        User sessionUser = accountManager.getUserFromSession(req.getSession());
        if (sessionUser == null) {
            return new ModelAndView("/redirect", "data", "");
        }

        ModelAndView mvcModel;
        try {
            TaskType taskType = new TaskType();
            String newName = req.getParameter("name");
            String newDescription = req.getParameter("description");
            User user = sessionUser;
            int userId = new BigDecimal(user.getUserId()).intValueExact();

            taskType.setName(newName);
            taskType.setDescription(newDescription);
            taskType.setUserId(userId);

            taskTypeDAO.create(taskType);
            /* temporary */ return new ModelAndView("/helloWorld", "data", "New Task type created!");
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/newTaskTypeForm", "data", "Save error has occured, try later.");
        }
        return mvcModel;
    }
}
