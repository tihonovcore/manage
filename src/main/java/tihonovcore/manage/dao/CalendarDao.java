package tihonovcore.manage.dao;

import tihonovcore.manage.model.Day;

import java.sql.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public abstract class CalendarDao {
    public abstract List<Day> getRecordsFrom(Date from);

    public List<Day> getNDaysFrom(int n, Date from) {
        List<Day> result = getRecordsFrom(from);

        for (int i = 0; i < n; i++) {
            Date nextDay = new Date(from.getTime() + TimeUnit.DAYS.toMillis(i));
            if (result.stream().noneMatch(day -> day.getDate().toString().equals(nextDay.toString()))) {
                result.add(new Day(nextDay));
            }
        }

        return result.stream().sorted().collect(Collectors.toList()).subList(0, n);
    }

    public abstract void updateDeadline(String newDeadline, Date date);

    public abstract void updatePlan(String newPlan, Date date);
}
