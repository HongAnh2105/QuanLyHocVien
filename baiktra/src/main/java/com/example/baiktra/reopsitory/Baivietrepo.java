package com.example.baiktra.reopsitory;

import com.example.baiktra.model.Baiviet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Baivietrepo extends JpaRepository<Baiviet,Integer> {
    @Query(value = "SELECT * FROM Baiviet ",nativeQuery = true)
    Page<Baiviet>findAll(Pageable pageable);
}
