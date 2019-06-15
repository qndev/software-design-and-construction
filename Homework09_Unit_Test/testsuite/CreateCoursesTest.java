/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.testsuite;

import edu.hust.soict.dao.ClassDAO;
import edu.hust.soict.dao.DBConnect;
import edu.hust.soict.objects.MakeCourses;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author quangnd
 */
public class CreateCoursesTest {

    PreparedStatement ps;
    ResultSet rs;

    /**
     *
     */
    public CreateCoursesTest() {
    }

    /**
     * Test case Create new course successfully.
     * @throws java.sql.SQLException
     */
    @Test
    public void testCreateNewCourse() throws SQLException {
        System.out.println("# testCreateNewCourse( Test validation create new course ).");
        String maLop = "123456";
        String batDau = "12:30:00";
        String ketThuc = "15:30:00";
        String thu = "5";
        String tuanHoc = "2-9/11-18";
        String loaiLop = "LT+BT";
        String maMonHoc = "IT1010";
        String nhom = "TC TEST";
        String phongHoc = "TEST ROOM";
        int maxDK = 100;
        String hocki = "20181";
        String str = "2018-12-31";
        java.sql.Date sqlDate = Date.valueOf(str);
        ClassDAO cldao = new ClassDAO();
        MakeCourses rg = new MakeCourses(maLop, batDau, ketThuc, thu, tuanHoc, loaiLop, maMonHoc, nhom, phongHoc, maxDK, hocki, sqlDate);
        cldao.addNewCourses(rg);
        if (DBConnect.open()) {
            String sql = "SELECT * FROM danh_sach_lop_mo_DK WHERE ma_lop_mo_DK = '123456'";
            ps = DBConnect.cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.first()) {
                String actualMaLop = rs.getString(2);
                String actualBatDau = rs.getString(3);
                String actualKetThuc = rs.getString(4);
                String actualThu = rs.getString(5);
                String actualTuanHoc = rs.getString(6);
                String actualLoaiLop = rs.getString(7);
                String actualMaMonHoc = rs.getString(8);
                String actualNhom = rs.getString(9);
                String actualPhongHoc = rs.getString(10);
                String actualHocKi = rs.getString(11);
                int actualMaxDK = rs.getInt(13);
                java.sql.Date actualSqlDate = rs.getDate(14);
                assertEquals(maLop, actualMaLop);
                assertEquals(batDau, actualBatDau);
                assertEquals(ketThuc, actualKetThuc);
                assertEquals(thu, actualThu);
                assertEquals(tuanHoc, actualTuanHoc);
                assertEquals(loaiLop, actualLoaiLop);
                assertEquals(maMonHoc, actualMaMonHoc);
                assertEquals(nhom, actualNhom);
                assertEquals(phongHoc, actualPhongHoc);
                assertEquals(maxDK, actualMaxDK);
                assertEquals(hocki, actualHocKi);
                assertEquals(sqlDate, actualSqlDate);
                if (actualMaLop.equals(maLop) && actualBatDau.equals(batDau) && actualKetThuc.equals(ketThuc) && actualThu.equals(thu)
                        && actualTuanHoc.equals(tuanHoc) && actualLoaiLop.equals(loaiLop) && actualMaMonHoc.equals(maMonHoc)
                        && actualNhom.equals(nhom) && actualPhongHoc.equals(phongHoc) && actualMaxDK == maxDK && actualHocKi.equals(hocki) && actualSqlDate.equals(sqlDate)) {
                    System.out.println("MaLop matched!");
                    System.out.println("BatDau matched!");
                    System.out.println("KetThuc matched!");
                    System.out.println("Thu matched!");
                    System.out.println("TuanHoc matched!");
                    System.out.println("LoaiLop matched!");
                    System.out.println("MaMonHoc matched!");
                    System.out.println("Nhom matched!");
                    System.out.println("PhongHoc matched!");
                    System.out.println("HocKi matched!");
                    System.out.println("MaxDK matched!");
                    System.out.println("HanDK matched!");
                }
            }
        }

    }

    /**
     * Test case Update course successfully.
     */
    @Test
    public void testUpdateCourse() {
        System.out.println("# testUpdateCourse( Test validation update course ).");
        String maLop = "123456";
        String batDau = "12:30:00";
        String ketThuc = "15:30:00";
        String thu = "5";
        String tuanHoc = "2-9/11-18";
        String loaiLop = "LT+BT";
        String maMonHoc = "IT1010";
        String nhom = "TC TEST";
        String phongHoc = "TEST ROOM UPDATE";
        int maxDK = 100;
        String hocki = "20181";
        String str = "2018-12-31";
        java.sql.Date sqlDate = Date.valueOf(str);
        MakeCourses courses = new MakeCourses(maLop, batDau, ketThuc, thu, tuanHoc, loaiLop, maMonHoc, nhom, phongHoc, maxDK, hocki, sqlDate);
        //actual value when run updateCourses() method.
        boolean update = new ClassDAO().updateCourses(courses);
        //expected is value, value we want expected (example here is: courses object with list of properties (maLop, ...)).
        boolean expected = true;
        //if expected value = update value(actual value) then method updateCourses(Object course) successfully.
        assertTrue(expected == update);
        if (expected == update) {
            System.out.println("Updated successfully!");
        }
    }

    /**
     * Test case Delete course successfully.
     * @throws java.sql.SQLException
     */
    @Test
    public void testDeleteCourse() throws SQLException {
        System.out.println("# testDeleteCourse( Test validation delete course ).");
        String malop = "123456";
        new ClassDAO().deleteCourses(malop);
        if (DBConnect.open()) {
            String sql = "SELECT * FROM danh_sach_lop_mo_DK WHERE ma_lop_mo_DK = '123456'";
            ps = DBConnect.cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            boolean courseExpected = false;
            boolean resultActual = rs.isBeforeFirst();
            assertTrue(courseExpected == resultActual);
            if (courseExpected == resultActual) {
                System.out.println("Không tồn tại lớp " + malop + "\n" + "Do mã lớp đã bị xóa!");
            }
        }
    }

    /**
     * Test case Check delete course(class) with more than 20 students registered.
     * @throws java.sql.SQLException
     */
    @Test
    public void testDeleteError1() throws SQLException {
        System.out.println("# testDeleteError1( Method deleteCourses() running true if courseId = 104439 not deleted after deleteCourses executed.)");
        String courseId = "104439";
        new ClassDAO().deleteCourses(courseId);
        if (DBConnect.open()) {
            String sql = "SELECT * FROM danh_sach_lop_mo_DK WHERE ma_lop_mo_DK = '104439'";
            ps = DBConnect.cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            boolean courseExpected = true;
            boolean resultActual = rs.isBeforeFirst();
            assertTrue(courseExpected == resultActual);
            if (courseExpected == resultActual) {
                System.out.println("Method deleteCourses() is running true!");
            }
        }
        ps.close();
    }
}
