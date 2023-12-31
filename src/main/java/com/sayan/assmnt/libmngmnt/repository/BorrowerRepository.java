package com.sayan.assmnt.libmngmnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sayan.assmnt.libmngmnt.entity.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
    @Query("SELECT b FROM Borrower b WHERE b.name LIKE %?1%")
    List<Borrower> search(String borrower);
}
