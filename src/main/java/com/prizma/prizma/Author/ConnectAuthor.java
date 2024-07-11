package com.prizma.prizma.Author;

import com.prizma.prizma.Reader.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectAuthor extends JpaRepository<Author, Long> {
    // Finds all the authors in the database
    @Query("SELECT a FROM Author a")
    List<Author> findAuthors();



}
