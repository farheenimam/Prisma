package com.prizma.prizma.Reader;

import com.prizma.prizma.Author.IncomeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectReader extends JpaRepository<Reader, Long> {
    // Custom query to find readers by book and author
    // It goes into the entity class and matched the members of the Readers class
    @Query("SELECT r FROM Reader r WHERE r.email = :email AND r.author = :author")
    Reader findByEmailBookAndAuthor(@Param("email") String email, @Param("author") String author); // Param annotation binds the query parameter with method parameter

    // To find the subscription details of the readers
    @Query("SELECT r FROM Reader r WHERE r.email = :email")
    List<Reader> findByEmailOfBuyer(@Param("email") String email);

    @Query("SELECT r FROM Reader r WHERE r.author = :author")
    List<Reader> findAuthor(@Param("author") String author);

    @Query("SELECT new com.prizma.prizma.Author.IncomeInfo(SUM(r.amount)) " +
            "FROM Reader r WHERE r.author = :author GROUP BY r.author")
    IncomeInfo findAuthorIncome(@Param("author") String author);

    // Query to fetch all readers (subscribers) and their subscription details
    List<Reader> findAll();
}
