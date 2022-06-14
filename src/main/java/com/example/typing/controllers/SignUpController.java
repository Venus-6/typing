package com.example.typing.controllers;

import com.example.typing.domain.User;
import com.example.typing.forms.UserForm;
import com.example.typing.repos.UsersRepository;
import com.example.typing.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService service;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/signup")
    public String getSignUpPage(){
        return "reg";
    }

    @PostMapping("/signup")
    public String signUp(UserForm userForm, ModelMap model){
        Optional<User> userCandidate = usersRepository.findByUsername(userForm.getUsername());
        if(userCandidate.isPresent()){
            model.addAttribute("error", "Пользователь уже существует!");
            return "reg";
        }
        service.signUp(userForm);
        return "redirect:/login";
    }
}
