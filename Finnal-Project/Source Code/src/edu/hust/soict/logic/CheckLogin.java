/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.logic;

import edu.hust.soict.dao.AddUserDAO;
import edu.hust.soict.dao.DBConnect;
import edu.hust.soict.objects.AddUser;
import edu.hust.soict.ui.StudentsLogin;
import edu.hust.soict.ui.admin.Main;
import edu.hust.soict.ui.student.ChangePassword;
import edu.hust.soict.ui.student.MainStudent;
import edu.hust.soict.ui.student.Schedule;
import edu.hust.soict.ui.student.StudentInfomation;
import edu.hust.soict.ui.student.StudentRegisterCourses;
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
public class CheckLogin {

    public boolean checkAdminLogin(AddUser addUser) throws SQLException {
        ResultSet rs = null;
        PreparedStatement ps = null;
        boolean checkOpenConnection = DBConnect.open();
        if (checkOpenConnection == true) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT user_name, password, is_admin FROM dang_nhap WHERE user_name=?");
                ps.setString(1, addUser.getUser_name());
                rs = ps.executeQuery();
                if (rs.first()) {
                   if (rs != null) { 
                    String userNameGetFromDB = rs.getString("user_name");
                    String passwordGetFromDB = rs.getString("password");
                    String roleGetFromDB = rs.getString("is_admin");
                    AddUser addUser1 = new AddUser(userNameGetFromDB, passwordGetFromDB, roleGetFromDB);
                    boolean encryptedPassword = PasswordUtils.checkPassword(addUser.getPassword(), addUser1.getPassword());
                    if (addUser.getUser_name().equals(addUser1.getUser_name()) && encryptedPassword == true && addUser.getIs_admin().equals(addUser1.getIs_admin())) {
                    Main main = new Main();
                    main.setVisible(true);
                    return true;
                    } else {
                       return false;
                    }
//                    compareAccount(addUser, addUser1);
//                    if(compareAccount(addUser, addUser1) == true){
//                    return true;
//                    }
                    }
//                   else{
//                    return false;
//                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return false;
    }
    
        public boolean checkStudentLogin(String userName, String passWord, String role) throws SQLException {
           ResultSet rs = null;
           PreparedStatement ps = null;
           if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT dang_nhap.user_name, thong_tin_sinh_vien.ten_sinh_vien, dang_nhap.password, dang_nhap.is_admin, thong_tin_sinh_vien.email, thong_tin_sinh_vien.ngay_sinh, thong_tin_sinh_vien.lop_hoc, thong_tin_sinh_vien.chuong_trinh_DT, thong_tin_sinh_vien.he_hoc, thong_tin_sinh_vien.trang_thai FROM dang_nhap \n"
                        + "INNER JOIN thong_tin_sinh_vien ON dang_nhap.user_name = thong_tin_sinh_vien.id_sinh_vien WHERE dang_nhap.user_name =" + userName);
                rs = ps.executeQuery();
                //check user exists in database.
                if (rs.isBeforeFirst() == false) {
                    //JOptionPane.showMessageDialog(null, "User không tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                } else if (rs.isBeforeFirst() == true) {
                    if (rs.first()) {
                        String username = rs.getString(1);
                        String getPasswordDatabase = rs.getString(3);
                        String is_admin = rs.getString(4);
                        String name = rs.getString(2);
                        String ngay_sinh = rs.getString(6);
                        String lop_hoc = rs.getString(7);
                        String chuong_trinh_DT = rs.getString(8);
                        String he_hoc = rs.getString(9);
                        String email = rs.getString(5);
                        String trang_thai = rs.getString(10);
                        //check password user input matched with password in database.
                        boolean encryptedPassword = PasswordUtils.checkPassword(passWord, getPasswordDatabase);
                        //if all of username, password, role matched, user login success.
                        if ((userName.equals(username)) && (encryptedPassword == true) && (role.equals(is_admin))) {
                            MainStudent mainstudent = new MainStudent(username, name, ngay_sinh, lop_hoc, chuong_trinh_DT, trang_thai, email, he_hoc);
                            StudentInfomation thongtinsv = new StudentInfomation(username, name, ngay_sinh, lop_hoc, chuong_trinh_DT, trang_thai, email, he_hoc);
                            StudentRegisterCourses search = new StudentRegisterCourses(username);
                            Schedule schedule = new Schedule(username);
                            ChangePassword changePassword = new ChangePassword(username);
                            mainstudent.setVisible(true);
                            thongtinsv.setVisible(true);
                            search.setVisible(true);
                            changePassword.setVisible(true);
                            return true;
                        } else if ((userName.equals(username)) && (encryptedPassword == false)) {
                            //JOptionPane.showMessageDialog(null, "Mật khẩu sai vui lòng nhập lại mật khẩu!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                            this.resetForm();
                            return false;
                        } else {
                            //JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra vui lòng đăng nhập lại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                            this.resetForm();
                            return false;
                        }
                    }
                } else {
                    return false;
                    //JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra vui lòng đăng nhập lại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                // Logger.getLogger(StudentsLogin.class
                //         .getName()).log(Level.SEVERE, null, ex);
                String sqlMessage = ex.getMessage();
                String sqlState = ex.getSQLState();
                int vendorCode = ex.getErrorCode();
                System.err.println("SQLException:");
                System.err.println("ERROR code: " + vendorCode);
                System.err.println("SQL state: " + sqlState);
                System.err.println("Message: " + sqlMessage + "\n----------------");
                if (vendorCode == 1054) {
                    //JOptionPane.showMessageDialog(null, "Chúng tôi không nhận dạng đựoc User: " + userName + "\n" + "Vui lòng kiểm tra lại thông tin tài khoản đăng nhập!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                } else {
                    //JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra vui lòng đăng nhập lại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            } finally {
                DBConnect.close(ps);
            }
        }

        return false;
    }

    public boolean checkInputNullAccount(String user, String getPasswordTextField) {
        String strnull = "";
        if (user.equals(strnull) || getPasswordTextField.equals(strnull)) {
            return true;
        }
        return false;
    }

    private void resetForm() {
        StudentsLogin login = new StudentsLogin();
        login.jtfUsername.setText("");
        login.jpPassword.setText("");
        login.jtfUsername.requestFocus();
    }

    private boolean compareAccount(AddUser addUser, AddUser addUser11) {
        boolean encryptedPassword = PasswordUtils.checkPassword(addUser.getPassword(), addUser11.getPassword());
             if (addUser.getUser_name().equals(addUser11.getUser_name()) && encryptedPassword == true && addUser.getIs_admin().equals(addUser11.getIs_admin())) {
                Main main = new Main();
                main.setVisible(true);
                return true;
              } else {
                  return false;
             }
    }
}
