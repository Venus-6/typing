package com.example.typing.controllers;

import com.example.typing.domain.Level;
import com.example.typing.domain.RandomRND;
import com.example.typing.domain.Result;
import com.example.typing.domain.User;
import com.example.typing.repos.LevelRepository;
import com.example.typing.repos.RandomRNDRepository;
import com.example.typing.repos.UsersRepository;
import com.example.typing.security.details.UserDetailsImpl;
import com.example.typing.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.example.typing.transfer.UserDto.from;

@Controller
public class GameController {
    Level level;
    String rnd_text;
    long timer;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RandomRNDRepository randomRNDRepository;

    @Autowired
    private ResultService resultService;

    @Autowired
    private LevelRepository levelRepository;

    @GetMapping("/game/{id}")
    public String getGamePage(@PathVariable long id, ModelMap model){
        List<RandomRND> rnds = randomRNDRepository.findAllByLevel(id);
        Random rnd = new Random();
        int i = rnd.nextInt(rnds.size());
        rnd_text = rnds.get(i).getText_rnd();
        level = levelRepository.findLevelById(id);
        timer = System.currentTimeMillis();
        model.addAttribute("rnd_text", rnd_text);
        return "game";
    }

    @PostMapping(value="/save_result")
    public String saveResult(Authentication authentication){
        //TODO: Сохранить результат
        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();

        Optional<User> userCandidate = usersRepository.findByUsername(from(details.getUser()).getUsername());

        if (userCandidate.isPresent()) {
            User user = userCandidate.get();

            Result result = new Result();
            result.setResult(resultService.getStringResult((System.currentTimeMillis() - timer)/1000, rnd_text));
            result.setLevel(level);
            result.setUser_id(user);
            result.setDate(resultService.getStringDate());

            resultService.addResult(result);
        }

        return "redirect:/user";
    }
}
