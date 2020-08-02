package pt.action;

import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.HttpParametersAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class AwareActionDemo implements ApplicationAware, SessionAware, RequestAware, HttpParametersAware {

    public String execute() {
        // 1. 向application中加入一个属性
        application.put("applicationKey2", "I'm from application!");
        // 2. 从application中读取一个属性，并打印
        System.out.println(application.get("date"));

        // 3. 其他域的演示
        session.put("sessionKey2", "I'm from session!");
        request.put("requestKey2", "I'm from request!");

        System.out.println(parameters.get("name").getValue());

        return "success";
    }

    private Map<String, Object> application;

    private Map<String, Object> session;

    private Map<String, Object> request;

    private HttpParameters parameters;

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    @Override
    public void setParameters(HttpParameters parameters) {
        this.parameters = parameters;
    }


}
