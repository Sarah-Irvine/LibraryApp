package com.library.repository;

import com.library.model.Librarian;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrarianRepository extends CrudRepository<Librarian,Integer> {

    List<Librarian> findByNameContains(String filter);

    List<Librarian> findByNameNotContains(String notFilter);

}
