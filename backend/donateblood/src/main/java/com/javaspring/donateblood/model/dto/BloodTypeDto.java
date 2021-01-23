package com.javaspring.donateblood.model.dto;

import com.javaspring.donateblood.model.BloodType;
import com.javaspring.donateblood.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class BloodTypeDto {

    private Long id;
    private String name;
    private List<UserDto> usersDto = new ArrayList<>();

    public static BloodTypeDto from(BloodType bloodType){
        BloodTypeDto bloodTypeDto = new BloodTypeDto();
        bloodTypeDto.setId(bloodType.getId());
        bloodTypeDto.setName(bloodType.getName());
        bloodTypeDto.setUsersDto(bloodType.getUsers().stream().map(UserDto::from).collect(Collectors.toList()));
        return bloodTypeDto;
    }
}
