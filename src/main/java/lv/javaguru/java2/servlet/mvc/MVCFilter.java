package lv.javaguru.java2.servlet.mvc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class MVCFilter implements Filter {

    private Map<String, MVCController> urlToControllerMap;
    private ApplicationContext springContext;

    private static Logger logger = Logger.getLogger(MVCFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            springContext =
                    new AnnotationConfigApplicationContext(SpringAppConfig.class);
        } catch (BeansException e) {
            logger.log(Level.INFO, "Spring context failed to start", e);
        }

        urlToControllerMap = new HashMap<>();
        urlToControllerMap.put("/hello", getBean(HelloWorldController.class));
        urlToControllerMap.put("/taskTypes", getBean(TaskTypesController.class));
    }

    private MVCController getBean(Class clazz) {
        return (MVCController) springContext.getBean(clazz);
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        String contextURI = req.getServletPath();
        String method = req.getMethod();

        MVCController controller = urlToControllerMap.get(contextURI);
//        if (method.equalsIgnoreCase("GET")) {
//
//        }

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
