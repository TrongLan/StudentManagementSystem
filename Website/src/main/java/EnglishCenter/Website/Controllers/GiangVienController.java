
package EnglishCenter.Website.Controllers;

import EnglishCenter.Website.Entities.GiangVien;
import EnglishCenter.Website.Service.GiangVienService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class GiangVienController {
    private GiangVienService gvService;

    public GiangVienController(GiangVienService gvService) {
        this.gvService = gvService;
    }
    @GetMapping("/all-teachers")
    public String xemDanhSachTatCaHocVien(Model mod){
        mod.addAttribute("teachers", gvService.danhSachTatCaGiangVien());
        return "teacher_list";
    }
    @GetMapping("/new-teacher")
    public String taoGiangVien(Model mod){
        GiangVien gv = new GiangVien();
        mod.addAttribute("newteacher", gv);
        return "new_teacher";
    }
    @PostMapping("/all-teachers")
    public String themGiangvienMoi(@ModelAttribute("teacher") GiangVien gv){
        gvService.TaoGiangVienMoi(gv);
        return "redirect:/all-teachers";
    }
    @GetMapping("/all-teachers/{id}")
    public String xoaGiangVienTheoID(@PathVariable String id){
        gvService.xoaGiangVien(id);
        return "redirect:/all-teachers";
    }
    @GetMapping("/all-teachers/search-result")
    public String timKiemGiangVien(@RequestParam(name = "keyword",required = true) String key, Model mod){
        List<GiangVien> ds = gvService.timKiemGiangVienVoiTuKhoa(key);
        mod.addAttribute("results", ds);
        mod.addAttribute("number_of_results", ds.size());
        mod.addAttribute("key", key);
        mod.addAttribute("type", "GV");
        return "search_result";
    }
}
