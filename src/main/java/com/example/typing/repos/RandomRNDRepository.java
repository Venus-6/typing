package com.example.typing.repos;

import com.example.typing.domain.RandomRND;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RandomRNDRepository extends CrudRepository<RandomRND, Long> {
    @Query("SELECT r FROM RandomRND r WHERE r.level.id = :level")
    List<RandomRND> findAllByLevel(long level);
}
