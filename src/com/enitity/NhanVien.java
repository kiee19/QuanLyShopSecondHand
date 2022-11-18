package com.enitity;

import java.util.Date;

public class NhanVien {
    private String maNV;
    private String Password;
    private String ten;
    private boolean gioiTinh;
    private Date ngaySinh;
    private boolean vaiTro;
    private String diaChi;
    private String SDT;
    private String email;

    public NhanVien() {
    }

    public NhanVien(String maNV, String Password, String ten, boolean gioiTinh, Date ngaySinh, boolean vaiTro, String diaChi, String SDT, String email) {
        this.maNV = maNV;
        this.Password = Password;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.vaiTro = vaiTro;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.email = email;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String toString() {
        return this.ten;
    }
}
