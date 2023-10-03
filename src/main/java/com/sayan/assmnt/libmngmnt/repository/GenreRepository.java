package com.sayan.assmnt.libmngmnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sayan.assmnt.libmngmnt.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query("SELECT b FROM Genre b WHERE b.name LIKE %?1%")
    List<Genre> search(String genre);
}
