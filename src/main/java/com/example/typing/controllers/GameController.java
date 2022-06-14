package com.example.typing.controllers;

import com.example.typing.domain.User;
import com.example.typing.repos.UsersRepository;
import com.example.typing.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

import static com.example.typing.transfer.UserDto.from;

@Controller
public class GameController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/game/{id}")
    public String getGamePage(@PathVariable int id){
        return "game";
    }

    @PostMapping("/save_result")
    public String saveResult(Authentication authentication){
        //TODO: Сохранить результат
        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();

        Optional<User> userCandidate = usersRepository.findByUsername(from(details.getUser()).getUsername());

        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
        }

        return "redirect:/user";
    }

    //TODO: Добавление текста из БД по уровню
}
