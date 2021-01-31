package com.javaspring.donateblood.service;

import com.javaspring.donateblood.model.User;
import com.javaspring.donateblood.model.exception.UserNotFoundException;
import com.javaspring.donateblood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){

        return  userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->
                new UserNotFoundException(id));
    }

    public User getUserByUserName(String userName){
        return userRepository.findUserByUserName(userName);
    }


    public User deleteUser(Long id){
        User user = getUserById(id);
        userRepository.delete(user);
        return user;
    }

    @Transactional
    public User editUser(Long id, User user){
        User userToEdit = getUserById(id);
        userToEdit.setName(user.getName());
        userToEdit.setLastName(user.getLastName());
        return userToEdit;
    }
}
