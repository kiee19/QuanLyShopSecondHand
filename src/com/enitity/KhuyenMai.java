/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.enitity;

import java.util.Date;

/**
 *
 * @author kiee
 */
public class KhuyenMai {
    private String MaKM;
    private String tenKM;
    private String MaLoaiKM;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private float phanTramKM;
    private String maNV;

    public KhuyenMai() {
    }

    public KhuyenMai(String MaKM, String tenKM, String MaLoaiKM, Date ngayBatDau, Date ngayKetThuc, float phanTramKM, String maNV) {
        this.MaKM = MaKM;
        this.tenKM = tenKM;
        this.MaLoaiKM = MaLoaiKM;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.phanTramKM = phanTramKM;
        this.maNV = maNV;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getMaLoaiKM() {
        return MaLoaiKM;
    }

    public void setMaLoaiKM(String MaLoaiKM) {
        this.MaLoaiKM = MaLoaiKM;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public float getPhanTramKM() {
        return phanTramKM;
    }

    public void setPhanTramKM(float phanTramKM) {
        this.phanTramKM = phanTramKM;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    
    
}
