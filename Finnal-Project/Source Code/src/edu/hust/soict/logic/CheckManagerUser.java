/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.logic;

import edu.hust.soict.dao.AddUserDAO;
import edu.hust.soict.dao.DBConnect;
import edu.hust.soict.objects.AddUser;
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
public class CheckManagerUser {
    
    public ResultSet getDataAccount() {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT user_name, password, is_admin FROM dang_nhap");
                rs = ps.executeQuery();
                return rs; 
            } catch (SQLException e) {
                Logger.getLogger(Tuition.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
        
    public boolean checkInfoAccount(AddUser addUser) {
        Check c = new Check();
        if (!c.checkID(addUser.getUser_name())) {
            return false;
        } else if (!c.checkSpace(addUser.getPassword()) || !c.check(addUser.getPassword())) {  
            return false;
        }else{
            boolean addNewUser =  new AddUserDAO().addNew(addUser);
            if(addNewUser == true){
                return true;
            }else{
            return false;
            }
        }
    }
}
