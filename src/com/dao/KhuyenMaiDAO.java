/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.enitity.KhuyenMai;
import com.utils.Jdbc;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author kiee
 */
public class KhuyenMaiDAO extends SecondHandShopDAO<KhuyenMai, String> {

    private final String sqlInsert = "INSERT INTO KhuyenMai values(?,?,?,?,?,?,?)";
    private final String sqlUpdate = "update KhuyenMai set TenKM = ?, MaLoaiKM = ?, NgayBatDau = ?, NgayKetThuc = ?, PhanTramKM = ?, MaNV = ? where MaKM = ?";
    private final String sqlDelete = "DELETE FROM NhanVien WHERE MaKM = ?";
    private final String sqlSelectAll = "SELECT * FROM KhuyenMai";
    private final String sqlSelectById = "SELECT * FROM KhuyenMai WHERE MaKM = ?";

    @Override
    public void insert(KhuyenMai entity) {
        try {
            Jdbc.update(sqlInsert, entity.getMaKM(), entity.getTenKM(), entity.getMaLoaiKM(), entity.getNgayBatDau(), entity.getNgayKetThuc(), entity.getPhanTramKM(), entity.getMaNV());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(KhuyenMai entity) {
        try {
            Jdbc.update(sqlInsert, entity.getTenKM(), entity.getMaLoaiKM(), entity.getNgayBatDau(), entity.getNgayKetThuc(), entity.getPhanTramKM(), entity.getMaNV(), entity.getMaKM());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String key) {
        try {
            Jdbc.update(sqlDelete, key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<KhuyenMai> selectAll() {
        return this.selectBySql(sqlSelectAll);
    }

    @Override
    public KhuyenMai selectById(String key) {
        List<KhuyenMai> list = this.selectBySql(sqlSelectById, key);

        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

    @Override
    protected List<KhuyenMai> selectBySql(String sql, Object... args) {
        List<KhuyenMai> list = new ArrayList<>();

        try {
            ResultSet rs = Jdbc.query(sql, args);
            while (rs.next()) {
                KhuyenMai entity = new KhuyenMai();
                entity.setMaKM(rs.getString("MaKM"));
                entity.setTenKM(rs.getString("TenKM"));
                entity.setMaLoaiKM(rs.getString("MaLoaiKM"));
                entity.setNgayBatDau(rs.getDate("NgayBatDau"));
                entity.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                entity.setPhanTramKM(rs.getFloat("PhanTramKM"));
                entity.setMaNV(rs.getString("MaNV"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
