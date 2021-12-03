package EnglishCenter.Website.Controllers;

import EnglishCenter.Website.Entities.HocVien;
import EnglishCenter.Website.Service.HocVienService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HocVienController {
    private HocVienService hvService;

    public HocVienController(HocVienService hvService) {
        this.hvService = hvService;
    }
    
    @GetMapping("/all-students")
    public String xemDanhSachTatCaHocVien(Model mod){
        mod.addAttribute("students", hvService.danhSachTatCaHocVien());
        return "student_list";
    }
    
    @PostMapping("/all-students")
    public String themHocVienMoi(@ModelAttribute("student") HocVien hv){
        hvService.TaoHocVienMoi(hv);
        return "redirect:/all-students";
    }
    
    @GetMapping("/new-student")
    public String taoHocVien(Model mod){
        HocVien hv = new HocVien();
        mod.addAttribute("choosenstudent", hv);
        mod.addAttribute("situation", "create_new");
        return "create_new_or_edit_student";
    }
    @GetMapping("/all-students/{id}")
    public String xoaHocVienTheoID(@PathVariable String id){
        hvService.xoaHocVien(id);
        return "redirect:/all-students";
    }
    @GetMapping("/all-students/search-result")
    public String timKiemHocVien(@RequestParam(name = "keyword", required = true) String key, Model mod){
        List<HocVien> ds = hvService.timKiemHocVienVoiTuKhoa(key);
        mod.addAttribute("results", ds);
        mod.addAttribute("number_of_results", ds.size());
        mod.addAttribute("key", key);
        mod.addAttribute("type", "HV");
        return "search_result";
    }
    @GetMapping("/all-students/update/{id}")
    public String suaThongTinHocVien(@PathVariable String id, Model mod){
        HocVien hv = hvService.chonHocVien(id);
        mod.addAttribute("situation", "update");
//        gvService.nghiDay(id);
//        gvService.xoaGiangVien(id);
        mod.addAttribute("choosenstudent", hv);
        return "create_new_or_edit_student";
    }
    @PostMapping("/all-students/update/{id}")
    public String capNhatGiangVien(@ModelAttribute("student") HocVien hv, @PathVariable String id){
        hvService.TaoHocVienMoi(hv);
        return "redirect:/all-teachers";
    }
}
