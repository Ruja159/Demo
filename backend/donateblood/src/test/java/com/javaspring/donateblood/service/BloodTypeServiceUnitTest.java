package com.javaspring.donateblood.service;


import com.javaspring.donateblood.model.BloodType;
import com.javaspring.donateblood.model.User;
import com.javaspring.donateblood.model.dto.UserDto;
import com.javaspring.donateblood.repository.BloodTypeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:test.properties")
public class BloodTypeServiceUnitTest {


    @Autowired
    BloodTypeService bloodTypeService;

    @Test
    public void testGetBloodTypeById() {
        BloodType bloodType = bloodTypeService.getBloodTypeById(Long.parseLong("1"));
        assertEquals("0+", bloodType.getName());
    }

}
