package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.*;
import lv.javaguru.java2.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 4/30/16.
 */
@Component
public class TasksController implements MVCController {

    @Autowired
    @Qualifier("JDBC_TaskDAO")
    private TaskDAO taskDAO;

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        List<Task> allTasks = new ArrayList<Task>();

        try {

            allTasks = taskDAO.getAll();

        } catch (Exception e) {
            System.out.println(e);
        }
        return new MVCModel("/tasks.jsp", allTasks);
    }
}
