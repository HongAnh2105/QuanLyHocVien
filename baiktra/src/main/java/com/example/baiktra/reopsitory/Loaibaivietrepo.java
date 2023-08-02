package com.example.baiktra.reopsitory;

import com.example.baiktra.model.Loaibaiviet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Loaibaivietrepo extends JpaRepository<Loaibaiviet,Integer> {
}
