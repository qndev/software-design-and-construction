/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.dao;

import edu.hust.soict.objects.MonHoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quangnd
 */
public class SubjectsDAO {

    /**
     *
     * @param maMonHoc
     * @return
     */
    public ArrayList<MonHoc> findByIDSubjects(String maMonHoc) {
        ArrayList<MonHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT id_mon_hoc, ten_mon_hoc, thoi_luong, so_tin_chi, tin_chi_hoc_phi, trong_so FROM mon_hoc WHERE ten_mon_hoc=?");
                ps.setString(1, maMonHoc);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    MonHoc monHoc = new MonHoc();
                    monHoc.setIdMonHoc(rs.getString(1));
                    monHoc.setTenMonHoc(rs.getString(2));
                    monHoc.setThoiLuong(rs.getString(3));
                    monHoc.setSoTinChi(rs.getInt(4));
                    monHoc.setTinChiHocPhi(rs.getFloat(5));
                    monHoc.setTrongSo(rs.getFloat(6));
                    list.add(monHoc);
                }

            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }

        return list;
    }

    /**
     *
     * @return
     */
    public ArrayList<MonHoc> getAll() {
        ArrayList<MonHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT id_mon_hoc, ten_mon_hoc, thoi_luong, so_tin_chi, tin_chi_hoc_phi, trong_so FROM mon_hoc");
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    MonHoc monHoc = new MonHoc();
                    monHoc.setIdMonHoc(rs.getString(1));
                    monHoc.setTenMonHoc(rs.getString(2));
                    monHoc.setThoiLuong(rs.getString(3));
                    monHoc.setSoTinChi(rs.getInt(4));
                    monHoc.setTinChiHocPhi(rs.getFloat(5));
                    monHoc.setTrongSo(rs.getFloat(6));
                    list.add(monHoc);
                }

            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }

        return list;
    }
}
