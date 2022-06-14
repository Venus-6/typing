package com.example.typing.forms;

import com.example.typing.domain.Result;
import lombok.Data;

@Data
public class UserForm {
    private long id;
    private String username;
    private String password;
    private String email;
}
