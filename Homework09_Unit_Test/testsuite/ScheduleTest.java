/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.testsuite;

import edu.hust.soict.dao.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Class test search schedule for student.
 * @author quangnd
 */
public class ScheduleTest {

    PreparedStatement ps;
    ResultSet rs;

    /**
     *
     */
    public ScheduleTest() {
    }

    /**
     * Test case Schedule with function search information.
     * @throws java.sql.SQLException
     */
    @Test
    public void testFetchData() throws SQLException {
        System.out.println("# testFetchData( Compare list from database and method fetchData() to search information ).");
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add(0, "20146574");
        expectedList.add(1, "104426");
        expectedList.add(2, "FL1010");
        expectedList.add(3, "Tiếng Anh I");
        expectedList.add(4, "2");
        expectedList.add(5, "06:45:00");
        expectedList.add(6, "09:30:00");
        expectedList.add(7, "D6-308");
        expectedList.add(8, "20146574");
        expectedList.add(9, "104429");
        expectedList.add(10, "IT3680");
        expectedList.add(11, "Thuật toán ứng dụng");
        expectedList.add(12, "4");
        expectedList.add(13, "15:15:00");
        expectedList.add(14, "17:30:00");
        expectedList.add(15, "TC-504");
        if (DBConnect.open()) {
            String sql = "SELECT * FROM information_student_register WHERE id_sinh_vien_DK='20146574'";
            ps = DBConnect.cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            ArrayList<String> actualList = new ArrayList<>(columnCount);
            while (rs.next()) {
                int i = 1;
                while (i <= columnCount) {
                    actualList.add(rs.getString(i++));
                }
            }
            assertArrayEquals(expectedList.toArray(), actualList.toArray());
            assertTrue(expectedList.equals(actualList));
            if(expectedList.equals(actualList)){
                System.out.println("Expected list from database and actual list of result when excute fetchData() method matched.");
            }
        }
    }
}
