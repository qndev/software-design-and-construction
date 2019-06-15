/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.objects;

/**
 *Constructor, getter, setter Object Detail of Courses(define properties, methods).
 * @author quangnd
 */
public class Register {
    private String idDKLop;
    private String maSinhVienDK;
    private String maLopDK;

    /**
     *
     */
    public Register() {
    }

    /**
     *
     * @param idDKLop
     * @param maSinhVienDK
     * @param maLopDK
     */
    public Register(String idDKLop, String maSinhVienDK, String maLopDK) {
        this.idDKLop = idDKLop;
        this.maSinhVienDK = maSinhVienDK;
        this.maLopDK = maLopDK;
    }

    /**
     *
     * @param maSinhVienDK
     * @param maLopDK
     */
    public Register(String maSinhVienDK, String maLopDK) {
        this.maSinhVienDK = maSinhVienDK;
        this.maLopDK = maLopDK;
    }
    
    /**
     *
     * @return
     */
    public String getIdDKLop() {
        return idDKLop;
    }

    /**
     *
     * @param idDKLop
     */
    public void setIdDKLop(String idDKLop) {
        this.idDKLop = idDKLop;
    }

    /**
     *
     * @return
     */
    public String getMaSinhVienDK() {
        return maSinhVienDK;
    }

    /**
     *
     * @param maSinhVienDK
     */
    public void setMaSinhVienDK(String maSinhVienDK) {
        this.maSinhVienDK = maSinhVienDK;
    }

    /**
     *
     * @return
     */
    public String getMaLopDK() {
        return maLopDK;
    }

    /**
     *
     * @param maLopDK
     */
    public void setMaLopDK(String maLopDK) {
        this.maLopDK = maLopDK;
    }

    @Override
    public String toString() {
        return "Register{" + "idDKLop=" + idDKLop + ", maSinhVienDK=" + maSinhVienDK + ", maLopDK=" + maLopDK + '}';
    }

  


    
}
