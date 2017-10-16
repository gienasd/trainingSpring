package pl.pawelprzystarz.training.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @PostMapping("/")
    public String index(@RequestParam("login") String login,
                        @RequestParam("password") String password,
                        @RequestParam("nickname") String nickname,
                        Model model){
        if(login.equals("Paweł") && password.equals("admin") && !nickname.isEmpty()){
            model.addAttribute("nickname", nickname);
            return "redirect:/dashboard";
        }
        model.addAttribute("error", "Podałeś nieprawidłowe dane!");
        return "loginPage";
    }

    @GetMapping("/")
    public String index(){
        return "loginPage";
    }
}