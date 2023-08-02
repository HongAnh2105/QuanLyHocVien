package com.example.baiktra.service;

import com.example.baiktra.model.Khoahoc;
import com.example.baiktra.model.Loaikhoahoc;

import java.util.List;

public interface Iloaikhoahocservice {


    public Loaikhoahoc addloaikhoahoc(Loaikhoahoc lkh);
    public Loaikhoahoc remakeloaikhoahoc(Loaikhoahoc lkhsua);
    public void removeloaikhoahoc(int id);
}
