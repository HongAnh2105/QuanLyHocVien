package com.example.baiktra.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chudes")
public class Chude {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chudeid;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "chude")
    @JsonManagedReference
    private List<Baiviet> baiviets;
    @Column(name = "tenchude")

    private String tenchude;
    @Column(name = "noidung")
    private String noidung;


    @Column(name = "loaibaivietid",insertable = false,updatable = false)
    private int loaibaivietId;
    @ManyToOne()
    @JoinColumn(name = "loaibaivietid")
    @JsonBackReference
    private Loaibaiviet loaibaiviet;


    public int getChudeid() {
        return chudeid;
    }

    public void setChudeid(int chudeid) {
        this.chudeid = chudeid;
    }

    public List<Baiviet> getBaiviets() {
        return baiviets;
    }

    public void setBaiviets(List<Baiviet> baiviets) {
        this.baiviets = baiviets;
    }

    public String getTenchude() {
        return tenchude;
    }

    public void setTenchude(String tenchude) {
        this.tenchude = tenchude;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getLoaibaivietId() {
        return loaibaivietId;
    }

    public void setLoaibaivietId(int loaibaivietId) {
        this.loaibaivietId = loaibaivietId;
    }

    public Loaibaiviet getLoaibaiviet() {
        return loaibaiviet;
    }

    public void setLoaibaiviet(Loaibaiviet loaibaiviet) {
        this.loaibaiviet = loaibaiviet;
    }
}
