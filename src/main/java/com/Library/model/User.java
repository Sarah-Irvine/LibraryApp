package com.Library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LIBRARY_User") //User is a reserved word so this is needed so that you can use the worrd user
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    public User(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //add manyToMany functionality here
}
