package com.javaspring.donateblood.model.dto;


import com.javaspring.donateblood.model.User;
import lombok.Data;

import java.util.Objects;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private PlainBloodTypeDto plainBloodTypeDto;

    public static UserDto from(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        if(Objects.nonNull(user.getBloodType())){
            userDto.setPlainBloodTypeDto(PlainBloodTypeDto.from(user.getBloodType()));
        }
        return userDto;
    }


}
