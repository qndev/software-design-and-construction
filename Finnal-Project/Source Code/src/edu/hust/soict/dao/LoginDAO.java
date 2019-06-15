/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.dao;

import edu.hust.soict.objects.AddUser;
import edu.hust.soict.ui.AdminLogin;
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
public class LoginDAO {

    public AddUser getAccount(String userName) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT user_name, password, is_admin FROM dang_nhap WHERE user_name=?");
                ps.setString(1, userName);
                rs = ps.executeQuery();
                if (rs.first()) {
                    String use_name = rs.getString(1);
                    String password = rs.getString(2);
                    String role = rs.getString(3);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return null;
    }
}
