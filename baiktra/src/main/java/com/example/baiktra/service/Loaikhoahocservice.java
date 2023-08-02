package com.example.baiktra.service;

import com.example.baiktra.model.Loaikhoahoc;
import com.example.baiktra.reopsitory.Loaikhoahocrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Loaikhoahocservice implements Iloaikhoahocservice{

    @Autowired
    private Loaikhoahocrepo loaiKhoahocRepo;

    @Override
    public Loaikhoahoc addloaikhoahoc(Loaikhoahoc lkh) {
        loaiKhoahocRepo.save(lkh);
        return lkh;
    }

    @Override
    public Loaikhoahoc remakeloaikhoahoc(Loaikhoahoc lkhsua) {
        Optional<Loaikhoahoc> loaikhoahoc= loaiKhoahocRepo.findById(lkhsua.getLoaikhoahocid());
        if(loaikhoahoc.isEmpty()){
            return  null;
        }
        Loaikhoahoc lkh=loaikhoahoc.get();
        lkh.setTenloai(lkhsua.getTenloai());
        loaiKhoahocRepo.save(lkh);
        return lkh;
    }

    @Override
    public void removeloaikhoahoc(int id) {
        Optional<Loaikhoahoc> loaikhoahoc= loaiKhoahocRepo.findById(id);
        if(loaikhoahoc.isEmpty()){
            return ;
        }
        loaiKhoahocRepo.delete(loaikhoahoc.get());

    }

}
