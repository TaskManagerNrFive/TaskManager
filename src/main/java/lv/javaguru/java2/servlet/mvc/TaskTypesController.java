package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.*;
import lv.javaguru.java2.domain.TaskType;
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
import java.util.logging.Logger;

/**
 * Created by andrew on 4/2/16.
 */
@Controller
public class TaskTypesController {

    @Autowired
    @Qualifier("ORM_TaskTypeDAO")
    private TaskTypeDAO taskTypeDAO;

        @RequestMapping(value = "/taskTypes", method = {RequestMethod.GET})
        public ModelAndView processGetRequest(HttpServletRequest req) {
            List<TaskType> allTaskTypes = new ArrayList<TaskType>();

            try {
                allTaskTypes = taskTypeDAO.getAll();

            } catch (Exception e) {
                System.out.println(e);
            }
            return new ModelAndView("taskTypes", "data", allTaskTypes);
        }
}
