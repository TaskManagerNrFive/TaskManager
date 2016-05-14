package lv.javaguru.java2.servlet.mvc;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by andrew on 4/9/16.
 */
@Controller
public class NewTaskTypeController {

    @RequestMapping(value = "/newTaskType", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {
        return new ModelAndView("/newTaskTypeForm", "data", null);
    }

}
