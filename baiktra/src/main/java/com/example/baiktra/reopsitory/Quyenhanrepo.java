package com.example.baiktra.reopsitory;

import com.example.baiktra.model.Quyenhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Quyenhanrepo extends JpaRepository<Quyenhan,Integer> {
}
