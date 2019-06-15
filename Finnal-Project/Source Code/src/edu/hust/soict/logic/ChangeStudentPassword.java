/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.logic;

import edu.hust.soict.dao.AddUserDAO;
import edu.hust.soict.dao.DBConnect;
import edu.hust.soict.objects.AddUser;
import edu.hust.soict.ui.student.ChangePassword;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author quangnd
 */
public class ChangeStudentPassword {
    
    public boolean changePassword(AddUser addUser, AddUser addUser1){
        PreparedStatement ps = null;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT password FROM dang_nhap WHERE user_name=" + addUser.getUser_name());
                rs = ps.executeQuery();
                if (rs.first()) {
                    String getPasswordDatabase = rs.getString("password");
                    boolean encryptedPassword = PasswordUtils.checkPassword(addUser.getPassword(), getPasswordDatabase);
                    if (encryptedPassword == false) {
                        return false;
                    } else {
                        new AddUserDAO().updateUser2(addUser1);
                        return true;
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            DBConnect.close(ps);
            }
        }
        return false;
    } 
}
