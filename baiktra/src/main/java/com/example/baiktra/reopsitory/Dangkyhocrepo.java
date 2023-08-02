package com.example.baiktra.reopsitory;

import com.example.baiktra.model.Dangkyhoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dangkyhocrepo extends JpaRepository<Dangkyhoc,Integer> {
}
