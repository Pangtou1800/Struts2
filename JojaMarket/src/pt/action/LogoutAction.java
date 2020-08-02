package pt.action;

import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

public class LogoutAction {

    public String execute() {

        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        Map<String, Object> application = actionContext.getApplication();
        String username = actionContext.getParameters().get("username").getValue();

        if (session.get(username) != null) {
            session.remove(username);

            if (application.get("users") != null && ((Integer) application.get("users")) > 0) {
                application.put("users", ((Integer) application.get("users")) - 1);
            }
        }

        return "success";
    }
}
