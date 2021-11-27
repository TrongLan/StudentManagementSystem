package EnglishCenter.Website.Controllers;

import EnglishCenter.Website.Entities.Course;
import EnglishCenter.Website.Service.CourseService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {
    private CourseService cService;

    public CourseController(CourseService cService) {
        this.cService = cService;
    }

    @GetMapping("/all-courses")
    public String getAllCourses(Model model) {
        model.addAttribute("courses", cService.getAllCourse());
        return "course_list";
    }
    @GetMapping("/all-courses/search-result")
    public String timKiemKhoaHoc(@RequestParam(name = "keyword", required = true) String key, Model mod){
        List<Course> ds = cService.timKiemKhoaHocVoiTuKhoa(key);
        mod.addAttribute("results", ds);
        mod.addAttribute("key", key);
        mod.addAttribute("type", "C");
        mod.addAttribute("number_of_results", ds.size());
        return "search_result";
    }
    @GetMapping("/all-courses/{id}")
    public String xoaKhoaHocTheoID(@PathVariable String id){
        cService.xoaKhoaHoc(id);
        return "redirect:/all-courses";
    }
    @GetMapping("/new-course")
    public String taoGiangVien(Model mod){
        Course c = new Course();
        mod.addAttribute("newcourse", c);
        return "new_course";
    }
    @PostMapping("/all-courses")
    public String themGiangvienMoi(@ModelAttribute("course") Course c){
        cService.taoKhoaHocMoi(c);
        return "redirect:/all-courses";
    }
}