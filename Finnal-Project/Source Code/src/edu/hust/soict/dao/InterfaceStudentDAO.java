/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.dao;

import edu.hust.soict.objects.Student;
import java.util.ArrayList;

/**
 *
 * @author quangnd
 */
public interface InterfaceStudentDAO {

    /**
     *
     * @return
     */
    public ArrayList<Student> getAll();

    /**
     *
     * @param maSV
     * @return
     */
    public ArrayList<Student> findByIDStudent(String maSV);

    /**
     *
     * @param sv
     * @return
     */
    public boolean addNew(Student sv);

    /**
     *
     * @param sv
     * @return
     */
    public boolean updateByID(Student sv);

    /**
     *
     * @param masv
     * @return
     */
    public ArrayList<Student> checkID(String masv);
}
