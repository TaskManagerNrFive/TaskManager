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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 4/17/16.
 */
@Controller
public class editTaskTypeController {

    @Autowired
    @Qualifier("ORM_TaskTypeDAO")
    private TaskTypeDAO taskTypeDAO;

    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "/editTaskType", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {

        User sessionUser = accountManager.getUserFromSession(req.getSession());
        if (sessionUser == null) {
            return new ModelAndView("/redirect", "data", "");
        }

        ModelAndView mvcModel;
        List<Object> list = new ArrayList<>();
        try {
            int taskTypeId = Integer.parseInt(req.getParameter("taskTypeId"));
            TaskType taskType = null;

            taskType = taskTypeDAO.getById(taskTypeId);
            list.add(taskType);
            mvcModel = new ModelAndView("editTaskTypeForm", "data", list);
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("editTaskTypeForm", "data", "Save error has occured, try later.");
        }
        return mvcModel;
    }

}
