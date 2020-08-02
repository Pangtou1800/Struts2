package pt.action;

import com.opensymphony.xwork2.ActionContext;

public class ActionResultDemo {

    public String execute() {

        int number = Integer.parseInt(ActionContext.getContext().getParameters().get("number").getValue());

        if (number % 4 == 0) {
            return "dispatcherWay";
        } else if (number % 4 == 1) {
            return "chainWay";
        } else if (number % 4 == 2) {
            return "redirectWay";
        } else {
            return "redirectActionWay";
        }
    }
}
