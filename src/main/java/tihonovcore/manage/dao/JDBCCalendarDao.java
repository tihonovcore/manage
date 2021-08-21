package tihonovcore.manage.dao;

import tihonovcore.manage.model.Day;

import java.sql.Date;
import java.util.List;

public class JDBCCalendarDao implements CalendarDao {
    @Override
    public List<Day> getDaysFrom(Date from) {
        throw new IllegalStateException("Not yet implemented");
    }

    @Override
    public List<Day> getNDaysFrom(int n, Date from) {
        throw new IllegalStateException("Not yet implemented");
    }
}
