package pt.action;

public class UserAction2 {

    public String query() {
        System.out.println("query complete!");
        return "query-success";
    }

    public String update() {
        System.out.println("update complete!");
        return "update-success";
    }

    public String insert() {
        System.out.println("insert complete!");
        return "insert-success";
    }

    public String delete() {
        System.out.println("delete complete!");
        return "delete-success";
    }
}
