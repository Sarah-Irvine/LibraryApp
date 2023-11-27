package com.Library.service;

import com.Library.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    List<User> findByNameContains(String filter);

    List<User> findByNameNotContains(String notFilter);

    public User save(User u);

    public void delete(User u);
}
