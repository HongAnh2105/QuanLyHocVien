package com.example.baiktra.service;

import com.example.baiktra.model.Tinhtranghoc;
import com.example.baiktra.reopsitory.Tinhtranghocrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Tinhtranghocservice implements Itinhtranghocservice{

    @Autowired
    private Tinhtranghocrepo tinhTranghocRepo;

    @Override
    public Tinhtranghoc addtinhtranghoc(Tinhtranghoc tth) {
        tinhTranghocRepo.save(tth);
        return tth;
    }

    @Override
    public Tinhtranghoc remaketinhtranghoc(Tinhtranghoc tthsua) {
        Optional<Tinhtranghoc> tths= tinhTranghocRepo.findById(tthsua.getTinhtranghocid());
        if(tths.isEmpty()){
            return  null;
        }
        Tinhtranghoc th=tths.get();
        th.setTentinhtrang(tthsua.getTentinhtrang());
        tinhTranghocRepo.save(th);
        return th;
    }

    @Override
    public void removetinhtranghoc(int id) {
        Optional<Tinhtranghoc> tinhtrang= tinhTranghocRepo.findById(id);
        if(tinhtrang.isEmpty()){
            return ;
        }
        tinhTranghocRepo.delete(tinhtrang.get());

    }

    @Override
    public Tinhtranghoc gettinhtranghoc(int id) {
        Optional<Tinhtranghoc> tinhtrang=tinhTranghocRepo.findById(id);
        if(tinhtrang.isEmpty()){
            return null;
        }
        return tinhtrang.get();
    }
}
