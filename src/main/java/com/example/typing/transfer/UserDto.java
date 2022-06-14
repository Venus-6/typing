package com.example.typing.transfer;

import com.example.typing.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

//Отправка пользователя на нужную страницу
@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private long id;
    private String username;
    private String email;
    //Содержит ограниченные данные для отправки модели User
    public static UserDto from(User user){
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
