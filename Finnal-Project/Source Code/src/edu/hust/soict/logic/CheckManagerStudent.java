/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.logic;

import edu.hust.soict.dao.DBConnect;
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
public class CheckManagerStudent {
    
        public ResultSet resetDataStudent() {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT * FROM thong_tin_sinh_vien");
                ResultSet rs = ps.executeQuery();
                return rs;
            } catch (SQLException e) {
                Logger.getLogger(Tuition.class.getName()).log(Level.SEVERE, null, e);
            } 
        }
            return null;
    } 
        
    public ResultSet getStudentByClass(String getClass) {
        if (DBConnect.open()) {
            PreparedStatement psSearch = null;
            ResultSet rsSearch = null;
            if (DBConnect.open()) {
                try {
                    psSearch = DBConnect.cnn.prepareStatement("SELECT * FROM thong_tin_sinh_vien WHERE lop_hoc=?");
                    psSearch.setString(1, getClass);
                    rsSearch = psSearch.executeQuery();
                    return rsSearch;
                } catch (SQLException ex) {
                    Logger.getLogger(CreateStudentInfomation.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        }
            return null;
    }
}
