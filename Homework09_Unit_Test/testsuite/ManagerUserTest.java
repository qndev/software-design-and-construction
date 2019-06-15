/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.testsuite;

import edu.hust.soict.dao.AddUserDAO;
import edu.hust.soict.logic.Check;
import edu.hust.soict.objects.AddUser;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * TestClass validation manager user (create, read, update, delete)
 *
 * @author quangnd
 */
public class ManagerUserTest {

    Check checkValidation = new Check();

    /**
     *
     */
    public ManagerUserTest() {
    }
 
    /**
     * Test case Check null user when create new User.
     */
    @Test
    public void testCheckinfo1() {
        System.out.println("# testCheckinfo1( username is null.)");
        String userName = "";
        boolean expected = false;
        boolean actual = checkValidation.checkID(userName);
        assertTrue(expected == actual);
    }

    /**
     * Test case Check null password when create new User.
     */
    @Test
    public void testCheckinfo2() {
        System.out.println("# testCheckinfo2( password is null.)");
        String password = "";
        boolean expected = false;
        boolean actual = checkValidation.checkSpace(password);
        assertTrue(expected == actual);
    }

    /** 
     * Test case Check length of username not equal 8.
     */
    @Test
    public void testCheckinfo3() {
        System.out.println("# testCheckinfo2( user is not null but user have length != 8.)");
        String userName = "test";
        boolean expected = false;
        boolean actual = checkValidation.checkID(userName);
        assertTrue(expected == actual);
    }

    /**
     * Test case check username and password regular-expression success.
     */
    @Test
    public void testCheckinfo() {
        System.out.println("# testCheckinfo( Successfully username and password)");
        String userName = "20155555";
        String password = "20155555";
        boolean expected = true;
        boolean actualUserName = checkValidation.checkID(userName);
        boolean actualPassword = checkValidation.checkSpace(password);
        assertTrue(expected == actualUserName);
        assertTrue(expected == actualPassword);
    }

    /**
     * Test case check add new user success.
     */
    @Test
    public void testAddNewUser() {
        System.out.println("# testAddNewUser( Successfully created new User!)");
        String userName = "20199999";
        String password = "20199999";
        String role = "student";
        AddUserDAO addUserDAO = new AddUserDAO();
        AddUser addUser = new AddUser(userName, password, role);
        addUserDAO.addNew(addUser);
        assertNotNull(addUser);
        assertEquals("20199999", addUser.getUser_name());
        assertEquals("20199999", addUser.getPassword());
        assertEquals("student", addUser.getIs_admin());
    }

    /**
     * Test case check delete user.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Test
    public void testDeleteUser() throws SQLException, ClassNotFoundException {
        System.out.println("# testAddNewUser( Delete new User!)");
        String userName = "20155555";
        AddUserDAO addUserDAO = new AddUserDAO();
        addUserDAO.deleteUser(userName);
    }
    
     /**
     * Test case check update user.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Test
    public void testUpdateUser() throws SQLException, ClassNotFoundException {
        System.out.println("# testUpdateUser( Update  User!)");
        String userName = "20199999";
        String password = "20199999";
        String role = "student";
        AddUser addUser = new AddUser(userName, password, role);
        AddUserDAO addUserDAO = new AddUserDAO();
        boolean expected = true;
        boolean actual = addUserDAO.updateUser2(addUser);
        assertNotNull(addUser);
        assertTrue(expected == actual);
    }
}
