package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskTypeDAO;
import lv.javaguru.java2.database.jdbc.TaskTypeDAOImpl;
import lv.javaguru.java2.domain.TaskType;
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
public class showTaskTypeController  {

    @Autowired
    @Qualifier("ORM_TaskTypeDAO")
    private TaskTypeDAO taskTypeDAO;

    @RequestMapping(value = "/showTaskType", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {
        ModelAndView mvcModel;
        try {
            int taskTypeId = Integer.parseInt(req.getParameter("taskTypeId"));
            TaskType taskType = null;

            taskType = taskTypeDAO.getById(taskTypeId);
            mvcModel = new ModelAndView("/showTaskType", "data",  taskType);
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/newTaskTypeForm", "data", "Save error has occured, try later.");
        }
        return mvcModel;
    }
}
