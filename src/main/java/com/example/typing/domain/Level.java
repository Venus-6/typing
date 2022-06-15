package com.example.typing.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "level")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;

    @OneToMany(mappedBy = "level")
    private List<Result> result;

    @OneToMany(mappedBy = "level")
    private List<RandomRND> randoms;
}
