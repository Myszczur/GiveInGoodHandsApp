package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class RegisterController {
    private final UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "/login/register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/";
    }
}
