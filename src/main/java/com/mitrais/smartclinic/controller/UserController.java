package com.mitrais.smartclinic.controller;

import com.mitrais.smartclinic.model.User;
import com.mitrais.smartclinic.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/add")
    public String showUserForm(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "users/form-add";
    }

    @PostMapping("/add")
    public String saveUser(User user) {
        userRepository.save(user);
        return "redirect:/";
    }
}
