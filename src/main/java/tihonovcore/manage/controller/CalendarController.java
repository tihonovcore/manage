package tihonovcore.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import tihonovcore.manage.dao.CalendarDao;
import tihonovcore.manage.model.Day;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CalendarController {
    private final CalendarDao dao;

    public CalendarController(CalendarDao dao) {
        this.dao = dao;
    }

    @GetMapping("/calendar")
    public String index(ModelMap model, HttpServletRequest request) {
        String date = request.getParameter("date");
        if (date == null) {
            //TODO: use current date
            date = "2020-01-29";
        }

        model.addAttribute("date", date);

        List<Day> days = dao.getDaysFrom(date);
        model.addAttribute("days", days);

        return "calendar";
    }
}
