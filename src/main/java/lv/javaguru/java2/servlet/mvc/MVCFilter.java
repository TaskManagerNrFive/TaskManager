package lv.javaguru.java2.servlet.mvc;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by NightStranger on 3/29/2016.
 */
public class MVCFilter implements Filter {

    private Map<String, MVCController> urlToControllerMap;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        urlToControllerMap = new HashMap<>();
        urlToControllerMap.put("/hello", new HelloWorldController());
        urlToControllerMap.put("/newTeam", new newTeamFormController());
        urlToControllerMap.put("/newTeamRegistration", new newTeamRegistrationController());
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String contextURI = req.getServletPath();
        String method = req.getMethod();

        MVCController controller = urlToControllerMap.get(contextURI);
        if (method.equalsIgnoreCase("GET")) {

        }

        MVCModel model = controller.processRequest(req);

        req.setAttribute("data", model.getData());

        ServletContext context = req.getServletContext();
        RequestDispatcher requestDispacher =
                context.getRequestDispatcher(model.getJspName());
        requestDispacher.forward(req, resp);

    }

    @Override
    public void destroy() {

    }

}
