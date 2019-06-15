/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.testsuite;

import edu.hust.soict.dao.AddUserDAO;
import edu.hust.soict.dao.DBConnect;
import edu.hust.soict.objects.AddUser;
import edu.hust.soict.util.PasswordUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test class check validation change password of student.
 *
 * @author quangnd
 */
public class ChangePasswordTest {

    PreparedStatement ps;
    ResultSet rs;

    /**
     *
     */
    public ChangePasswordTest() {
    }

    /**
     * Test case change password successfully.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Test
    public void testChangePasswordUser() throws SQLException, ClassNotFoundException {
        System.out.println("# testChangePasswordUser( Change password ).");
        boolean expected = true;
        String userName = "20148888";
        String oldPassword = "20148888testchange";
        String newPassword = "20148888";
        String role = "student";
        if (DBConnect.open()) {
            String sql = "SELECT password FROM dang_nhap WHERE user_name = '20148888'";
            ps = DBConnect.cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.first()) {
                String getPasswordDatabase = rs.getString("password");
                boolean encryptedPassword = PasswordUtils.checkPassword(oldPassword, getPasswordDatabase);
                if (encryptedPassword == true) {
                    AddUser updateUser = new AddUser(userName, newPassword, role);
                    //actual value
                    boolean updated = new AddUserDAO().updateUser2(updateUser);
                    assertTrue(expected == updated);
                    if (expected == updated) {
                        System.out.println("Changed password successfully!");
                    }
                }
            }

        }
        ps.close();
    }

    /**
     * Test case Old password not match or null.
     * @throws java.sql.SQLException
     */
    @Test
    public void testChangePasswordUser1() throws SQLException {
        System.out.println("# testChangePasswordUser1( Old password ).");
        boolean expected = false;
        String oldPassword = "20148888testnotmatch";
        if (DBConnect.open()) {
            String sql = "SELECT password FROM dang_nhap WHERE user_name = '20148888'";
            ps = DBConnect.cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.first()) {
                String getPasswordDatabase = rs.getString("password");
                boolean encryptedPassword = PasswordUtils.checkPassword(oldPassword, getPasswordDatabase);
                if (encryptedPassword == false) {
                    System.out.println("Old password not match or null!");
                }
                assertTrue(expected == encryptedPassword);
            }

        }
        ps.close();
    }

    /**
     * Test case New password not match or null.
     */
    @Test
    public void testChangePasswordUser2() {
        System.out.println("# testChangePasswordUser2( New password not match ).");
        boolean expected = true;
        String newPassword = "matchpassword";
        String confirmPassword = "notmatchpassword";
        boolean actual = !newPassword.equals(confirmPassword);
        assertEquals(expected, actual);
        if (!newPassword.equals(confirmPassword)) {
            System.out.println("Password not match between newPassword and confirmPassword!");
        }
    }
}
