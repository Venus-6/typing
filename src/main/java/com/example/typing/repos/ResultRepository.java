package com.example.typing.repos;

import com.example.typing.domain.Result;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result, Long> {
    @Query("SELECT r FROM Result r WHERE r.user_id.id = :id")
    List<Result> findAllByUser_id(long id);
}
