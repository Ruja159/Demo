package com.javaspring.donateblood.model.exception;

import java.text.MessageFormat;

public class BloodTypeNotFoundException extends RuntimeException{

    public BloodTypeNotFoundException(final Long id){
        super(MessageFormat.format("Could not find bloodType with id: {0}", id));
    }
}
