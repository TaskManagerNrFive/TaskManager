package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by andrew on 3/29/16.
 */
public interface MVCController {

    ModelAndView processRequest(HttpServletRequest req) throws DBException;
}
