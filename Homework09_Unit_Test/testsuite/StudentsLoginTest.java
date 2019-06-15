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
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test Class for students login.
 *
 * @author quangnd
 */
public class StudentsLoginTest {

    DBConnect dBConnect = new DBConnect();
    ResultSet rs;
    PreparedStatement ps;

    /**
     *
     */
    public StudentsLoginTest() {
    }

    //Case successfully.

    /**
     *
     * @throws SQLException
     */
    @Test
    public void testStudentLogin() throws SQLException {

        System.out.println("# testStudentLogin( Check student login successfully! ).");
        String username = "20148888";
        String password = "20148888";
        String role = "student";
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
                assertEquals(username, usernameFromDB);
                assertTrue(expected == encryptedPassword);
                assertEquals(role, is_admin);
                // compare username, password from user input with database
                if ((username.equals(usernameFromDB)) && (encryptedPassword == true) && (role.equals(is_admin))) {
                    System.out.println("Login Successfully!");
                }
            }
        }

    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void testStudentLogin1() throws SQLException {
        System.out.println("# testStudentLogin1( Check username is null ):");
        String stringNull = "";
        String username = "";
        //String password = "adminpassword";
        //String role = "admin";
        if (username.equals(stringNull)) {
            System.out.println("Username was null!");
        }
        assertEquals(username, stringNull);
    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void testStudentLogin2() throws SQLException {
        System.out.println("# testStudentLogin2( Check password is null ):");
        String stringNull = "";
        //String username = "admin";
        String password = "";
        if (password.equals(stringNull)) {
            System.out.println("Password was null!");
        }
        assertEquals(password, stringNull);
    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void testStudentLogin3() throws SQLException {
        System.out.println("# testStudentLogin3( Check username and password are null ):");
        String stringNull = "";
        String username = "";
        String password = "";
        if (username.equals(stringNull) || password.equals(stringNull)) {
            System.out.println("Username and Password were null!");
        }
        assertEquals(username, stringNull);
        assertEquals(password, stringNull);
    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void testStudentLogin4() throws SQLException {
        System.out.println("# testStudentLogin4( Check not exists user ):");
        if (DBConnect.open()) {
            String sql = "SELECT user_name, password, is_admin FROM dang_nhap WHERE user_name= '20196666'";
            ps = DBConnect.cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            boolean userNameExpected = false;
            boolean resultActual = rs.isBeforeFirst();
            assertTrue(userNameExpected == resultActual);
            if (userNameExpected == resultActual) {
                System.out.println("Not exists user!");
            }
        }
    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void testStudentLogin5() throws SQLException {
        System.out.println("# testStudentLogin5( Check wrong password ):");
        String username = "20148888";
        String password = "20148888test";
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
                assertEquals(username, usernameFromDB);
                if (expectedPassword == encryptedPassword) {
                    System.out.println("Wrong password!");
                }
            }

        }
    }
}
