package tihonovcore.manage.dao;

import tihonovcore.manage.model.Day;

import java.sql.Date;
import java.util.List;

public interface CalendarDao {
    List<Day> getDaysFrom(Date from);
}
