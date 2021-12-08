
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
    @GetMapping("/all-teachers/new-teacher")
    public String taoGiangVien(Model mod){
        GiangVien gv = new GiangVien();
        mod.addAttribute("choosenteacher", gv);
        mod.addAttribute("situation", "create_new");
        return "create_new_or_edit_teacher";
    }
    @PostMapping("/all-teachers/new-teacher")
    public String themGiangvienMoi(@ModelAttribute("teacher") GiangVien gv){
        if(!gvService.daTonTaiGiangVien(gv.getId())){
            gvService.TaoGiangVienMoi(gv);
            return "redirect:/all-teachers";
        }
        else return "message";  
    }
    @GetMapping("/all-teachers/delete/{id}")
    public String xoaGiangVienTheoID(@PathVariable String id){
        gvService.nghiDay(id);
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
    
    @GetMapping("/all-teachers/update/{id}")
    public String suaThongTinGiangVien(@PathVariable String id, Model mod){
        GiangVien gv = gvService.chonGiangVien(id);
        mod.addAttribute("situation", "update");
        mod.addAttribute("choosenteacher", gv);
        return "create_new_or_edit_teacher";
    }
    @PostMapping("/all-teachers/update/{id}")
    public String capNhatGiangVien(@ModelAttribute("teacher") GiangVien gv, @PathVariable String id){
        gvService.TaoGiangVienMoi(gv);
        return "redirect:/all-teachers";
    }
    
    @GetMapping("/teacher/{id}")
    public String manHinhGiangVien(@PathVariable String id, Model mod){
        GiangVien gv = gvService.chonGiangVien(id);
        mod.addAttribute("teacher", gv);
        return "teacher_view";
    }
    
    @GetMapping("/profile/teacher/{id}")
    public String giangVienChinhSuaProfile(@PathVariable String id, Model mod){
        GiangVien gv = gvService.chonGiangVien(id);
        mod.addAttribute("teacher", gv);
        boolean is_male = true;
        if(gv.getGioiTinh().equalsIgnoreCase("female")) is_male = false;
        mod.addAttribute("check", is_male);
        return "teacher_profile";
    }
    @PostMapping("/profile/teacher/{id}")
    public String giangVienCapNhatProfile(@ModelAttribute("teacher") GiangVien gv, @PathVariable String id){
        gvService.TaoGiangVienMoi(gv);
        return "redirect:/teacher/{id}";
    }
}
