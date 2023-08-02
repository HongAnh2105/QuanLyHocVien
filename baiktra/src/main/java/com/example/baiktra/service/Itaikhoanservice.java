package com.example.baiktra.service;

import com.example.baiktra.model.Taikhoan;

import java.util.List;

public interface Itaikhoanservice {

    public Taikhoan addtaikhoan(Taikhoan tk);
    public Taikhoan remaketaikhoan(Taikhoan tksua);
    public void removetaikhoan(int id);
    public Taikhoan gettaikhoan(int id);

    public List<Taikhoan> timkiemtk(String tentk);

}
