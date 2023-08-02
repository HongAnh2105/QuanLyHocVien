package com.example.baiktra.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "dangkyhocs")
public class Dangkyhoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "khoahocid",insertable = false,updatable = false)
    private int khoahocId;
    @ManyToOne()
    @JoinColumn(name = "khoahocid")
    @JsonBackReference
    private Khoahoc khoahoc;


    @Column(name = "hocvienid",insertable = false,updatable = false)
    private int hocvienId;
    @ManyToOne()
    @JoinColumn(name = "hocvienid")
    @JsonBackReference
    private Hocvien hocvien;
    @Column(name = "ngaydangky")

    private LocalDate ngaydangky;
    @Column(name = "ngaybatdau")
    private LocalDate ngaybatdau;
    @Column(name = "ngayketthuc")
    private LocalDate ngayketthuc;

    @Column(name = "tinhtranghocid",insertable = false,updatable = false)
    private int tinhtranghocId;
    @ManyToOne()
    @JoinColumn(name = "tinhtranghocid")
    @JsonBackReference
    private Tinhtranghoc tinhtranghoc;


    @Column(name = "taikhoanid",insertable = false,updatable = false)
    private int taikhoanId;
    @ManyToOne()
    @JoinColumn(name = "taikhoanid")
    @JsonBackReference
    private Taikhoan taikhoan;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKhoahocId() {
        return khoahocId;
    }

    public void setKhoahocId(int khoahocId) {
        this.khoahocId = khoahocId;
    }

    public Khoahoc getKhoahoc() {
        return khoahoc;
    }

    public void setKhoahoc(Khoahoc khoahoc) {
        this.khoahoc = khoahoc;
    }

    public int getHocvienId() {
        return hocvienId;
    }

    public void setHocvienId(int hocvienId) {
        this.hocvienId = hocvienId;
    }

    public Hocvien getHocvien() {
        return hocvien;
    }

    public void setHocvien(Hocvien hocvien) {
        this.hocvien = hocvien;
    }

    public LocalDate getNgaydangky() {
        return ngaydangky;
    }

    public void setNgaydangky(LocalDate ngaydangky) {
        this.ngaydangky = ngaydangky;
    }

    public LocalDate getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(LocalDate ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public LocalDate getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(LocalDate ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }



    public int getTinhtranghocId() {
        return tinhtranghocId;
    }

    public void setTinhtranghocId(int tinhtranghocId) {
        this.tinhtranghocId = tinhtranghocId;
    }

    public Tinhtranghoc getTinhtranghoc() {
        return tinhtranghoc;
    }

    public void setTinhtranghoc(Tinhtranghoc tinhtranghoc) {
        this.tinhtranghoc = tinhtranghoc;
    }

    public int getTaikhoanId() {
        return taikhoanId;
    }

    public void setTaikhoanId(int taikhoanId) {
        this.taikhoanId = taikhoanId;
    }

    public Taikhoan getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(Taikhoan taikhoan) {
        this.taikhoan = taikhoan;
    }
}
