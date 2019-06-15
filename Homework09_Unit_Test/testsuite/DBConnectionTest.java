/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.testsuite;

import edu.hust.soict.dao.DBConnect;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Test class connect to database.
 * @author quangnd
 */
public class DBConnectionTest {

    /**
     *
     */
    public DBConnectionTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//    @Test
//    public void testOpen1() throws SQLException {
//        System.out.println("# testOpen( check connection to database )");
//        DBConnect dBConnect = new DBConnect();
//        boolean expected = true;
//        boolean actual = dBConnect.open();
//        //assertTrue(expected == actual);
//        if (expected == actual) {
//            System.out.println("Connect successfully!");
//        } else {
//            System.out.println("Connect failed!");
//        }
//    }
    
    /**
     * Test case check connect to database success.
     * @throws java.sql.SQLException
     */
    @Test
    public void testOpen() throws SQLException {
        System.out.println("# testOpen( check connection to database )");
        DBConnect dBConnect = new DBConnect();
        boolean expected = true;
        boolean actual = dBConnect.open();
        assertTrue(expected == actual);
        if (expected == actual) {
            System.out.println("Connected successfully!");
        }
    }

    /**
     * Test case check connect to database failed.
     * @throws java.sql.SQLException
     */
    @Test
    public void testOpenFailed() throws SQLException {
        System.out.println("# testOpenFailed( check connection to database )");
        DBConnect dBConnect = new DBConnect();
        boolean expected = false;
        boolean actual = dBConnect.open();
        assertTrue(expected == actual);
        if (expected == actual) {
            System.out.println("Connected Failed!");
        }
    }
}
