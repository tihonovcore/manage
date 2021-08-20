package tihonovcore.manage.model;

public class Day {
    private String deadline;
    private String date;
    private String plan;

    public Day(String deadline, String date, String plan) {
        this.deadline = deadline;
        this.date = date;
        this.plan = plan;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getDate() {
        return date;
    }

    public String getPlan() {
        return plan;
    }
}
