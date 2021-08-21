package tihonovcore.manage.dao;

import tihonovcore.manage.model.Day;

import java.sql.Date;
import java.util.List;

public interface CalendarDao {
    List<Day> getDaysFrom(Date from);

    List<Day> getNDaysFrom(int n, Date from);

    void updateDeadline(String newDeadline, Date date);

    void updatePlan(String newPlan, Date date);
}
