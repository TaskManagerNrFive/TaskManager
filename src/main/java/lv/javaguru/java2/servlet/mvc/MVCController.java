package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by NightStranger on 3/29/2016.
 */
public interface MVCController {

    MVCModel processRequest(HttpServletRequest req);

}
