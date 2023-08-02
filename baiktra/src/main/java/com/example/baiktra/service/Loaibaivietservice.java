package com.example.baiktra.service;

import com.example.baiktra.model.Loaibaiviet;
import com.example.baiktra.reopsitory.Loaibaivietrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
@Service
public class Loaibaivietservice implements Iloaibaivietservice{

    @Autowired
    private Loaibaivietrepo loaiBaivietRepo;

    @Override
    public Loaibaiviet addlbv(Loaibaiviet lbv) {
        loaiBaivietRepo.save(lbv);
        return lbv;
    }

    @Override
    public Loaibaiviet remakelbv(Loaibaiviet lbvsua) {
        Optional<Loaibaiviet> lbv= loaiBaivietRepo.findById(lbvsua.getLoaibaivietid());
        if(lbv.isEmpty()){
            return  null;
        }
        Loaibaiviet lbvs=lbv.get();
        lbvs.setTenloai(lbvsua.getTenloai());
        loaiBaivietRepo.save(lbvs);
        return lbvs;
    }

    @Override
    public void removelbv(int id) {
        Optional<Loaibaiviet> lbv= loaiBaivietRepo.findById(id);
        if(lbv.isEmpty()){
            return ;
        }
        loaiBaivietRepo.delete(lbv.get());
    }

    @Override
    public Loaibaiviet getlbv(int id) {
        Optional<Loaibaiviet> lbv= loaiBaivietRepo.findById(id);
        if(lbv.isEmpty()){
            return null;
        }
        return lbv.get();
    }


}
