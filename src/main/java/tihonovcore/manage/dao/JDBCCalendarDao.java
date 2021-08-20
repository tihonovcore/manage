package tihonovcore.manage.dao;

import tihonovcore.manage.model.Day;

import java.util.List;

public class JDBCCalendarDao implements CalendarDao {
    @Override
    public List<Day> getDaysFrom(String from) {
        throw new IllegalStateException("Not yet implemented");
    }
}
