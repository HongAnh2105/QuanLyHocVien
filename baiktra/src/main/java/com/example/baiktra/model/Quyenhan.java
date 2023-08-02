package com.example.baiktra.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "quyenhans")
public class Quyenhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quyenhanid;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "quyenhan")
    @JsonManagedReference
    private List<Taikhoan> taikhoans;
    @Column(name = "tenquyenhan")
    private String tenquyenhan;

    public String getTenquyenhan() {
        return tenquyenhan;
    }

    public void setTenquyenhan(String tenquyenhan) {
        this.tenquyenhan = tenquyenhan;
    }

    public int getQuyenhanid() {
        return quyenhanid;
    }

    public void setQuyenhanid(int quyenhanid) {
        this.quyenhanid = quyenhanid;
    }

    public List<Taikhoan> getTaikhoans() {
        return taikhoans;
    }

    public void setTaikhoans(List<Taikhoan> taikhoans) {
        this.taikhoans = taikhoans;
    }
}
