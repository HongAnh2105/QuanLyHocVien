package com.example.baiktra.reopsitory;

import com.example.baiktra.model.Taikhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Taikhoanrepo extends JpaRepository<Taikhoan,Integer> {
}
