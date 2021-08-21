package tihonovcore.manage.dao;

import tihonovcore.manage.model.Day;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryCalendarDao extends CalendarDao {
    private final List<Day> days = new ArrayList<>();

    {
        days.add(new Day("x", Date.valueOf("2020-01-31"), "x, y, z"));
        days.add(new Day("y", Date.valueOf("2020-02-01"), "y, z"));
        days.add(new Day("z", Date.valueOf("2020-02-02"), "z"));
    }

    @Override
    public List<Day> getRecordsFrom(Date from) {
        return days.stream().filter(day -> day.getDate().compareTo(from) >= 0).collect(Collectors.toList());
    }

    @Override
    public void updateDeadline(String newDeadline, Date date) {
        Optional<Day> optionalDay = days.stream().filter(day -> day.getDate().equals(date)).findAny();
        if (optionalDay.isPresent()) {
            optionalDay.get().setDeadline(newDeadline);
        } else {
            days.add(new Day(newDeadline, date, Day.EMPTY_VALUE));
        }
    }

    @Override
    public void updatePlan(String newPlan, Date date) {
        Optional<Day> optionalDay = days.stream().filter(day -> day.getDate().equals(date)).findAny();
        if (optionalDay.isPresent()) {
            optionalDay.get().setPlan(newPlan);
        } else {
            days.add(new Day(Day.EMPTY_VALUE, date, newPlan));
        }
    }
}
