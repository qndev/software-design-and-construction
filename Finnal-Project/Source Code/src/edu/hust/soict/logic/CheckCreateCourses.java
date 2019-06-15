/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.logic;

import edu.hust.soict.dao.ClassDAO;
import edu.hust.soict.dao.DBConnect;
import edu.hust.soict.objects.MakeCourses;
import edu.hust.soict.ui.admin.CreateStudentInfomation;
import edu.hust.soict.ui.admin.Tuition;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quangnd
 */
public class CheckCreateCourses {
    
    public boolean checkManagerCourse(MakeCourses makeCourses){
        ClassDAO classDAO = new ClassDAO();
        if (makeCourses.getThoi_han_DK() == null) {
            return false;
        }else if (!checkNullValue(makeCourses)) {
            return false;
        }else{
            boolean check = classDAO.addNewCourses(makeCourses);
            if(check == true){
            return true;
            }else{
            return false;
            }

        }
    }

    private boolean checkNullValue(MakeCourses courses) {
        Check c = new Check();
        if (!c.checkIDCourses(courses.getMa_lop_DK()) || !c.check(courses.getMa_lop_DK())) {
            return false;
        } else if (!c.check(courses.getLoai_lop())) {
            return false;
        } else if (!c.check(courses.getTuan_hoc())) {
            return false;
        } else if (!c.check(courses.getPhong_hoc())) {
            return false;
        } else if (courses.getMax_DK() <= 0 || courses.getMax_DK() > 200) {
            return false;
        }
        return true;
    }
    
    
    public boolean checkUpdateCourses(MakeCourses updateCourses){
        
        boolean update = new ClassDAO().updateCourses(updateCourses);
        if(update == true){
        return true;
        }else{
        return false;
        }
    }
    
    public ResultSet getDataFromSearchFunction(String group) {
        if (DBConnect.open()) {
            PreparedStatement psSearch;
            ResultSet rsSearch;
            if (DBConnect.open()) {
                try {
                    psSearch = DBConnect.cnn.prepareStatement("SELECT ma_lop_mo_DK, thoi_gian_bat_dau, thoi_gian_ket_thuc, thu, tuan_hoc, loai_lop, id_mon_hoc_DK, nhom, phong_hoc, hoc_ki, so_luong_da_dang_ki, so_luong_max_DK, date_to_exist FROM danh_sach_lop_mo_DK WHERE nhom=?");
                    psSearch.setString(1, group);
                    rsSearch = psSearch.executeQuery();
                    return rsSearch;
                } catch (SQLException ex) {
                    Logger.getLogger(CreateStudentInfomation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    public ResultSet reSet1() {

        PreparedStatement ps1;
        ResultSet rs1;
        if (DBConnect.open()) {
            try {
                ps1 = DBConnect.cnn.prepareStatement("SELECT lop_hoc FROM search");
                rs1 = ps1.executeQuery();
                return rs1;
            } catch (SQLException e) {
                Logger.getLogger(Tuition.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    public ResultSet reSet2() {

        PreparedStatement ps2;
        ResultSet rs2;
        if (DBConnect.open()) {
            try {
                ps2 = DBConnect.cnn.prepareStatement("SELECT id_mon_hoc FROM mon_hoc");
                rs2 = ps2.executeQuery();
                return rs2;
            } catch (SQLException e) {
                Logger.getLogger(Tuition.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    public ResultSet reSet3() {

        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT ma_lop_mo_DK, thoi_gian_bat_dau, thoi_gian_ket_thuc, thu, tuan_hoc, loai_lop, id_mon_hoc_DK, nhom, phong_hoc, hoc_ki, so_luong_da_dang_ki, so_luong_max_DK, date_to_exist FROM danh_sach_lop_mo_DK");
                rs = ps.executeQuery();
                return rs;
            } catch (SQLException e) {
                Logger.getLogger(Tuition.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
     public boolean deleteCourses(String maLop) {
            
            boolean check = new ClassDAO().deleteCourses(maLop);
            if(check == true){
                return true;
            }else{
                return false;
            }
        }
}

