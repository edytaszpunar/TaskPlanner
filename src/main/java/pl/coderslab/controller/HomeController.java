package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String home() {
        return "home/index";
    }
    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "home/register";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, @RequestParam String confirm) {
        if (result.hasErrors() || !user.getPassword().equals(confirm)) {
            return "home/register";
        }
        if (!userService.userLoginInUse(user.getLogin())) {
            userService.registerUser(user);
            return "redirect: /login";
        }
        return "redirect: /login";
    }
}
