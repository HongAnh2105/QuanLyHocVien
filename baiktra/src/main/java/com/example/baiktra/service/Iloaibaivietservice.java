package com.example.baiktra.service;

import com.example.baiktra.model.Loaibaiviet;

import java.util.List;

public interface Iloaibaivietservice {
    public Loaibaiviet addlbv(Loaibaiviet lbv);
    public Loaibaiviet remakelbv(Loaibaiviet lbvsua);
    public void removelbv(int id);
    public Loaibaiviet getlbv(int id);

}
