package pt.action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class UserAction implements ServletContextAware, ServletRequestAware {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    ServletContext application;

    HttpSession session;

    HttpServletRequest request;

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
        this.session = request.getSession();
    }

    @Override
    public void setServletContext(ServletContext context) {
        this.application = context;
    }

    public String login() {
        //把用户信息存入Session域中

        // 1. 获取Session信息
        // 实装了ServletContextAware, ServletRequestAware接口所以自动获取了！

        // 2. 获取登录信息
        // 因为post方法+有setter所以自动获取了！

        // 3. 把用户信息存入Session域中
        if (session.getAttribute(username) == null) {
            session.setAttribute(username, this);

            // 4. 在线人数+1
            if (application.getAttribute("users") == null) {
                application.setAttribute("users", 1);
            } else {
                Integer users = (Integer) application.getAttribute("users");
                application.setAttribute("users", users + 1);
            }
        }

        return "success";
    }

    public String logout() {

        String username = request.getParameter("username");

        // 清除session中保存的用户信息
        if (session.getAttribute(username) != null) {
            session.removeAttribute(username);
            // session失效
            session.invalidate();

            // 在线人数 - 1
            if (application.getAttribute("users") != null) {
                Integer users = (Integer) application.getAttribute("users");
                application.setAttribute("users", users - 1);
            }
        }

        return "success";
    }
}
