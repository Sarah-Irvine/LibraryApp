package com.library.service;

import com.library.model.User;
import com.library.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Iterable<User> usersIts = userRepository.findAll();
        usersIts.forEach(users::add);
        return users;
    }

    @Override
    public User findById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseGet(() -> new User("User does not exist",null));
    }

    @Override
    public List<User> findByNameContains(String filter) {
        return userRepository.findByNameContains(filter);
    }

    @Override
    public List<User> findByNameNotContains(String notFilter) {
        return userRepository.findByNameNotContains(notFilter);
    }

    @Override
    public User save(User u){
        return userRepository.save(u);
    }

    @Override
    public void delete(User u) {
        userRepository.delete(u);
    }
}
