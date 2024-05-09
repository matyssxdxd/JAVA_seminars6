package lv.venta.seminars6.controller;

import lv.venta.seminars6.service.IGradeFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/grade/filter")
public class GradeFilterController {

    @Autowired
    private IGradeFilterService gradeFilterService;

    @GetMapping("/student")
    public String getGradeFilterStudentById(@RequestParam("id") long id, Model model) {
        try {
            model.addAttribute("data", gradeFilterService.selectGradesByStudentId(id));
            model.addAttribute("title", "Filtered by Student ID");
            return "grade-page";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/failed")
    public String getGradeFilterStudentById(Model model) {
        try {
            model.addAttribute("data", gradeFilterService.selectFailedGrades());
            model.addAttribute("title", "Filtered by Failed Grades");
            return "grade-page";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/average")
    public String getAverageGradeFilterCourseById(@RequestParam("id") long id, Model model) {
        try {
            model.addAttribute("data", gradeFilterService.calculateAVGGradeInCourseId(id));
            model.addAttribute("title", "Filtered by AVG Grade in Course ID");
            return "message";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error-page";
        }
    }
}
