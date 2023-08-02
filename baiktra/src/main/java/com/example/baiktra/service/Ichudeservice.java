package com.example.baiktra.service;

import com.example.baiktra.model.Chude;

public interface Ichudeservice {
    public Chude addcd(Chude cd);
    public Chude remakecd(Chude cdsua);
    public void removecd(int id);
    public Chude getcd(int id);
}
