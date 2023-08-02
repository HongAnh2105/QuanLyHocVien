package com.example.baiktra.service;

import com.example.baiktra.model.Hocvien;

import java.util.List;

public interface Ihocvienservice {
    public Hocvien addhocvien(Hocvien hv);
    public Hocvien remakehocvien(Hocvien hv);
    public void removhocvien(int id);
    public Hocvien gethocvien(int id);
    public List<Hocvien> timkiem(String ten , String email);

}
