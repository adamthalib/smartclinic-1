package com.mitrais.smartclinic.controller;

import com.mitrais.smartclinic.model.User;
import com.mitrais.smartclinic.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
    public String saveUser(@Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "users/form-add";
        }
        userRepository.save(user);
        return "redirect:/";
    }
}
