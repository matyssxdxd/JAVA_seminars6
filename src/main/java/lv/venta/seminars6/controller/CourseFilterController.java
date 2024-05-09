package lv.venta.seminars6.controller;

import lv.venta.seminars6.service.ICourseFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/course/filter")
public class CourseFilterController {

    @Autowired
    private ICourseFilterService courseFilterService;

    @GetMapping("/student")
    public String getCourseFilterStudentById(@RequestParam("id") long id, Model model) {
        try {
            model.addAttribute("data", courseFilterService.selectCoursesByStudentId(id));
            model.addAttribute("title", "Filtered by Student ID");
            return "course-page";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/professor")
    public String getCourseFilterProfessorById(@RequestParam("id") long id, Model model) {
        try {
            model.addAttribute("data", courseFilterService.selectCoursesByProfessorId(id));
            model.addAttribute("title", "Filtered by Professor ID");
            return "course-page";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/cp")
    public String getCourseFilterByCp(@RequestParam("amount") int amount, Model model) {
        try {
            model.addAttribute("data", courseFilterService.selectCoursesByCP(amount));
            model.addAttribute("title", "Filtered by CP");
            return "course-page";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error-page";
        }
    }
}
