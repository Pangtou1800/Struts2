package pt.action;

import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

public class LoginAction {

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

    public String execute() {
        //把用户信息存入Session域中

        // 1. 获取Session信息
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        Map<String, Object> application = actionContext.getApplication();

        // 2. 获取登录信息
        // 因为有setter所以自动获取了！

        // 3. 把用户信息存入Session域中
        if (session.get(username) == null) {
            session.put(username, this);

            // 4. 在线人数+1
            if (application.get("users") == null) {
                application.put("users", 1);
            } else {
                application.put("users", ((Integer) application.get("users")) + 1);
            }
        }

        return "success";
    }
}
