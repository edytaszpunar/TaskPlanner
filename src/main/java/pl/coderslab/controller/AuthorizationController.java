package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class AuthorizationController {

    @Autowired
    UserService userService;

    @GetMapping
    public String loginUserData() {
        return "home/login";
    }

    @PostMapping
    public String login(@RequestParam String login, @RequestParam String password, HttpSession session) {
        if (userService.userAuthorization(login, password)) {
            session.setAttribute("login", login);
            return "redirect: user/manage";
        }
        return "home/login";
    }
}