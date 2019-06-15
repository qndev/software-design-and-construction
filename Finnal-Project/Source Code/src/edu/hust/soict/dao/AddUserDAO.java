/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.dao;

import static edu.hust.soict.dao.DBConnect.cnn;
import edu.hust.soict.objects.AddUser;
import edu.hust.soict.ui.admin.Main;
import edu.hust.soict.ui.admin.ManagerUser;
import edu.hust.soict.logic.PasswordUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Class Data Access Object of Users(all about method CRUD).
 *
 * @author quangnd
 */
public class AddUserDAO implements InterfaceAddUserDAO {

    Main main = new Main();

    public ArrayList<AddUser> getAccount(String userName) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<AddUser> list = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT user_name, password, is_admin FROM dang_nhap WHERE user_name=?");
                ps.setString(1, userName);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                if (rs.first()) {
                    AddUser addUser = new AddUser();
                    addUser.setUser_name(rs.getString(1));
                    addUser.setPassword(rs.getString(2));
                    addUser.setIs_admin(rs.getString(3));
                    list.add(addUser);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    public AddUser getAdminAccount(AddUser user) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT user_name, password, is_admin FROM dang_nhap WHERE user_name=?");
                ps.setString(1, user.getUser_name());
                rs = ps.executeQuery();
                if (rs.first()) {
                    AddUser addUser  = new AddUser();
                    addUser.setUser_name(rs.getString(1));
                    addUser.setPassword(rs.getString(2));
                    addUser.setIs_admin(rs.getString(3));
                    return addUser;
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return null;
    }

    /**
     *
     * @return list- list of users.
     */
    @Override
    public ArrayList<AddUser> getAll() {
        ArrayList<AddUser> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT user_name, password, is_admin FROM dang_nhap");
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    AddUser addUser = new AddUser();
                    addUser.setUser_name(rs.getString(1));
                    addUser.setPassword(rs.getString(2));
                    addUser.setIs_admin(rs.getString(3));
                    list.add(addUser);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;

    }

    /**
     *
     * @param user
     * @return
     */
    @Override
    public boolean addNew(AddUser user) {

        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("INSERT INTO dang_nhap(user_name, password, is_admin) VALUES (?,?,?)");
                String encryptedPassword = PasswordUtils.encryptPassword(user.getPassword());
                ps.setString(1, user.getUser_name());
                ps.setString(2, encryptedPassword);
                ps.setString(3, user.getIs_admin());
                int i = ps.executeUpdate();
                if (i == 1) {
//                    JOptionPane.showMessageDialog(main, "Đã tạo thành công User: " + user.getUser_name() + "!", "Thông báo!",
//                            JOptionPane.INFORMATION_MESSAGE);
                 return true;
                }
            } catch (SQLException ex) {
                //Logger.getLogger(AddUserDAO.class.getName()).log(Level.SEVERE, null, ex);
                String sqlMessage = ex.getMessage();
                String sqlState = ex.getSQLState();
                int vendorCode = ex.getErrorCode();
                System.err.println("SQLException:");
                System.err.println("ERROR code: " + vendorCode);
                System.err.println("SQL state: " + sqlState);
                System.err.println("Message: " + sqlMessage + "\n----------------");
                if (vendorCode == 1062) {
                    return false;
                    //JOptionPane.showMessageDialog(this.main, "Bạn không thể tạo mới được User" + "\n" + "Do user " + user.getUser_name() + " đã tồn tại!", "Thông báo!", JOptionPane.WARNING_MESSAGE);
                } else {
                    //JOptionPane.showMessageDialog(this.main, "Đã có lỗi xảy ra, vui lòng thử lại!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } finally {
                DBConnect.close(ps);
            }
        }
        return false;
    }

