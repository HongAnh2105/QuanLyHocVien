package com.example.baiktra.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "baiviets")
public class Baiviet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baivietid")
    private int baivietid;
    @Column(name = "tenbaiviet")
    private String tenbaiviet;
    @Column(name = "thoigiantao")
    private int thoigiantao;
    @Column(name = "tentacgia")
    private  String tentacgia;
    @Column(name = "noidung")
    private String noidung;
    @Column(name = "noidungngan")
    private String noidungngan;
    @Column(name = "hinhanh")
    private String hinhanh;



    @Column(name = "chudeid",insertable = false,updatable = false)
    private int chudeId;
    @ManyToOne()
    @JoinColumn(name = "chudeid")
    @JsonBackReference
    private Chude chude;


    @Column(name = "taikhoanid",insertable = false,updatable = false)
    private int taikhoanId;
    @ManyToOne()
    @JoinColumn(name = "taikhoanid")
    @JsonBackReference
    private Taikhoan taikhoan;


    public int getBaivietid() {
        return baivietid;
    }

    public void setBaivietid(int baivietid) {
        this.baivietid = baivietid;
    }

    public String getTenbaiviet() {
        return tenbaiviet;
    }

    public void setTenbaiviet(String tenbaiviet) {
        this.tenbaiviet = tenbaiviet;
    }

    public int getThoigiantao() {
        return thoigiantao;
    }

    public void setThoigiantao(int thoigiantao) {
        this.thoigiantao = thoigiantao;
    }

    public String getTentacgia() {
        return tentacgia;
    }

    public void setTentacgia(String tentacgia) {
        this.tentacgia = tentacgia;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getNoidungngan() {
        return noidungngan;
    }

    public void setNoidungngan(String noidungngan) {
        this.noidungngan = noidungngan;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getChudeId() {
        return chudeId;
    }

    public void setChudeId(int chudeId) {
        this.chudeId = chudeId;
    }

    public Chude getChude() {
        return chude;
    }

    public void setChude(Chude chude) {
        this.chude = chude;
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
