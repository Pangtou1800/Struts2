package pt.action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.Parameter;

import java.util.Arrays;
import java.util.Map;

public class ActionContextDemo {

    public String execute() {

        // 0. 获取ActionContext对象（Action的上下文对象）
        ActionContext actionContext = ActionContext.getContext();

        // 1. 获取application对应的Map对象，并向其中添加一个属性
        Map<String, Object> application = actionContext.getApplication();
        application.put("applicationKey", "This is an application value!");

        // 2. 获取session对应的Map对象，并向其中添加一个属性
        Map<String, Object> session = actionContext.getSession();
        session.put("sessionKey", "This is a session value!");

        // 3. 获取request对应的Map对象，并向其中添加一个属性
        // ActionContext并没有提供getRequest()方法，需要手动调用get("request")来获取
        Map<String, Object> request = (Map<String, Object>) actionContext.get("request");
        request.put("requestKey", "This is a request Value!");

        // 4. 获取请求参数对应的Map，并获取指定的参数值
        HttpParameters parameters = actionContext.getParameters();
        Parameter param = parameters.get("name");
        System.out.println(param.getValue());

        return "success";
    }
}
