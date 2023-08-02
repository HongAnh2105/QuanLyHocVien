package com.example.baiktra.service;

import com.example.baiktra.model.Hocvien;
import com.example.baiktra.model.Khoahoc;
import com.example.baiktra.model.Tinhtranghoc;
import com.example.baiktra.reopsitory.Hocvienrepo;
import com.example.baiktra.reopsitory.Khoahocrepo;
import com.example.baiktra.reopsitory.Tinhtranghocrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Khoahocservice implements Ikhoahocservice{


    @Autowired
    private Khoahocrepo khoaHocRepo;
    @Autowired
    private Hocvienrepo hocVienRepo;
    @Autowired
    private Tinhtranghocrepo tinhTranghocRepo;

    @Override
    public Khoahoc addkhoahoc(Khoahoc kh) {
        kh.setSohocvien(hocvien(khoaHocRepo.findById(kh.getKhoahocid()).get().getSohocvien()));
        khoaHocRepo.save(kh);
        return kh;
    }

    @Override
    public Khoahoc remakekhoahoc(Khoahoc khsua) {
        Optional<Khoahoc> khoahoc= khoaHocRepo.findById(khsua.getKhoahocid());
        if(khoahoc.isEmpty()){
            return  null;
        }
        Khoahoc kh=khoahoc.get();
        kh.setTenkhoahoc(khsua.getTenkhoahoc());
        khoaHocRepo.save(kh);
        return kh;
    }

    @Override
    public void removekhoahoc(int id) {
        Optional<Khoahoc> khoahoc= khoaHocRepo.findById(id);
        if(khoahoc.isEmpty()){
            return ;
        }
        khoaHocRepo.delete(khoahoc.get());
    }

    @Override
    public Khoahoc getkhoahoc(int id) {
        Optional<Khoahoc> khoahoc= khoaHocRepo.findById(id);
        if(khoahoc.isEmpty()){
            return null;
        }
        return khoahoc.get();
    }

//    @Override
//    public khoaHoc timkiem(khoaHoc kh) {
//        Optional<khoaHoc> khs=khoaHocRepo.findById(kh.getKhoaHocid());
//        if(khs.isEmpty()){
//            return  null;
//        }
//        return khs.get();
//    }

    @Override
    public List<Khoahoc> timkiem(String hoten) {
        List<Khoahoc> lst= new ArrayList<Khoahoc>();
        for(Khoahoc x: khoaHocRepo.findAll()){
            if(x.getTenkhoahoc().toLowerCase().contains(hoten.toLowerCase())){
                lst.add(x);
            }
        }
        return lst;
    }

    @Override
    public  List<Khoahoc> getKhoaHocByPage(int pageNumber, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize);
        List<Khoahoc> result=khoaHocRepo.findAll(PageRequest.of(pageNumber, pageSize)).toList();
        //page<khoaHoc> result =  khoaHocRepo.findAll((org.springframework.data.domain.Pageable) pageable);
        return result;
    }

    @Override
    public int hocvien(int hv) {
        List<Hocvien> hocvien= hocVienRepo.findAll();
        List<Tinhtranghoc> tth =tinhTranghocRepo.findAll();
        List<Khoahoc> kh=khoaHocRepo.findAll();
        for(int i=0;i<hocvien.size()-1;i++){
            if( tth.get(i).getTentinhtrang().equals("đang học") && tth.get(i).getTentinhtrang().equals(" học xong") && tth.get(i).getTentinhtrang().equals("chưa hoàn thành")){
                kh.get(i).getSohocvien();
            }
        }
        return hv;
    }
}
