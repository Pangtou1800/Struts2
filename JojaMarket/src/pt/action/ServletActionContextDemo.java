package pt.action;

import org.apache.struts2.ServletActionContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ServletActionContextDemo {

    public String execute() {

        HttpServletRequest request = ServletActionContext.getRequest();

        HttpSession session = request.getSession();

        ServletContext servletContext = ServletActionContext.getServletContext();

        request.setAttribute("requestKey3", "I'm from request!");
        session.setAttribute("sessionKey3", "I'm from session!");
        servletContext.setAttribute("applicationKey3", "I'm from application, which means servletContext!");

        return "success";
    }
}
