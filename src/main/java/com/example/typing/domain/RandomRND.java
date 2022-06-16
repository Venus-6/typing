package com.example.typing.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
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

    @ManyToOne(optional=false, cascade=CascadeType.MERGE)
    @JoinColumn(name = "level")
    private Level level;
}
