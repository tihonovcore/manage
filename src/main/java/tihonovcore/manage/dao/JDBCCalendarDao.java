package tihonovcore.manage.dao;

import tihonovcore.manage.model.Day;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCCalendarDao extends CalendarDao {
    private final String DATABASE_URL = "jdbc:sqlite:manage.sqlite";

    private final String DEADLINE = "deadline";
    private final String DATE = "yyyy_mm_dd_date";
    private final String PLAN = "plan";

    @Override
    public List<Day> getRecordsFrom(Date from) {
        List<Day> queryResult = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement("select deadline, yyyy_mm_dd_date, plan from Calendar where yyyy_mm_dd_date >= ?");
            statement.setString(1, from.toString());

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String deadline = result.getString(DEADLINE);
                Date date = Date.valueOf(result.getString(DATE));
                String plan = result.getString(PLAN);

                Day day = new Day(deadline, date, plan);
                queryResult.add(day);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return queryResult;
    }

    @Override
    public void updateDeadline(String newDeadline, Date date) {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement("update Calendar set deadline = ? where yyyy_mm_dd_date = ?");
            statement.setString(1, newDeadline);
            statement.setString(2, date.toString());

            int edited = statement.executeUpdate();
            if (edited == 0) {
                PreparedStatement addStatement = connection.prepareStatement("insert into Calendar(deadline, yyyy_mm_dd_date, plan) values (?, ?, ?)");
                addStatement.setString(1, newDeadline);
                addStatement.setString(2, date.toString());
                addStatement.setString(3, Day.EMPTY_VALUE);

                addStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePlan(String newPlan, Date date) {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement("update Calendar set plan = ? where yyyy_mm_dd_date = ?");
            statement.setString(1, newPlan);
            statement.setString(2, date.toString());

            statement.executeUpdate();
            int edited = statement.executeUpdate();
            if (edited == 0) {
                PreparedStatement addStatement = connection.prepareStatement("insert into Calendar(deadline, yyyy_mm_dd_date, plan) values (?, ?, ?)");
                addStatement.setString(1, Day.EMPTY_VALUE);
                addStatement.setString(2, date.toString());
                addStatement.setString(3, newPlan);

                addStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
