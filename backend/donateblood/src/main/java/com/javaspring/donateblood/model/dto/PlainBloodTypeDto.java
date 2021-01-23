package com.javaspring.donateblood.model.dto;

import com.javaspring.donateblood.model.BloodType;
import lombok.Data;

@Data
public class PlainBloodTypeDto {

    private Long id;
    private String name;

    public static PlainBloodTypeDto from(BloodType bloodType){
        PlainBloodTypeDto plainBloodTypeDto = new PlainBloodTypeDto();
        plainBloodTypeDto.setId(bloodType.getId());
        plainBloodTypeDto.setName(bloodType.getName());
        return plainBloodTypeDto;
    }
}
