package com.example.baiktra.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "loaibaiviets")
public class Loaibaiviet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loaibaivietid;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "loaibaiviet")
    @JsonManagedReference
    private List<Chude> chudes;
    @Column(name = "tenloai")
    private String tenloai;

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public int getLoaibaivietid() {
        return loaibaivietid;
    }

    public void setLoaibaivietid(int loaibaivietid) {
        this.loaibaivietid = loaibaivietid;
    }

    public List<Chude> getChudes() {
        return chudes;
    }

    public void setChudes(List<Chude> chudes) {
        this.chudes = chudes;
    }
}
