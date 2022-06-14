package com.example.typing.services;

import com.example.typing.domain.Role;
import com.example.typing.domain.State;
import com.example.typing.domain.User;
import com.example.typing.forms.UserForm;
import com.example.typing.repos.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm) {
        //Хэширование пароля
        String password = passwordEncoder.encode(userForm.getPassword());

        User user = User.builder()
                .username(userForm.getUsername())
                .password(password)
                .email(userForm.getEmail())
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();

        usersRepository.save(user);
    }
}
