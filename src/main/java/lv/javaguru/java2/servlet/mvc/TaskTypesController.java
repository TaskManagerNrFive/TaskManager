package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskTypeDAO;
import lv.javaguru.java2.domain.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by andrew on 4/2/16.
 */
@Component
public class TaskTypesController implements MVCController {

    @Autowired
    private TaskTypeDAO taskTypeDAO;

//    private static Logger logger = Logger.getLogger(TaskTypesController.class.getName());

        @Override
        public MVCModel processRequest(HttpServletRequest req) {
            List<TaskType> allTaskTypes = new ArrayList<TaskType>();

            try {
                allTaskTypes = taskTypeDAO.getAll();

            } catch (Exception e) {
                System.out.println(e);
            }
//            logger.info("tetsdfsdfs");
            return new MVCModel("/taskTypes.jsp", allTaskTypes);
        }
}
