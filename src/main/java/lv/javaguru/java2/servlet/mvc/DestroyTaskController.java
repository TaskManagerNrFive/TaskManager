package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskDAO;
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
 * Created by andrew on 5/1/16.
 */
@Controller
public class DestroyTaskController {

    @Autowired
    @Qualifier("JDBC_TaskDAO")
    private TaskDAO taskDAO;

    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "/destroyTask", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {

        User sessionUser = accountManager.getUserFromSession(req.getSession());
        if (sessionUser == null) {
            return new ModelAndView("/redirect", "data", "");
        }

        ModelAndView mvcModel;
        try {
            int taskId = Integer.parseInt(req.getParameter("taskId"));

            taskDAO.delete(taskId);
            /* temporary */ return new ModelAndView("/helloWorld", "data", "Task deleted");
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/newTaskTypeForm", "data" , "Error");
        }
        return mvcModel;
    }
}
