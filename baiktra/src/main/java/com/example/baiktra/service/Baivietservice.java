package com.example.baiktra.service;

import com.example.baiktra.model.Baiviet;
import com.example.baiktra.reopsitory.Baivietrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Baivietservice implements Ibaibietservice{
    @Autowired
    private Baivietrepo baiVietRepo;


    @Override
    public Baiviet addbaiviet(Baiviet bv) {
        baiVietRepo.save(bv);
        return bv;
    }

    @Override
    public Baiviet remakebaiviet(Baiviet bvsua) {
        Optional<Baiviet> baiviet= baiVietRepo.findById(bvsua.getBaivietid());
        if(baiviet.isEmpty()){
            return  null;
        }
        Baiviet bv=baiviet.get();
        bv.setTenbaiviet(bvsua.getTenbaiviet());
        baiVietRepo.save(bv);
        return bv;
    }

    @Override
    public void removebaiviet(int id) {
        Optional<Baiviet> bv= baiVietRepo.findById(id);
        if(bv.isEmpty()){
            return ;
        }
        baiVietRepo.delete(bv.get());
    }

    @Override
    public Baiviet getbaiviet(int id) {
        Optional<Baiviet> bv= baiVietRepo.findById(id);
        if(bv.isEmpty()){
            return null;
        }
        return bv.get();
    }

    @Override
    public List<Baiviet> timkiem(String tenbv) {
        List<Baiviet> lst= new ArrayList<Baiviet>();
        for(Baiviet x: baiVietRepo.findAll()){
            if(x.getTenbaiviet().toLowerCase().contains(tenbv.toLowerCase())){
                lst.add(x);
            }
        }
        return lst;
    }

    @Override
    public List<Baiviet> getbaivietByPage(int pageNumber, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize);
        List<Baiviet> result=baiVietRepo.findAll(PageRequest.of(pageNumber, pageSize)).toList();
        //page<khoaHoc> result =  khoaHocRepo.findAll((org.springframework.data.domain.Pageable) pageable);
        return result;
    }
}
