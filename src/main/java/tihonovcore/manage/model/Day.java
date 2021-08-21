package tihonovcore.manage.model;

import java.sql.Date;

public class Day implements Comparable<Day> {
    public static final String EMPTY_VALUE = "";

    private String deadline;
    private final Date date;
    private String plan;

    public Day(String deadline, Date date, String plan) {
        this.deadline = deadline;
        this.date = date;
        this.plan = plan;
    }

    public Day(Date date) {
        this("", date, "");
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Date getDate() {
        return date;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    @Override
    public int compareTo(Day o) {
        return this.date.compareTo(o.date);
    }
}
