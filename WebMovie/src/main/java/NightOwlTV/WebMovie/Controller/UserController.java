package NightOwlTV.WebMovie.Controller;

import NightOwlTV.WebMovie.Entity.User;
import NightOwlTV.WebMovie.Service.UserService;
import NightOwlTV.WebMovie.entityPK.UserPK;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserService uService;

    public UserController(UserService uService) {
        this.uService = uService;
    }
    
    @GetMapping("/all-users")
    public String getAllUsers(Model mod){
        mod.addAttribute("users", uService.showAllUsers());
        return "users";
    }
    
    @GetMapping("/user-info/{acc_id}/{nickname}")
    public String showUserInfo(@PathVariable String acc_id,@PathVariable String nickname,Model mod){
        UserPK key = new UserPK(acc_id,nickname);
        mod.addAttribute("user", uService.getUserByKey(key));
        mod.addAttribute("default_user", new User("ACC001","BuN",LocalDate.now(),"123456"));
        return "user_info";
    }

    @GetMapping("/user-signin")
    public String createNewUser(Model mod){
        User u = new User();
        mod.addAttribute("user",u);
        return "sign_in";
    }
    
    @PostMapping("/all-users")
    public String saveNewUser(@ModelAttribute("user") User u){
        u.setLogin_date(LocalDate.now());
        uService.saveUser(u);
        return "redirect:/all-users";
    }
    
}
