package com.example.typing.repos;

import com.example.typing.domain.Level;
import org.springframework.data.repository.CrudRepository;

public interface LevelRepository extends CrudRepository<Level, Long> {
    Level findLevelById(long id);
}
