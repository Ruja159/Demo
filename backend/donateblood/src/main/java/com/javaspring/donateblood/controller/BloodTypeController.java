package com.javaspring.donateblood.controller;

import com.javaspring.donateblood.model.BloodType;
import com.javaspring.donateblood.model.dto.BloodTypeDto;
import com.javaspring.donateblood.service.BloodTypeService;
import org.hibernate.type.BlobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bloodType")
public class BloodTypeController {

    private final BloodTypeService bloodTypeService;

    @Autowired
    public BloodTypeController(BloodTypeService bloodTypeService) {
        this.bloodTypeService = bloodTypeService;
    }


    @PostMapping
    public ResponseEntity<BloodTypeDto> addBloodType(@RequestBody final BloodTypeDto bloodTypeDto){
        BloodType bloodType = bloodTypeService.addBloodType(BloodType.from(bloodTypeDto));
        return  new ResponseEntity<>(BloodTypeDto.from(bloodType), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BloodTypeDto>> getBloodTypes(){
        List<BloodType> bloodTypes = bloodTypeService.getBloodTypes();
        List<BloodTypeDto> bloodTypeDto = bloodTypes.stream().map(BloodTypeDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(bloodTypeDto,HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<BloodTypeDto> getBloodType(@PathVariable final Long id){
        BloodType bloodType = bloodTypeService.getBloodTypeById(id);
        return new ResponseEntity<>(BloodTypeDto.from(bloodType), HttpStatus.OK);

    }

    @DeleteMapping(value = "{id}")
    public  ResponseEntity<BloodTypeDto> deleteBloodType(@PathVariable final Long id){
        BloodType bloodType = bloodTypeService.deleteBloodType(id);
        return new ResponseEntity<>(BloodTypeDto.from(bloodType), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public  ResponseEntity<BloodTypeDto> editBloodType(@PathVariable final Long id,
                                                       @RequestBody final  BloodTypeDto bloodTypeDto){
        BloodType bloodType = bloodTypeService.editBloodType(id, BloodType.from(bloodTypeDto));
        return new ResponseEntity<>(BloodTypeDto.from(bloodType), HttpStatus.OK);
    }

    @PostMapping(value = "{bloodTypeId}/users/{userId}/add")
    public ResponseEntity<BloodTypeDto> addUserToBloodType(@PathVariable final Long bloodTypeId,
                                                           @PathVariable final Long userId){
        BloodType bloodType = bloodTypeService.addUserToBloodType(bloodTypeId,userId);
        return new ResponseEntity<>(BloodTypeDto.from(bloodType), HttpStatus.OK);
    }

    @DeleteMapping(value = "{bloodTypeId}/users/{userId}/remove")
    public ResponseEntity<BloodTypeDto> removeUserFromBloodType(@PathVariable final Long bloodTypeId,
                                                           @PathVariable final Long userId){
        BloodType bloodType = bloodTypeService.removeUserFromBloodType(bloodTypeId,userId);
        return new ResponseEntity<>(BloodTypeDto.from(bloodType), HttpStatus.OK);

    }
}
