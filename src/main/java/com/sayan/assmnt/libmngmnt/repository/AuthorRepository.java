package com.sayan.assmnt.libmngmnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sayan.assmnt.libmngmnt.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT b FROM Author b WHERE b.name LIKE %?1%")
    List<Author> search(String author);
}
