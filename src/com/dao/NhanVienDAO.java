/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.enitity.NhanVien;
import com.utils.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kiee
 */
public class NhanVienDAO extends SecondHandShopDAO<NhanVien, String> {

    private final String sqlInsert = "INSERT INTO NhanVien values(?,?,?,?,?,?,?,?,?)";
    private final String sqlUpdate = "update NhanVien set Password = ?, Ten = ?, GioiTinh = ?, NgaySinh = ?, VaiTro = ?, DiaChi = ?, SDT = ?, Email = ? where MaNV = ?";
    private final String sqlDelete = "DELETE FROM NhanVien WHERE MaNv = ?";
    private final String sqlSelectAll = "SELECT * FROM NhanVien";
    private final String sqlSelectById = "SELECT * FROM NhanVien WHERE MaNv = ?";

    @Override
    public void insert(NhanVien entity) {
        try {
            Jdbc.update(sqlInsert, entity.getMaNV(), entity.getPassword(), entity.getTen(), entity.isGioiTinh(), entity.getNgaySinh(), entity.isVaiTro(), entity.getDiaChi(), entity.getSDT(), entity.getEmail());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(NhanVien entity) {
        try {
            Jdbc.update(sqlUpdate, entity.getPassword(), entity.getTen(), entity.isGioiTinh(), entity.getNgaySinh(), entity.isVaiTro(), entity.getDiaChi(), entity.getSDT(), entity.getEmail(), entity.getMaNV());
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
    public List<NhanVien> selectAll() {
        return this.selectBySql(sqlSelectAll);
    }

    @Override
    public NhanVien selectById(String key) {
        List<NhanVien> list = this.selectBySql(sqlSelectById, key);
        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();

        try {
            ResultSet rs = Jdbc.query(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setPassword(rs.getString("Password"));
                entity.setTen(rs.getString("Ten"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                entity.setDiaChi(rs.getString("DiaChi"));
                entity.setSDT(rs.getString("SDT"));
                entity.setEmail(rs.getString("Email"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
    }

}
