package com.example.typing.domain;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String date;
    private String result;

    @ManyToOne(optional=false,  cascade=CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne(optional=false,  cascade=CascadeType.MERGE)
    @JoinColumn(name = "level")
    private Level level;
}
