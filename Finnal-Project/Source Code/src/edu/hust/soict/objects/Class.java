/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.objects;

/**
 *Constructor, getter, setter Object User(define properties, methods of Class to Register).
 * @author quangnd
 */
public class Class {
    private String ma_lop_DK;
    private String bat_dau;
    private String ket_thuc;
    private String thu;
    private String tuan_hoc;
    private String loai_lop;
    private String ma_mon_hoc;
    private String nhom;
    private String phong_hoc;
    private String da_DK;
    private String max_DK;

    /**
     *
     */
    public Class() {
    }

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
     * @param da_DK
     * @param max_DK
     */
    public Class(String ma_lop_DK, String bat_dau, String ket_thuc, String thu, String tuan_hoc, String loai_lop, String ma_mon_hoc, String nhom, String phong_hoc, String da_DK, String max_DK) {
        this.ma_lop_DK = ma_lop_DK;
        this.bat_dau = bat_dau;
        this.ket_thuc = ket_thuc;
        this.thu = thu;
        this.tuan_hoc = tuan_hoc;
        this.loai_lop = loai_lop;
        this.ma_mon_hoc = ma_mon_hoc;
        this.nhom = nhom;
        this.phong_hoc = phong_hoc;
        this.da_DK = da_DK;
        this.max_DK = max_DK;
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
    public String getDa_DK() {
        return da_DK;
    }

    /**
     *
     * @param da_DK
     */
    public void setDa_DK(String da_DK) {
        this.da_DK = da_DK;
    }

    /**
     *
     * @return
     */
    public String getMax_DK() {
        return max_DK;
    }

    /**
     *
     * @param max_DK
     */
    public void setMax_DK(String max_DK) {
        this.max_DK = max_DK;
    }

    @Override
    public String toString() {
        return "Class{" + "ma_lop_DK=" + ma_lop_DK + ", bat_dau=" + bat_dau + ", ket_thuc=" + ket_thuc + ", thu=" + thu + ", tuan_hoc=" + tuan_hoc + ", loai_lop=" + loai_lop + ", ma_mon_hoc=" + ma_mon_hoc + ", nhom=" + nhom + ", phong_hoc=" + phong_hoc + ", da_DK=" + da_DK + ", max_DK=" + max_DK + '}';
    }
    
}
