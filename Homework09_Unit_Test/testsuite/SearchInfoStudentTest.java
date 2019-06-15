/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.testsuite;

import edu.hust.soict.dao.DBConnect;
import edu.hust.soict.dao.StudentDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author quangnd
 */
public class SearchInfoStudentTest {

    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     *
     */
    public SearchInfoStudentTest() {
    }

    //Test search student by Id.

    /**
     *
     */
    @Test
    public void testSearchStudent() {

        if (DBConnect.open()) {
            try {
                String expectedId = "20148888";
                String expectedName = "Lê Cát Trọng Lý";
                String expectedClass = "CNPM 01 K59";
                String expectedDepart = "Công Nghệ thông tin-2014";
                String expectedDate = "1996-04-28";
                String expectedEdu = "Đại học";
                String expectedYear = "2014";
                String expectedEmail = "ly.lct148888@sis.hust.edu.vn";
                String expectedState = "Học";
                ps = DBConnect.cnn.prepareStatement("select id_sinh_vien, ten_sinh_vien, lop_hoc, chuong_trinh_DT, ngay_sinh, he_hoc, khoa_hoc, email, trang_thai from thong_tin_sinh_vien where id_sinh_vien = ?");
                ps.setString(1, "20148888");
                rs = ps.executeQuery();
                if (rs.first()) {
                    assertEquals(expectedId, rs.getString(1));
                    assertEquals(expectedName, rs.getString(2));
                    assertEquals(expectedClass, rs.getString(3));
                    assertEquals(expectedDepart, rs.getString(4));
                    assertEquals(expectedDate, rs.getDate(5).toString());
                    assertEquals(expectedEdu, rs.getString(6));
                    assertEquals(expectedYear, rs.getString(7));
                    assertEquals(expectedEmail, rs.getString(8));
                    assertEquals(expectedState, rs.getString(9));
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
    }
}
