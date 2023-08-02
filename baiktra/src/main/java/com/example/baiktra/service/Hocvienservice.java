package com.example.baiktra.service;

import com.example.baiktra.model.Hocvien;
import com.example.baiktra.reopsitory.Hocvienrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Hocvienservice implements Ihocvienservice{
    @Autowired
    private Hocvienrepo hocVienRepo;

    @Override
    public Hocvien addhocvien(Hocvien hv) {
        hocVienRepo.save(hv);
        return hv;
    }

    @Override
    public Hocvien remakehocvien(Hocvien hvsua) {
        Optional<Hocvien> hocvien= hocVienRepo.findById(hvsua.getHocvienid());
        if(hocvien.isEmpty()){
            return  null;
        }
        Hocvien hv=hocvien.get();
        hv.setHoten(hvsua.getHoten());
        hocVienRepo.save(hv);
        return hv;
    }

    @Override
    public void removhocvien(int id) {
        Optional<Hocvien> hocvien= hocVienRepo.findById(id);
        if(hocvien.isEmpty()){
            return ;
        }
        hocVienRepo.delete(hocvien.get());

    }

    @Override
    public Hocvien gethocvien(int id) {
        Optional<Hocvien> hv= hocVienRepo.findById(id);
        if(hv.isEmpty()){
            return null;
        }
        return hv.get();
    }

    @Override
    public List<Hocvien> timkiem(String ten, String email) {
        List<Hocvien> lst= new ArrayList<Hocvien>();
        for(Hocvien x: hocVienRepo.findAll()){
            if(x.getHoten().toLowerCase().contains(ten.toLowerCase())&&
                    x.getEmail().toLowerCase().contains(email.toLowerCase())){
                lst.add(x);
            }
        }
        return lst;
    }


}
