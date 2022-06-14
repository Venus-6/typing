package com.example.typing.controllers;

import com.example.typing.domain.Result;
import com.example.typing.domain.State;
import com.example.typing.domain.User;
import com.example.typing.repos.UsersRepository;
import com.example.typing.security.details.UserDetailsImpl;
import com.example.typing.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Optional;

import static com.example.typing.transfer.UserDto.*;

@Controller
public class TypingController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/typing")
    public String getLevelsPage(Authentication authentication, ModelMap model){
        if(authentication == null){
            return "redirect:/login";
        }
        //Получаем пользователя сессии
        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();
        UserDto user = from(details.getUser());
        model.addAttribute("user", user);
        model.addAttribute("initial", user.getUsername().toUpperCase().charAt(0));
        return "index";
    }

    @GetMapping("/user")
    public String getUserPage(Authentication authentication,ModelMap model){
        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();
        UserDto user = from(details.getUser());
        model.addAttribute("user", user);
        //TODO:Вывод результатов в таблицу
        //model.addAttribute("results", results);
        return "user";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(Authentication authentication){
        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();

        Optional<User> userCandidate = usersRepository.findByUsername(from(details.getUser()).getUsername());

        if (userCandidate.isPresent()){
            User user = userCandidate.get();
            user.setState(State.DELETED);
            usersRepository.save(user);
        }
        return "redirect:/logout";
    }
}
