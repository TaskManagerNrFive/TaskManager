package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskTypeDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.TaskType;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 5/1/16.
 */
@Component
public class NewTaskController implements MVCController {

    @Autowired
    @Qualifier("ORM_TaskTypeDAO")
    private TaskTypeDAO taskTypeDAO;

    @Autowired
    @Qualifier("JDBC_UserDAO")
    private UserDAO userDAO;

    private List<Object> list = new ArrayList<>();


    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        MVCModel mvcModel;
        try {
            List<TaskType> allTaskTypes = new ArrayList<TaskType>();
            allTaskTypes = taskTypeDAO.getAll();
            list.add(allTaskTypes);

            List<User> allResponsibles = new ArrayList<User>();
            allResponsibles = userDAO.getAll();
            list.add(allResponsibles);

            mvcModel = new MVCModel("/newTaskForm.jsp", list);
        }
        catch (Exception e) {
            mvcModel = new MVCModel("/editTaskForm.jsp", "Save error has occured, try later.");
        }
        return mvcModel;
    }
}
