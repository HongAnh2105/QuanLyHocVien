package com.example.baiktra.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "loaikhoahocs")
public class Loaikhoahoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loaikhoahocid;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "loaikhoahoc")
    @JsonManagedReference
    private List<Khoahoc> khoahocs;
    @Column(name = "Tenloai")
    private String Tenloai;

    public String getTenloai() {
        return Tenloai;
    }

    public void setTenloai(String tenloai) {
        Tenloai = tenloai;
    }

    public int getLoaikhoahocid() {
        return loaikhoahocid;
    }

    public void setLoaikhoahocid(int loaikhoahocid) {
        this.loaikhoahocid = loaikhoahocid;
    }

    public List<Khoahoc> getKhoahocs() {
        return khoahocs;
    }

    public void setKhoahocs(List<Khoahoc> khoahocs) {
        this.khoahocs = khoahocs;
    }

}
