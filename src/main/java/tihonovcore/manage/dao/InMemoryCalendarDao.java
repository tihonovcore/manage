package tihonovcore.manage.dao;

import tihonovcore.manage.model.Day;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class InMemoryCalendarDao implements CalendarDao {
    private final List<Day> days = new ArrayList<>();

    {
        days.add(new Day("x", Date.valueOf("2020-01-31"), "x, y, z"));
        days.add(new Day("y", Date.valueOf("2020-02-01"), "y, z"));
        days.add(new Day("z", Date.valueOf("2020-02-02"), "z"));
    }

    @Override
    public List<Day> getDaysFrom(Date from) {
        return days.stream().filter(day -> day.getDate().compareTo(from) >= 0).collect(Collectors.toList());
    }

    @Override
    public List<Day> getNDaysFrom(int n, Date from) {
        List<Day> result = getDaysFrom(from);

        for (int i = 0; i < n; i++) {
            long nextDay = from.getTime() + TimeUnit.DAYS.toMillis(i);
            if (result.stream().noneMatch(day -> day.getDate().getTime() == nextDay)) {
                result.add(new Day(new Date(nextDay)));
            }
        }

        return result.stream().sorted().collect(Collectors.toList()).subList(0, n);
    }
}
