package tihonovcore.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CalendarController {
    @GetMapping("/calendar")
    public String index(Model model, @ModelAttribute("date") String date) {
        model.addAttribute("date", date);
        return "calendar";
    }

    @GetMapping("/choose_date")
    public ModelAndView chooseDate(HttpServletRequest request, ModelMap model) {
        String value = request.getParameter("date");
        model.addAttribute("date", value);
        return new ModelAndView("redirect:/calendar", model);
    }
}
