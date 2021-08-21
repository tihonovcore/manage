package tihonovcore.manage.model;

import java.sql.Date;

public class Day {
    private String deadline;
    private Date date;
    private String plan;

    public Day(String deadline, Date date, String plan) {
        this.deadline = deadline;
        this.date = date;
        this.plan = plan;
    }

    public String getDeadline() {
        return deadline;
    }

    public Date getDate() {
        return date;
    }

    public String getPlan() {
        return plan;
    }
}
