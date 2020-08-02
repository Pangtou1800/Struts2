package pt.action;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletActionAwareDemo implements ServletContextAware, ServletRequestAware, ServletResponseAware {

    private ServletContext application;

    private ServletRequest request;

    private ServletResponse response;

    public String execute() {

        application.setAttribute("applicationKey4", "I'm from application, which means servletContext!");
        ((HttpServletRequest) request).getSession().setAttribute("sessionKey4", "I'm from session!");
        request.setAttribute("requestKey4", "I'm from request!");

        return "success";
    }

    @Override
    public void setServletContext(ServletContext context) {
        application = context;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
