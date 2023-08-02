package com.example.baiktra.service;

import com.example.baiktra.model.Khoahoc;

import java.util.List;

public interface Ikhoahocservice {
    public Khoahoc addkhoahoc(Khoahoc kh);
    public Khoahoc remakekhoahoc(Khoahoc khsua);
    public void removekhoahoc(int id);
    public Khoahoc getkhoahoc(int id);
    //    public khoaHoc timkiem(khoaHoc kh);
    public List<Khoahoc> timkiem(String hoten);
    public List<Khoahoc> getKhoaHocByPage(int pageNumber, int pageSize);
    public int hocvien(int hv);
}
