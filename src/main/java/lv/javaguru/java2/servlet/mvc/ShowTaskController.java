package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskCommentDAO;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.TaskComment;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andrew on 5/1/16.
 */
@Controller
public class ShowTaskController {

    @Autowired
    @Qualifier("JDBC_TaskDAO")
    private TaskDAO taskDAO;

    @Autowired
    @Qualifier("JDBC_UserDAO")
    private UserDAO userDAO;

    @Autowired
    @Qualifier("ORM_TaskCommentDAO")
    private TaskCommentDAO taskCommentDAO;

    @RequestMapping(value = "/showTask", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {
        ModelAndView mvcModel;
        List<Object> list = new ArrayList<>();
        try {
            int taskId = Integer.parseInt(req.getParameter("taskId"));
            Task task = null;

            task = taskDAO.getById(taskId);
            list.add(task);

            User user = null;
            user = userDAO.getById(task.getUserId());
            list.add(user);

            User responsbile = null;
            responsbile = userDAO.getById(task.getresponsibleId());
            list.add(responsbile);

            List<TaskComment> taskComments = taskCommentDAO.getByTaskID(taskId);

            Map<Long, User> taskCommentsUsers = new HashMap();
            for (TaskComment taskComment : taskComments) {
                User taskCommentsUser = userDAO.getById(taskComment.getUserID());
                taskCommentsUsers.put(taskCommentsUser.getUserId(), taskCommentsUser);
            }

            mvcModel = new ModelAndView("/showTask", "data",  list);
            mvcModel.addObject("taskComments", taskComments);
            mvcModel.addObject("taskCommentsUsers", taskCommentsUsers);

        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/newTaskTypeForm", "data", "Save error has occured, try later.");
            // mvcModel = new ModelAndView("/helloWorld", "data", e.getMessage());
        }
        return mvcModel;
    }
}
