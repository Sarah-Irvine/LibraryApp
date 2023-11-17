package com.Library.repository;

import com.Library.model.Librarian;
import com.Library.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrarianRepository extends CrudRepository<Librarian,Integer> {

    List<Librarian> findByNameContains(String filter);

    List<Librarian> findByNameNotContains(String notFilter);

    @Query("SELECT new Librarian(l.name, l.phoneNumber) " +
            "FROM Librarian l WHERE l.name LIKE %:name%")
    List<Librarian> searchByName(@Param("name") String name);

}
