package com.example.baiktra.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "taikhoans")
public class Taikhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taikhoanid;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "taikhoan")
    @JsonManagedReference
    private List<Dangkyhoc> dangkyhocs;
    @Column(name = "tennguoidung")

    private String tennguoidung;
    @Column(name = "taikhoan")
    private String taikhoan;
    @Column(name = "matkhau")
    private String matkhau;

    @Column(name = "quyenhanid",insertable = false,updatable = false)
    private int quyenhanId;
    @ManyToOne()
    @JoinColumn(name = "quyenhanid")
    @JsonBackReference
    private Quyenhan quyenhan;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "taikhoan")
    @JsonManagedReference
    private List<Baiviet> baiviets;


    public int getTaikhoanid() {
        return taikhoanid;
    }

    public void setTaikhoanid(int taikhoanid) {
        this.taikhoanid = taikhoanid;
    }

    public List<Dangkyhoc> getDangkyhocs() {
        return dangkyhocs;
    }

    public void setDangkyhocs(List<Dangkyhoc> dangkyhocs) {
        this.dangkyhocs = dangkyhocs;
    }

    public String getTennguoidung() {
        return tennguoidung;
    }

    public void setTennguoidung(String tennguoidung) {
        this.tennguoidung = tennguoidung;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getQuyenhanId() {
        return quyenhanId;
    }

    public void setQuyenhanId(int quyenhanId) {
        this.quyenhanId = quyenhanId;
    }

    public Quyenhan getQuyenhan() {
        return quyenhan;
    }

    public void setQuyenhan(Quyenhan quyenhan) {
        this.quyenhan = quyenhan;
    }

    public List<Baiviet> getBaiviets() {
        return baiviets;
    }

    public void setBaiviets(List<Baiviet> baiviets) {
        this.baiviets = baiviets;
    }
}
