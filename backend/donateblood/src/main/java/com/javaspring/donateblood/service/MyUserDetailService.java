package com.javaspring.donateblood.service;

import com.javaspring.donateblood.model.MyUserDetails;
import com.javaspring.donateblood.model.User;
import com.javaspring.donateblood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       Optional<User> user = userRepository.findByUserName(userName);

       user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

       return user.map(MyUserDetails::new).get();
    }
}
