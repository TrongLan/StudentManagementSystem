package NightOwlTV.WebMovie.Controller;

import NightOwlTV.WebMovie.Service.WatchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WatchController {
    private WatchService wService;

    public WatchController(WatchService wService) {
        this.wService = wService;
    }
    
    @GetMapping("/all-watch")
    public String showAllStudies(Model mod){
        mod.addAttribute("allWatch", wService.getAllWatch());
        return "watch";
    }
}
