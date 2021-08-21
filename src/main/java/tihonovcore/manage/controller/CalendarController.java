package tihonovcore.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tihonovcore.manage.dao.CalendarDao;
import tihonovcore.manage.model.Day;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

@Controller
public class CalendarController {
    private static final int SHOW_N_DAYS = 10;
    private final CalendarDao dao;

    public CalendarController(CalendarDao dao) {
        this.dao = dao;
    }

    @GetMapping("/calendar")
    public String index(ModelMap model, HttpServletRequest request) {
        String dateParameter = request.getParameter("date");
        Date date;
        if (dateParameter != null) {
            date = Date.valueOf(dateParameter);
        } else {
            date = new Date(System.currentTimeMillis());
        }

        model.addAttribute("date", date);

        List<Day> days = dao.getNDaysFrom(SHOW_N_DAYS, date);
        model.addAttribute("days", days);

        return "calendar";
    }

    @PostMapping("edit_calendar")
    public String editCalendar(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Date date = Date.valueOf(map.get("date")[0]);
        String newValue = map.get("new_value")[0];
        boolean isDeadlineEdited = map.get("is_deadline_edited")[0].equals("true");

        String selectedDate = map.get("selected_date")[0];

        BiConsumer<String, Date> action = isDeadlineEdited ? dao::updateDeadline : dao::updatePlan;
        action.accept(newValue, date);

        return "redirect:calendar?date=" + selectedDate;
    }
}
