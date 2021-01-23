package com.javaspring.donateblood.service;

import com.javaspring.donateblood.model.BloodType;
import com.javaspring.donateblood.model.User;
import com.javaspring.donateblood.model.exception.BloodTypeNotFoundException;
import com.javaspring.donateblood.model.exception.UserIsAlreadyAssigned;
import com.javaspring.donateblood.repository.BloodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class BloodTypeService {

    private final BloodTypeRepository bloodTypeRepository;
    private final UserService userService;

    @Autowired
    public BloodTypeService(BloodTypeRepository bloodTypeRepository, UserService userService) {
        this.bloodTypeRepository = bloodTypeRepository;
        this.userService = userService;
    }

    public BloodType addBloodType(BloodType bloodType){
        return bloodTypeRepository.save(bloodType);
    }

    public List<BloodType> getBloodTypes(){
        return bloodTypeRepository.findAll();
    }

    public BloodType getBloodTypeById(Long id){
        return bloodTypeRepository.findById(id).orElseThrow(()->
                new BloodTypeNotFoundException(id));
    }

    public BloodType deleteBloodType(Long id){
        BloodType bloodType = getBloodTypeById(id);
        bloodTypeRepository.delete(bloodType);
        return bloodType;
    }

    @Transactional
    public BloodType editBloodType(Long id,BloodType bloodType){
        BloodType bloodTypeToEdit= getBloodTypeById(id);
        bloodTypeToEdit.setName(bloodType.getName());
        return bloodTypeToEdit;
    }

    @Transactional
    public BloodType addUserToBloodType(Long bloodTypeId, Long userId){
        BloodType bloodType = getBloodTypeById(bloodTypeId);
        User user = userService.getUserById(userId);
        if(Objects.nonNull(user.getBloodType())){
            throw new UserIsAlreadyAssigned(userId, user.getBloodType().getId());
        }
        bloodType.addUser(user);
        user.setBloodType(bloodType);
        return bloodType;
    }

    @Transactional
    public BloodType removeUserFromBloodType(Long bloodTypeId, Long userId){
        BloodType bloodType = getBloodTypeById(bloodTypeId);
        User user = userService.getUserById(userId);
        bloodType.removeUser(user);
        return bloodType;
    }
}


