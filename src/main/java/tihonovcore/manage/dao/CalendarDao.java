package tihonovcore.manage.dao;

import tihonovcore.manage.model.Day;

import java.util.List;

public interface CalendarDao {
    List<Day> getDaysFrom(String from);
}
