package ru.snakesnake.spring.springboot.spring_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.snakesnake.spring.springboot.spring_project.model.Role;
import ru.snakesnake.spring.springboot.spring_project.model.User;
import ru.snakesnake.spring.springboot.spring_project.service.RoleServiceImpl;
import ru.snakesnake.spring.springboot.spring_project.service.UserServiceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping
    public String showAllUsers(Model model) {
        List<User> list = userService.getAllUsers();
        for (User user: list) {
            System.out.println(user);
        }
        model.addAttribute("allUsers", list);
        return "all-users";
    }

    @GetMapping("/add")
    public String getUserForm(Model model) {
        model.addAttribute("listRole", roleService.getAllRoles());
        return "user-form";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("addUser") User user,
                          @RequestParam(value = "newRole", required = false) String[] role) {
        user.setRoles(getAddRole(role));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("editUser", userService.getUserById(id));
        model.addAttribute("listRole", roleService.getAllRoles());
        return "user-edit-form";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("editUser") User user,
                             @RequestParam(value = "newRole", required = false) String[] role) {
        user.setRoles(getAddRole(role));
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    private Set<Role> getAddRole(String [] role) {
        Set<Role> roleSet = new HashSet<>();
        for (int i = 0; i < role.length; i++) {
            roleSet.add(roleService.getRoleByName(role[i]));
        }
        return roleSet;
    }
}
