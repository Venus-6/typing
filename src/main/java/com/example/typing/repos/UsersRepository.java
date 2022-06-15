package com.example.typing.repos;

import com.example.typing.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    //Optional - синтаксический сахар ("обертка" над null)
}
