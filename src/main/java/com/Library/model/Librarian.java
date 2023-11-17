package com.Library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Librarian {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    public Librarian(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

}
