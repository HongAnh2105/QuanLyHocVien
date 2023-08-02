package com.example.baiktra.reopsitory;

import com.example.baiktra.model.Loaikhoahoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Loaikhoahocrepo extends JpaRepository<Loaikhoahoc,Integer> {
}
