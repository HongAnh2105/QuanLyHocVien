package com.example.baiktra.service;

import com.example.baiktra.model.Dangkyhoc;

import java.time.LocalDate;
import java.util.List;

public interface Idangkyhocservice {
    public LocalDate capNhatNgayketthuc(int DangkyhocID);
    //public void ngay(LocalDate nbd, LocalDate nkt);
    public Dangkyhoc adddk(Dangkyhoc dk);
    public Dangkyhoc remakedk(Dangkyhoc dksua);
    public void removdk(int id);
    public Dangkyhoc getdk(int id);
    public LocalDate ngaybatdau(int dangkyhocid);
}
