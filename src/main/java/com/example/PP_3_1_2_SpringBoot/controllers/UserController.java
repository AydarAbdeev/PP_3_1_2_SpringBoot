package com.example.PP_3_1_2_SpringBoot.controllers;

import com.example.PP_3_1_2_SpringBoot.models.User;
import com.example.PP_3_1_2_SpringBoot.services.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping(value = "")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping(value = "/user")
    public String userId(@RequestParam(value = "id", required = false) int id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "id";
    }

    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String edit(Model model, @RequestParam(value = "id", required = false) int id) {
        model.addAttribute("user", userService.findOne(id));
        return "edit";
    }

    @PatchMapping(value = "/user")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @RequestParam(value = "id", required = false) int id) {
        if (bindingResult.hasErrors()) {
            return "/edit";
        }
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/user")
    public String delete(@RequestParam(value = "id", required = false) int id) {
        userService.delete(id);
        return "redirect:/";
    }

}
