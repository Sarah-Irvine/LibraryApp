package com.Library.repository;

import com.Library.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    List<User> findByNameContains(String filter);

    List<User> findByNameNotContains(String notFilter);

}
