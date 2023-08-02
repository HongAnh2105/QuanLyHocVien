package com.example.baiktra.reopsitory;

import com.example.baiktra.model.Hocvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Hocvienrepo extends JpaRepository<Hocvien,Integer> {
}
