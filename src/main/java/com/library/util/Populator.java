package com.library.util;

import com.library.model.Address;
import com.library.model.Librarian;
import com.library.model.User;
import com.library.repository.LibrarianRepository;
import com.library.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class Populator {

    private UserRepository userRepository;
    private LibrarianRepository librarianRepository;

    //@EventListener(ContextRefreshedEvent.class)
    public void populate(){
        User user = new User();
        user.setName("Sarah");
        user.setPhoneNumber("1234567890");

        Address address = new Address();
        address.setId(1);
        address.setLineOne("123 Tom St");
        address.setLineTwo("Unit G");
        address.setState("Utah");
        address.setPostalCode("84065");
        address.setCountry("USA");

        user.setAddress(address);

        userRepository.save(user);

        Librarian librarian = new Librarian();
        librarian.setName("Zaggy");
        librarian.setPhoneNumber("0987654321");

        Address address1 = new Address();
        address1.setId(2);
        address1.setLineOne("456 Tom St");
        address1.setLineTwo("Unit F");
        address1.setState("Utah");
        address1.setPostalCode("87605");
        address1.setCountry("USA");

        librarian.setAddress(address1);

        librarianRepository.save(librarian);
    }

}
