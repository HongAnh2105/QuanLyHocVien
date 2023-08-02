package com.example.baiktra.reopsitory;

import com.example.baiktra.model.Tinhtranghoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tinhtranghocrepo extends JpaRepository<Tinhtranghoc,Integer> {
}
