package com.example.baiktra.service;

import com.example.baiktra.model.Baiviet;

import java.util.List;

public interface Ibaibietservice {
    public Baiviet addbaiviet(Baiviet bv);
    public Baiviet remakebaiviet(Baiviet bvsua);
    public void removebaiviet(int id);
    public Baiviet getbaiviet(int id);
    public List<Baiviet> timkiem(String tenbv);
    public List<Baiviet> getbaivietByPage(int pageNumber, int pageSize);

}
