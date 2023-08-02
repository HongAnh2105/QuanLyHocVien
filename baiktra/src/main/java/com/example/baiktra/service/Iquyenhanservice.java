package com.example.baiktra.service;

import com.example.baiktra.model.Quyenhan;

public interface Iquyenhanservice {
    public Quyenhan addquyenhan(Quyenhan qh);
    public Quyenhan remakekhoahoc(Quyenhan qhsua);
    public void removequyenhan(int id);
    public Quyenhan getquyenhan(int id);
}
