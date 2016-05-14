package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskTypeDAO;
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
public class destroyTaskTypeController {

    @Autowired
    @Qualifier("ORM_TaskTypeDAO")
    private TaskTypeDAO taskTypeDAO;

    @RequestMapping(value = "/destroyTaskType", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {
        /* need to check form params here too */
        ModelAndView mvcModel;
        try {
            int taskTypeId = Integer.parseInt(req.getParameter("taskTypeId"));

            taskTypeDAO.delete(taskTypeId);
            /* temporary */ return new ModelAndView("/helloWorld", "data", "Task type deleted");
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/newTaskTypeForm", "data", "Error");
        }
        return mvcModel;
    }
}
