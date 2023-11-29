package com.library.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "LIBRARY_User") //User is a reserved word so this is needed so that you can use the worrd user
@NoArgsConstructor
@Getter
@Setter
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")*/
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
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="user_book",
    joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="book_id"))
    @JsonManagedReference
    private List<Book> booksBorrowed;
}
