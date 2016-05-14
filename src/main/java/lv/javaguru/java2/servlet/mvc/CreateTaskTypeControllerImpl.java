package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskTypeDAO;
import lv.javaguru.java2.domain.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by andrew on 4/9/16.
 */
@Controller
public class CreateTaskTypeControllerImpl  {

    @Autowired
    @Qualifier("ORM_TaskTypeDAO")
    private TaskTypeDAO taskTypeDAO;

    @Transactional
    @RequestMapping(value = "/createTaskType", method = {RequestMethod.POST})
    public ModelAndView processRequest(HttpServletRequest req) {
        /* need to check form params here too */
        ModelAndView mvcModel;
        try {
            TaskType taskType = new TaskType();
            String newName = req.getParameter("name");
            String newDescription = req.getParameter("description");
            taskType.setName(newName);
            taskType.setDescription(newDescription);
            taskTypeDAO.create(taskType);
            /* temporary */ return new ModelAndView("/helloWorld", "data", "New Task type created!");
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/newTaskTypeForm", "data", "Save error has occured, try later.");
        }
        return mvcModel;
    }
}
