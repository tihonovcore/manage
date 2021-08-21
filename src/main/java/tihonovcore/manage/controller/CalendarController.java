package tihonovcore.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import tihonovcore.manage.dao.CalendarDao;
import tihonovcore.manage.model.Day;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@Controller
public class CalendarController {
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

        List<Day> days = dao.getDaysFrom(date);
        model.addAttribute("days", days);

        return "calendar";
    }
}
