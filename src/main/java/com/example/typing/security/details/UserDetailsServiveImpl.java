package com.example.typing.security.details;

import com.example.typing.repos.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiveImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Возвращает исключение, если пользователя не существует
        return new
                UserDetailsImpl(usersRepository.findByUsername(username)
                    .orElseThrow(IllegalArgumentException::new));
    }
}
