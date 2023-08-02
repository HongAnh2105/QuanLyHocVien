package com.example.baiktra.service;

import com.example.baiktra.model.Dangkyhoc;
import com.example.baiktra.model.Tinhtranghoc;
import com.example.baiktra.reopsitory.Dangkyhocrepo;
import com.example.baiktra.reopsitory.Khoahocrepo;
import com.example.baiktra.reopsitory.Tinhtranghocrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class Dangkyhocservice implements Idangkyhocservice{

    @Autowired
    private Dangkyhocrepo dangKyhocRepo;
    @Autowired
    private Tinhtranghocrepo tinhTranghocRepo;
    @Autowired
    private Khoahocrepo khoaHocRepo;

    @Override
    public LocalDate capNhatNgayketthuc(int DangkyhocID) {
        Optional<Dangkyhoc> dangKyHoc = dangKyhocRepo.findById(DangkyhocID);
        if (dangKyHoc.get().getNgaybatdau()==null)
            return null;
        else
            return dangKyHoc.get().getNgaybatdau().plusDays(dangKyHoc.get().getKhoahoc().getThoigianhoc());
    }

    public LocalDate ngaybatdau(int dangkyhocid){
        Optional<Dangkyhoc> dangKyhoc=dangKyhocRepo.findById(dangkyhocid);
        List<Tinhtranghoc> tth=tinhTranghocRepo.findAll();
        for(Tinhtranghoc x : tth){
            if(x.getTentinhtrang().toString().equals("đang học chính")){
                return dangKyhoc.get().getNgaybatdau();
            }
        }
        return null;
    }

//    @Override
//    public void ngay(LocalDate nbd, LocalDate nkt) {
//        List<dangKyhoc> dk=dangKyhocRepo.findAll();
//        List<tinhTranghoc> tth=tinhTranghocRepo.findAll();
//        List<khoaHoc> kh = khoaHocRepo.findAll();
//        for(int i=0;i<dk.size();i++){
//            for(int j=0;j<tth.size();j++){
//                for(int z=0;z<kh.size();z++){
//                    if(tth.get(j).getTenTinhtrang().toString()=="đang học chính"){
//                        nbd=dk.get(i).getNgayBatdau();
//                        nkt=capNhatNgayketthuc(dk.get(i).getDangKyhocid());
//                }
//                }
//            }
//        }
    //}

    @Override
    public Dangkyhoc adddk(Dangkyhoc dk) {
        dk.getHocvien();
        dk.setNgaydangky(LocalDate.now());
        if(tinhTranghocRepo.findById(dk.getTinhtranghoc().getTinhtranghocid()).get().getTentinhtrang().equals("đang học chính")){
            LocalDate datenow = LocalDate.now();
            dk.setNgaybatdau(datenow);
            dk.setNgayketthuc((datenow.plusDays(khoaHocRepo.findById(dk.getKhoahoc().getKhoahocid()).get().getThoigianhoc())));
        }
        dangKyhocRepo.save(dk);
        return dk;
    }
    @Override
    public Dangkyhoc remakedk(Dangkyhoc dksua) {
        Optional<Dangkyhoc> dangky= dangKyhocRepo.findById(dksua.getId());
        if(dangky.isEmpty()){
            return  null;
        }
        dangky.get().setNgaydangky(dksua.getNgaydangky());
        dangky.get().setNgaybatdau(ngaybatdau(dangky.get().getId()));
        dangky.get().setNgayketthuc(capNhatNgayketthuc(dangky.get().getId()));
        dangKyhocRepo.save(dangky.get());
        return  dangky.get();
    }

    @Override
    public void removdk(int id) {
        Optional<Dangkyhoc> dk= dangKyhocRepo.findById(id);
        if(dk.isEmpty()){
            return ;
        }
        dangKyhocRepo.delete(dk.get());
    }

    @Override
    public Dangkyhoc getdk(int id) {
        Optional<Dangkyhoc> dk= dangKyhocRepo.findById(id);
        if(dk.isEmpty()){
            return null;
        }
        return dk.get();
    }


}
