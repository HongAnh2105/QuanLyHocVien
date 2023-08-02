package com.example.baiktra.reopsitory;

import com.example.baiktra.model.Khoahoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Khoahocrepo extends JpaRepository<Khoahoc,Integer> {
}
