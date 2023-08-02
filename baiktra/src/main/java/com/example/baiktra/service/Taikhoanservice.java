package com.example.baiktra.service;

import com.example.baiktra.model.Taikhoan;
import com.example.baiktra.reopsitory.Taikhoanrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Taikhoanservice implements Itaikhoanservice{



    @Autowired
    private Taikhoanrepo taiKhoanRepo;

    @Override
    public Taikhoan addtaikhoan(Taikhoan tk) {
        taiKhoanRepo.save(tk);
        return tk;
    }

    @Override
    public Taikhoan remaketaikhoan(Taikhoan tksua) {
        Optional<Taikhoan> taikhoan= taiKhoanRepo.findById(tksua.getTaikhoanid());
        if(taikhoan.isEmpty()){
            return  null;
        }
        Taikhoan tk=taikhoan.get();
        tk.setTaikhoan(tksua.getTaikhoan());
        taiKhoanRepo.save(tk);
        return tk;
    }

    @Override
    public void removetaikhoan(int id) {
        Optional<Taikhoan> taikhoan= taiKhoanRepo.findById(id);
        if(taikhoan.isEmpty()){
            return ;
        }
        taiKhoanRepo.delete(taikhoan.get());
    }

    @Override
    public Taikhoan gettaikhoan(int id) {
        Optional<Taikhoan> taikhoan= taiKhoanRepo.findById(id);
        if(taikhoan.isEmpty()){
            return null;
        }
        return taikhoan.get();
    }

    @Override
    public List<Taikhoan> timkiemtk(String tentk) {
        List<Taikhoan> lst= new ArrayList<Taikhoan>();
        for(Taikhoan x: taiKhoanRepo.findAll()){
            if(x.getTaikhoan().toLowerCase().contains(tentk.toLowerCase())){
                lst.add(x);
            }
        }
        return lst;
    }


}
