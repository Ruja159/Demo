package com.javaspring.donateblood.model;

import com.javaspring.donateblood.model.dto.UserDto;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.beans.ConstructorProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String userName;
    @ManyToOne
    BloodType bloodType;


    public static User from(UserDto userDto){
        User user=new User();
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserName(userDto.getUserName());
        return user;
    }

}
