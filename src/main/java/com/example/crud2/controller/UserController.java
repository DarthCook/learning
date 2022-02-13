package com.example.crud2.controller;

import com.example.crud2.controller.DTO.UserDTO;
import com.example.crud2.entity.User;
import com.example.crud2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignUpFrom(User user) {
        return "adduser";
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute("user") UserDTO userDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "adduser";
        }

        userService.addUser(userDTO.getName(), userDTO.getEmail());
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        User user = userService.showUpdateForm(id);
        model.addAttribute("user", user);
        return "updateuser";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") UserDTO userDTO, BindingResult result, Model model) {
        if(result.hasErrors()) {
            userDTO.setUserId(id);
            return "updateuser";
        }

        userService.updateUser(id, userDTO.getName(), userDTO.getEmail());
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/index";
    }

}
