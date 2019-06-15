/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.testsuite;

import edu.hust.soict.dao.DBConnect;
import edu.hust.soict.util.PasswordUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author quangnd
 */
public class AdminLoginTest {

    DBConnect dBConnect = new DBConnect();
    ResultSet rs;
    PreparedStatement ps;

    /**
     *
     */
    public AdminLoginTest() {
    }

    /**
     * Test case check admin login success.
     * @throws java.sql.SQLException
     */
    @Test
    public void testSend() throws SQLException {
        System.out.println("# testSend( true username and password ): ");
        String username = "admin";
        String password = "admin";
        String role = "admin";
        if (dBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("SELECT * FROM dang_nhap WHERE user_name=?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.first()) {
                boolean expected = true;
                //get username from database
                String usernameFromDB = rs.getString(1);
                //get password from database
                String getPasswordDatabase = rs.getString(2);
                //compare input password with password from database
                boolean encryptedPassword = PasswordUtils.checkPassword(password, getPasswordDatabase);
                //get role of user
                String is_admin = rs.getString(3);
                // compare username, password from user input with database
                if ((username.equals(usernameFromDB)) && (encryptedPassword == true) && (role.equals(is_admin))) {
                    System.out.println("Login Successfully!");
                }
                assertEquals(username, usernameFromDB);
                assertTrue(expected == encryptedPassword);
                assertEquals(role, is_admin);
            }
        }
    }

    /**
     * Test case check admin login with null username.
     * @throws java.sql.SQLException
     */
    @Test
    public void testSend1() throws SQLException {
        System.out.println("# testSend1( username is null ):");
        String stringNull = "";
        String username = "";
        //String password = "adminpassword";
        //String role = "admin";
        if (username.equals(stringNull)) {
            System.out.println("Tên đăng nhập không được trống!");
        }
        assertEquals(username, stringNull);
    }

    /**
     * Test case check admin login with null password.
     * @throws java.sql.SQLException
     */
    @Test
    public void testSend2() throws SQLException {
        System.out.println("# testSend2( password is null ):");
        String stringNull = "";
        //String username = "admin";
        String password = "";
        if (password.equals(stringNull)) {
            System.out.println("Mật khẩu không được trống!");
        }
        assertEquals(password, stringNull);
    }

    /**
     * Test case check admin login with null username and password.
     * @throws java.sql.SQLException
     */
    @Test
    public void testSend3() throws SQLException {
        System.out.println("# testSend3( username and password are null ):");
        String stringNull = "";
        String username = "";
        String password = "";
        if (username.equals(stringNull) || password.equals(stringNull)) {
            System.out.println("Mật khẩu va password không được trống!");
        }
        assertEquals(username, stringNull);
        assertEquals(password, stringNull);
    }

    /**
     * Test case check admin login with not exists user in database.
     * @throws java.sql.SQLException
     */
    @Test
    public void testSend4() throws SQLException {
        System.out.println("# testSend4( not exists user ):");

        //String password = "testadmin";
        if (DBConnect.open()) {
            String sql = "SELECT user_name, password, is_admin FROM dang_nhap WHERE user_name= 'admin1'";
            ps = DBConnect.cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            boolean userNameExpected = false;
            boolean resultActual = rs.isBeforeFirst();
            assertTrue(userNameExpected == resultActual);
            if (userNameExpected == resultActual) {
                System.out.println("Không tồn tại User!");
            }
        }
    }

    /**
     * Test case admin login wrong password.
     * @throws java.sql.SQLException
     */
    @Test
    public void testSend5() throws SQLException {
        System.out.println("# testSend5( wrong password ):");
        String username = "admin";
        String password = "testadmin";
        if (dBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("SELECT * FROM dang_nhap WHERE user_name=?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.first()) {
                //get username from database
                String usernameFromDB = rs.getString(1);
                //get password from database
                String getPasswordDatabase = rs.getString(2);
                boolean expectedPassword = false;
                //compare input password with password from database
                boolean encryptedPassword = PasswordUtils.checkPassword(password, getPasswordDatabase);
                assertTrue(expectedPassword == encryptedPassword);
                if (expectedPassword == encryptedPassword) {
                    System.out.println("Wrong password!");
                }
            }

        }
    }
}
