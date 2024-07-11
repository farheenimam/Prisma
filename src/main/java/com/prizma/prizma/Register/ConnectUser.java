package com.prizma.prizma.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


// Repository annotation tells that this class provides operations for CRUD on the object
// Marks the class as data access object, responsible for interacting with db
@Repository // Communicates with database
// JPA repository provides crud operation
public interface ConnectUser extends JpaRepository<User, Long> {
    //Java Persistence API
    // This method is a custom query method to find a 'User' entity by its email
    User findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.name = :name")
    User findByUsername(@Param("name") String username);

}

