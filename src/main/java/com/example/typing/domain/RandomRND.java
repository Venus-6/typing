package com.example.typing.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "random")
public class RandomRND {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text_rnd;

    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "level")
    private Level level;
}
