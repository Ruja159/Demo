package com.javaspring.donateblood.model.exception;

import org.aspectj.bridge.Message;

import java.text.MessageFormat;

public class UserIsAlreadyAssigned extends RuntimeException{

    public UserIsAlreadyAssigned(final Long userId,final Long bloodTypeId){

        super(MessageFormat.format("User: {0} is already assignem to BloodType: {1}", userId, bloodTypeId));

    }
}
