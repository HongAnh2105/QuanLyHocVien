package com.example.baiktra.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tinhtranghocs")
public class Tinhtranghoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tinhtranghocid;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tinhtranghoc")
    @JsonManagedReference
    private List<Dangkyhoc> dangkyhocs;
    @Column(name = "tentinhtrang")

    private String tentinhtrang;


    public int getTinhtranghocid() {
        return tinhtranghocid;
    }

    public void setTinhtranghocid(int tinhtranghocid) {
        this.tinhtranghocid = tinhtranghocid;
    }

    public List<Dangkyhoc> getDangkyhocs() {
        return dangkyhocs;
    }

    public void setDangkyhocs(List<Dangkyhoc> dangkyhocs) {
        this.dangkyhocs = dangkyhocs;
    }

    public String getTentinhtrang() {
        return tentinhtrang;
    }

    public void setTentinhtrang(String tentinhtrang) {
        this.tentinhtrang = tentinhtrang;
    }
}
