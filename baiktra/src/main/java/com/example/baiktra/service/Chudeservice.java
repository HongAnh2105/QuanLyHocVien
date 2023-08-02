package com.example.baiktra.service;

import com.example.baiktra.model.Chude;
import com.example.baiktra.reopsitory.Chuderepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Chudeservice implements Ichudeservice{

    @Autowired
    private Chuderepo chuDeRepo;

    @Override
    public Chude addcd(Chude cd) {
        chuDeRepo.save(cd);
        return cd;
    }

    @Override
    public Chude remakecd(Chude cdsua) {
        Optional<Chude> cd= chuDeRepo.findById(cdsua.getChudeid());
        if(cd.isEmpty()){
            return  null;
        }
        Chude cds=cd.get();
        cds.setTenchude(cdsua.getTenchude());
        chuDeRepo.save(cds);
        return cds;
    }

    @Override
    public void removecd(int id) {
            Optional<Chude> cd= chuDeRepo.findById(id);
            if(cd.isEmpty()){
                return ;
            }
            chuDeRepo.delete(cd.get());
    }

    @Override
    public Chude getcd(int id) {
        Optional<Chude> cd= chuDeRepo.findById(id);
        if(cd.isEmpty()){
            return null;
        }
        return cd.get();
    }
}
