package com.example.typing.domain;

import com.example.typing.forms.UserForm;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "authuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "user_id", fetch=FetchType.EAGER)
    private List<Result> result;

    public static User form(UserForm form){
        return User.builder()
                .id(form.getId())
                .username(form.getUsername())
                .email(form.getEmail())
                .build();
    }
}
