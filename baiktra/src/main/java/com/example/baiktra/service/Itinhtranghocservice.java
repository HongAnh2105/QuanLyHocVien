package com.example.baiktra.service;

import com.example.baiktra.model.Tinhtranghoc;

public interface Itinhtranghocservice {

    public Tinhtranghoc addtinhtranghoc(Tinhtranghoc tth);
    public Tinhtranghoc remaketinhtranghoc(Tinhtranghoc tthsua);
    public void removetinhtranghoc(int id);
    public Tinhtranghoc gettinhtranghoc(int id);
}
