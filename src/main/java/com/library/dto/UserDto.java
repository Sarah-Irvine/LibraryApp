package com.library.dto;

import com.library.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;
    private String name;
    private String phoneNumber;
    private Address address;
    private List<BookTitleDto> booksBorrowed;
}
