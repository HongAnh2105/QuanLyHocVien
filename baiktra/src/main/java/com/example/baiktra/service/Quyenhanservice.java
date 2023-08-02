package com.example.baiktra.service;

import com.example.baiktra.model.Quyenhan;
import com.example.baiktra.reopsitory.Quyenhanrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Quyenhanservice implements Iquyenhanservice{

    @Autowired
    private Quyenhanrepo quyenHanRepo;

    @Override
    public Quyenhan addquyenhan(Quyenhan qh) {
        quyenHanRepo.save(qh);
        return qh;
    }

    @Override
    public Quyenhan remakekhoahoc(Quyenhan qhsua) {
        Optional<Quyenhan> quyenhan= quyenHanRepo.findById(qhsua.getQuyenhanid());
        if(quyenhan.isEmpty()){
            return  null;
        }
        Quyenhan qh=quyenhan.get();
        qh.setTenquyenhan(qhsua.getTenquyenhan());
        quyenHanRepo.save(qh);
        //khoaHocRepo.save(kh);
        return qh;
    }

    @Override
    public void removequyenhan(int id) {
        Optional<Quyenhan> qh= quyenHanRepo.findById(id);
        if(qh.isEmpty()){
            return ;
        }
        quyenHanRepo.delete(qh.get());
    }

    @Override
    public Quyenhan getquyenhan(int id) {
        Optional<Quyenhan> qh= quyenHanRepo.findById(id);
        if(qh.isEmpty()){
            return null;
        }
        return qh.get();
    }
}
