package com.example.baiktra.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "khoahocs")
public class Khoahoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int khoahocid;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "khoahoc")
    @JsonManagedReference
    private List<Dangkyhoc> dangkyhocs;
    @Column(name = "tenkhoahoc")
    private String tenkhoahoc;
    @Column(name = "thoigianhoc")
    private int thoigianhoc;
    @Column(name = "gioithieu")
    private String gioithieu;
    @Column(name = "noidung")
    private String noidung;
    @Column(name = "hocphi")
    private int hocphi;
    @Column(name = "sohocvien")
    private int sohocvien;
    @Column(name = "soluongmon")
    private int soluongmon;
    @Column(name = "hinhanh")

    private String hinhanh;
    @Column(name = "loaikhoahocid",insertable = false,updatable = false)
    private int loaikhoahocId;
    @ManyToOne()
    @JoinColumn(name = "loaikhoahocid")
    @JsonBackReference
    private Loaikhoahoc loaikhoahoc;


    public int getKhoahocid() {
        return khoahocid;
    }

    public void setKhoahocid(int khoahocid) {
        this.khoahocid = khoahocid;
    }

    public List<Dangkyhoc> getDangkyhocs() {
        return dangkyhocs;
    }

    public void setDangkyhocs(List<Dangkyhoc> dangkyhocs) {
        this.dangkyhocs = dangkyhocs;
    }

    public String getTenkhoahoc() {
        return tenkhoahoc;
    }

    public void setTenkhoahoc(String tenkhoahoc) {
        this.tenkhoahoc = tenkhoahoc;
    }

    public int getThoigianhoc() {
        return thoigianhoc;
    }

    public void setThoigianhoc(int thoigianhoc) {
        this.thoigianhoc = thoigianhoc;
    }

    public String getGioithieu() {
        return gioithieu;
    }

    public void setGioithieu(String gioithieu) {
        this.gioithieu = gioithieu;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getHocphi() {
        return hocphi;
    }

    public void setHocphi(int hocphi) {
        this.hocphi = hocphi;
    }

    public int getSohocvien() {
        return sohocvien;
    }

    public void setSohocvien(int sohocvien) {
        this.sohocvien = sohocvien;
    }

    public int getSoluongmon() {
        return soluongmon;
    }

    public void setSoluongmon(int soluongmon) {
        this.soluongmon = soluongmon;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getLoaikhoahocId() {
        return loaikhoahocId;
    }

    public void setLoaikhoahocId(int loaikhoahocId) {
        this.loaikhoahocId = loaikhoahocId;
    }

    public Loaikhoahoc getLoaikhoahoc() {
        return loaikhoahoc;
    }

    public void setLoaikhoahoc(Loaikhoahoc loaikhoahoc) {
        this.loaikhoahoc = loaikhoahoc;
    }
}
