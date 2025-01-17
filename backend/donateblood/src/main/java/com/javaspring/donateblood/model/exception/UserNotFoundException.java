package com.javaspring.donateblood.model.exception;

import java.text.MessageFormat;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(final Long id){
        super(MessageFormat.format("Could not find user with id: {0}", id));
    }

//    public UserNotFoundException(String userName) { super(MessageFormat.format("Could not find user with id: {0}", userName));
//    }
}
