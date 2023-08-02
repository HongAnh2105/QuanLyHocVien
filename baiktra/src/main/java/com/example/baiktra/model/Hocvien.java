package com.example.baiktra.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hocviens")
public class Hocvien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hocvienid;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "hocvien")
    @JsonManagedReference
    private List<Dangkyhoc> dangkyhocs;

    @Column(name = "hinhanh")
    private String hinhanh;
    @Column(name = "hoten")
    private String hoten;
    @Column(name = "ngaysinh")
    private int ngaysinh;
    @Column(name = "sdt")
    private int sdt;
    @Column(name = "email")
    private String email;
    @Column(name = "tinhthanh")
    private String tinhthanh;
    @Column(name = "quanhuyen")
    private String quanhuyen;
    @Column(name = "phuongxa")
    private String phuongxa;
    @Column(name = "sonha")
    private String sonha;


    public int getHocvienid() {
        return hocvienid;
    }

    public void setHocvienid(int hocvienid) {
        this.hocvienid = hocvienid;
    }

    public List<Dangkyhoc> getDangkyhocs() {
        return dangkyhocs;
    }

    public void setDangkyhocs(List<Dangkyhoc> dangkyhocs) {
        this.dangkyhocs = dangkyhocs;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(int ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTinhthanh() {
        return tinhthanh;
    }

    public void setTinhthanh(String tinhthanh) {
        this.tinhthanh = tinhthanh;
    }

    public String getQuanhuyen() {
        return quanhuyen;
    }

    public void setQuanhuyen(String quanhuyen) {
        this.quanhuyen = quanhuyen;
    }

    public String getPhuongxa() {
        return phuongxa;
    }

    public void setPhuongxa(String phuongxa) {
        this.phuongxa = phuongxa;
    }

    public String getSonha() {
        return sonha;
    }

    public void setSonha(String sonha) {
        this.sonha = sonha;
    }
}
