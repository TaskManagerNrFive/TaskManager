package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskCommentDAO;
import lv.javaguru.java2.domain.TaskComment;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by NightStranger on 5/25/2016.
 */

@Controller
public class CreateTaskCommentController {

    @Autowired
    @Qualifier("ORM_TaskCommentDAO")
    private TaskCommentDAO taskCommentDAO;

    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "/createTaskComment") // method = {RequestMethod.POST})
    @Transactional
    public ModelAndView processRequest(HttpServletRequest req) {

        User sessionUser = accountManager.getUserFromSession(req.getSession());
        if (sessionUser == null) {
            return new ModelAndView("/redirect", "data", "");
        }

        ModelAndView mvcModel;
        try {

            TaskComment taskComment = new TaskComment();

            String text = req.getParameter("text");
            int taskID = Integer.parseInt(req.getParameter("taskId"));

            long userID = sessionUser.getUserId();

            taskComment.setText(text);
            taskComment.setTaskID(taskID);
            taskComment.setUserID(userID);

            taskCommentDAO.create(taskComment);
            mvcModel = new ModelAndView("/redirect", "data", "showTask?taskId=" + taskID);

        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/helloWorld", "data", "Error!");
        }
        return mvcModel;
    }

}