    /**
     *
     * @param theUser
     * @return
     * @throws Exception
     */
    public AddUser addUser(AddUser theUser) throws Exception {
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = cnn.prepareStatement("insert into dang_nhap"
                    + "(user_name, password, name, email, is_admin)"
                    + "values (?, ?, ?, ?, ?)");
            // encrypt password
            String encryptedPassword = PasswordUtils.encryptPassword(theUser.getPassword());
            myStmt.setString(1, theUser.getUser_name());
            myStmt.setString(2, encryptedPassword);
            myStmt.setString(3, theUser.getIs_admin());
            // execute SQL
            myStmt.executeUpdate();

        } finally {
            DBConnect.close(myStmt);
        }
        return null;

    }

    /**
     *
     * @param tenDangNhap
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void deleteUser(String tenDangNhap) throws SQLException, ClassNotFoundException {

        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from dang_nhap where user_name = ?");
            ps.setString(1, tenDangNhap);
            int i = ps.executeUpdate();
            if (i == 1) {
                JOptionPane.showMessageDialog(main, "Đã xóa thành công User: " + tenDangNhap + "!", "Thông báo!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            DBConnect.close();
        }
    }

    /**
     *
     * @param user
     * @return
     */
    @Override
    public boolean updateUser2(AddUser user) {

        if (DBConnect.open()) {
            PreparedStatement ps = null;
            try {
                ps = cnn.prepareStatement("UPDATE dang_nhap SET password=? WHERE user_name=?");
                String encryptedPassword = PasswordUtils.encryptPassword(user.getPassword());
                ps.setString(1, encryptedPassword);
                ps.setString(2, user.getUser_name());
                int i = ps.executeUpdate();
                if (i == 1) {
                    return true;
                }else{
                return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps);
            }
        }
        return false;
    }

    /**
     *
     * @param tendangnhap
     * @return
     */
    @Override
    public ArrayList<AddUser> checkID(String tendangnhap) {
        ArrayList<AddUser> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select user_name, password, is_admin"
                        + "from dang_nhap where user_name=?");
                psCheck.setString(1, tendangnhap);
                rs = psCheck.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    AddUser user = new AddUser();
                    user.setUser_name(rs.getString(1));
                    list.add(user);

                }
            } catch (SQLException ex) {
                Logger.getLogger(AddUserDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(psCheck, rs);
            }
        }
        return list;

    }

    /**
     *
     * @param tenDN
     * @return
     */
    @Override
    public ArrayList<AddUser> findUserName(String tenDN) {

        ArrayList<AddUser> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select user_name, password, is_admin from dang_nhap where user_name =?");
                ps.setString(1, tenDN);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    AddUser user = new AddUser();
                    user.setUser_name(rs.getString(1));
                    user.setPassword(rs.getString(2));
                    user.setIs_admin(rs.getString(3));
                    list.add(user);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddUserDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;

    }

    /**
     *
     * @param theUser
     * @return
     * @throws Exception
     */
    public boolean authenticate(AddUser theUser) throws Exception {
        boolean result = false;

        String plainTextPassword = theUser.getPassword();

        // get the encrypted password from database for this user
        String encryptedPasswordFromDatabase = getEncrpytedPassword(theUser.getPassword());

        // compare the passwords
        result = PasswordUtils.checkPassword(plainTextPassword, encryptedPasswordFromDatabase);

        return result;
    }

    private String getEncrpytedPassword(String user_name) throws Exception {
        String encryptedPassword = null;

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = cnn.createStatement();
            myRs = myStmt.executeQuery("select password from dang_nhap where user_name=" + user_name);

            if (myRs.next()) {
                encryptedPassword = myRs.getString("password");
            } else {
                throw new Exception("User id not found: " + user_name);
            }

            return encryptedPassword;
        } finally {
            DBConnect.close(myStmt, myRs);
        }
    }

    /**
     *
     * @param user
     * @throws Exception
     */
    public void changePassword(AddUser user) throws Exception {

        // get plain text password
        String plainTextPassword = user.getPassword();
        // encrypt the password
        String encryptedPassword = PasswordUtils.encryptPassword(plainTextPassword);
        // update the password in the database
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = cnn.prepareStatement("UPDATE dang_nhap" + " SET password=?" + " WHERE user_name=?");

            // set params
            myStmt.setString(1, encryptedPassword);
            myStmt.setString(2, user.getUser_name());

            // execute SQL
            myStmt.executeUpdate();

        } finally {
            DBConnect.close(myStmt);
        }

    }

    /**
     *
     */
    public void update() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnect.cnn.prepareStatement("select * from dang_nhap");
            rs = ps.executeQuery();

        } catch (SQLException e) {
        }
    }

    @Override
    public AddUser updateByID(AddUser user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param rs
     * @return
     */
    @Override
    public AddUser extractUserFromResultSet(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
