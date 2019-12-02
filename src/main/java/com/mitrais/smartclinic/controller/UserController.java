package com.mitrais.smartclinic.controller;

import com.mitrais.smartclinic.model.Patient;
import com.mitrais.smartclinic.model.User;
import com.mitrais.smartclinic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Access;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String patient(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users/user";
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
        return "redirect:/users";
    }
    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return "redirect:/users";
    }
}