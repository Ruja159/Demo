package com.javaspring.donateblood.model;

import com.javaspring.donateblood.model.dto.BloodTypeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BloodType")
public class BloodType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String name;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bt_id")
    private List<User>users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }

    public static BloodType from(BloodTypeDto bloodTypeDto){
        BloodType bloodType = new BloodType();
        bloodType.setName(bloodTypeDto.getName());
        return bloodType;
    }
}
