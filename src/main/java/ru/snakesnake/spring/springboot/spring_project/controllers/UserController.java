package ru.snakesnake.spring.springboot.spring_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.snakesnake.spring.springboot.spring_project.service.UserServiceImpl;

import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public String clickMe(Model model, Principal principal) {
        model.addAttribute("oneUser", userService.getUserByEmail(principal.getName()));
        return "show-me";
    }
}
