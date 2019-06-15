/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.objects;

import java.sql.Date;
/**
 *
 * @author quangnd
 */
public class MakeCourses {

    private String ma_lop_DK;
    private String bat_dau;
    private String ket_thuc;
    private String thu;
    private String tuan_hoc;
    private String loai_lop;
    private String ma_mon_hoc;
    private String nhom;
    private String phong_hoc;
    private Integer max_DK;
    private String hoc_ki;
    private Date thoi_han_DK;

    /**
     *
     * @param ma_lop_DK
     * @param bat_dau
     * @param ket_thuc
     * @param thu
     * @param tuan_hoc
     * @param loai_lop
     * @param ma_mon_hoc
     * @param nhom
     * @param phong_hoc
     * @param max_DK
     * @param hoc_ki
     * @param thoi_han_DK
     */
    public MakeCourses(String ma_lop_DK, String bat_dau, String ket_thuc, String thu, String tuan_hoc, String loai_lop, String ma_mon_hoc, String nhom, String phong_hoc, Integer max_DK, String hoc_ki, Date thoi_han_DK) {
        this.ma_lop_DK = ma_lop_DK;
        this.bat_dau = bat_dau;
        this.ket_thuc = ket_thuc;
        this.thu = thu;
        this.tuan_hoc = tuan_hoc;
        this.loai_lop = loai_lop;
        this.ma_mon_hoc = ma_mon_hoc;
        this.nhom = nhom;
        this.phong_hoc = phong_hoc;
        this.max_DK = max_DK;
        this.hoc_ki = hoc_ki;
        this.thoi_han_DK = thoi_han_DK;
    }

    /**
     *
     */
    public MakeCourses() {
    }

    /**
     *
     * @return
     */
    public String getMa_lop_DK() {
        return ma_lop_DK;
    }

    /**
     *
     * @param ma_lop_DK
     */
    public void setMa_lop_DK(String ma_lop_DK) {
        this.ma_lop_DK = ma_lop_DK;
    }

    /**
     *
     * @return
     */
    public String getBat_dau() {
        return bat_dau;
    }

    /**
     *
     * @param bat_dau
     */
    public void setBat_dau(String bat_dau) {
        this.bat_dau = bat_dau;
    }

    /**
     *
     * @return
     */
    public String getKet_thuc() {
        return ket_thuc;
    }

    /**
     *
     * @param ket_thuc
     */
    public void setKet_thuc(String ket_thuc) {
        this.ket_thuc = ket_thuc;
    }

    /**
     *
     * @return
     */
    public String getThu() {
        return thu;
    }

    /**
     *
     * @param thu
     */
    public void setThu(String thu) {
        this.thu = thu;
    }

    /**
     *
     * @return
     */
    public String getTuan_hoc() {
        return tuan_hoc;
    }

    /**
     *
     * @param tuan_hoc
     */
    public void setTuan_hoc(String tuan_hoc) {
        this.tuan_hoc = tuan_hoc;
    }

    /**
     *
     * @return
     */
    public String getLoai_lop() {
        return loai_lop;
    }

    /**
     *
     * @param loai_lop
     */
    public void setLoai_lop(String loai_lop) {
        this.loai_lop = loai_lop;
    }

    /**
     *
     * @return
     */
    public String getMa_mon_hoc() {
        return ma_mon_hoc;
    }

    /**
     *
     * @param ma_mon_hoc
     */
    public void setMa_mon_hoc(String ma_mon_hoc) {
        this.ma_mon_hoc = ma_mon_hoc;
    }

    /**
     *
     * @return
     */
    public String getNhom() {
        return nhom;
    }

    /**
     *
     * @param nhom
     */
    public void setNhom(String nhom) {
        this.nhom = nhom;
    }

    /**
     *
     * @return
     */
    public String getPhong_hoc() {
        return phong_hoc;
    }

    /**
     *
     * @param phong_hoc
     */
    public void setPhong_hoc(String phong_hoc) {
        this.phong_hoc = phong_hoc;
    }

    /**
     *
     * @return
     */
    public Integer getMax_DK() {
        return max_DK;
    }

    /**
     *
     * @param max_DK
     */
    public void setMax_DK(Integer max_DK) {
        this.max_DK = max_DK;
    }

    /**
     *
     * @return
     */
    public String getHoc_ki() {
        return hoc_ki;
    }

    /**
     *
     * @param hoc_ki
     */
    public void setHoc_ki(String hoc_ki) {
        this.hoc_ki = hoc_ki;
    }

    /**
     *
     * @return
     */
    public Date getThoi_han_DK() {
        return thoi_han_DK;
    }

    /**
     *
     * @param thoi_han_DK
     */
    public void setThoi_han_DK(Date thoi_han_DK) {
        this.thoi_han_DK = thoi_han_DK;
    }



    
}
