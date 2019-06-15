/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.objects;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author quangnd
 */
@Entity
@Table(name = "danh_sach_lop_mo_DK", catalog = "quan_ly_sinh_vien", schema = "")
@NamedQueries({
    @NamedQuery(name = "DanhsachlopmoDK.findAll", query = "SELECT d FROM DanhsachlopmoDK d")
    , @NamedQuery(name = "DanhsachlopmoDK.findByIddanhsachlopmoDK", query = "SELECT d FROM DanhsachlopmoDK d WHERE d.iddanhsachlopmoDK = :iddanhsachlopmoDK")
    , @NamedQuery(name = "DanhsachlopmoDK.findByMalopmoDK", query = "SELECT d FROM DanhsachlopmoDK d WHERE d.malopmoDK = :malopmoDK")
    , @NamedQuery(name = "DanhsachlopmoDK.findByThoiGianBatDau", query = "SELECT d FROM DanhsachlopmoDK d WHERE d.thoiGianBatDau = :thoiGianBatDau")
    , @NamedQuery(name = "DanhsachlopmoDK.findByThoiGianKetThuc", query = "SELECT d FROM DanhsachlopmoDK d WHERE d.thoiGianKetThuc = :thoiGianKetThuc")
    , @NamedQuery(name = "DanhsachlopmoDK.findByThu", query = "SELECT d FROM DanhsachlopmoDK d WHERE d.thu = :thu")
    , @NamedQuery(name = "DanhsachlopmoDK.findByTuanHoc", query = "SELECT d FROM DanhsachlopmoDK d WHERE d.tuanHoc = :tuanHoc")
    , @NamedQuery(name = "DanhsachlopmoDK.findByLoaiLop", query = "SELECT d FROM DanhsachlopmoDK d WHERE d.loaiLop = :loaiLop")
    , @NamedQuery(name = "DanhsachlopmoDK.findByIdmonhocDK", query = "SELECT d FROM DanhsachlopmoDK d WHERE d.idmonhocDK = :idmonhocDK")
    , @NamedQuery(name = "DanhsachlopmoDK.findByNhom", query = "SELECT d FROM DanhsachlopmoDK d WHERE d.nhom = :nhom")
    , @NamedQuery(name = "DanhsachlopmoDK.findByPhongHoc", query = "SELECT d FROM DanhsachlopmoDK d WHERE d.phongHoc = :phongHoc")
    , @NamedQuery(name = "DanhsachlopmoDK.findByHocKi", query = "SELECT d FROM DanhsachlopmoDK d WHERE d.hocKi = :hocKi")
    , @NamedQuery(name = "DanhsachlopmoDK.findBySoLuongDaDangKi", query = "SELECT d FROM DanhsachlopmoDK d WHERE d.soLuongDaDangKi = :soLuongDaDangKi")
    , @NamedQuery(name = "DanhsachlopmoDK.findBySoluongmaxDK", query = "SELECT d FROM DanhsachlopmoDK d WHERE d.soluongmaxDK = :soluongmaxDK")
    , @NamedQuery(name = "DanhsachlopmoDK.findByDateToExist", query = "SELECT d FROM DanhsachlopmoDK d WHERE d.dateToExist = :dateToExist")})
public class DanhsachlopmoDK implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddanh_sach_lop_mo_DK")
    private Integer iddanhsachlopmoDK;
    @Basic(optional = false)
    @Column(name = "ma_lop_mo_DK")
    private String malopmoDK;
    @Basic(optional = false)
    @Column(name = "thoi_gian_bat_dau")
    @Temporal(TemporalType.TIME)
    private Date thoiGianBatDau;
    @Basic(optional = false)
    @Column(name = "thoi_gian_ket_thuc")
    @Temporal(TemporalType.TIME)
    private Date thoiGianKetThuc;
    @Basic(optional = false)
    @Column(name = "thu")
    private String thu;
    @Basic(optional = false)
    @Column(name = "tuan_hoc")
    private String tuanHoc;
    @Basic(optional = false)
    @Column(name = "loai_lop")
    private String loaiLop;
    @Basic(optional = false)
    @Column(name = "id_mon_hoc_DK")
    private String idmonhocDK;
    @Basic(optional = false)
    @Column(name = "nhom")
    private String nhom;
    @Basic(optional = false)
    @Column(name = "phong_hoc")
    private String phongHoc;
    @Basic(optional = false)
    @Column(name = "hoc_ki")
    private String hocKi;
    @Basic(optional = false)
    @Column(name = "so_luong_da_dang_ki")
    private int soLuongDaDangKi;
    @Basic(optional = false)
    @Column(name = "so_luong_max_DK")
    private int soluongmaxDK;
    @Column(name = "date_to_exist")
    @Temporal(TemporalType.DATE)
    private Date dateToExist;

    /**
     *
     */
    public DanhsachlopmoDK() {
    }

    /**
     *
     * @param iddanhsachlopmoDK
     */
    public DanhsachlopmoDK(Integer iddanhsachlopmoDK) {
        this.iddanhsachlopmoDK = iddanhsachlopmoDK;
    }

    /**
     *
     * @param iddanhsachlopmoDK
     * @param malopmoDK
     * @param thoiGianBatDau
     * @param thoiGianKetThuc
     * @param thu
     * @param tuanHoc
     * @param loaiLop
     * @param idmonhocDK
     * @param nhom
     * @param phongHoc
     * @param hocKi
     * @param soLuongDaDangKi
     * @param soluongmaxDK
     */
    public DanhsachlopmoDK(Integer iddanhsachlopmoDK, String malopmoDK, Date thoiGianBatDau, Date thoiGianKetThuc, String thu, String tuanHoc, String loaiLop, String idmonhocDK, String nhom, String phongHoc, String hocKi, int soLuongDaDangKi, int soluongmaxDK) {
        this.iddanhsachlopmoDK = iddanhsachlopmoDK;
        this.malopmoDK = malopmoDK;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.thu = thu;
        this.tuanHoc = tuanHoc;
        this.loaiLop = loaiLop;
        this.idmonhocDK = idmonhocDK;
        this.nhom = nhom;
        this.phongHoc = phongHoc;
        this.hocKi = hocKi;
        this.soLuongDaDangKi = soLuongDaDangKi;
        this.soluongmaxDK = soluongmaxDK;
    }

    /**
     *
     * @return
     */
    public Integer getIddanhsachlopmoDK() {
        return iddanhsachlopmoDK;
    }

    /**
     *
     * @param iddanhsachlopmoDK
     */
    public void setIddanhsachlopmoDK(Integer iddanhsachlopmoDK) {
        Integer oldIddanhsachlopmoDK = this.iddanhsachlopmoDK;
        this.iddanhsachlopmoDK = iddanhsachlopmoDK;
        changeSupport.firePropertyChange("iddanhsachlopmoDK", oldIddanhsachlopmoDK, iddanhsachlopmoDK);
    }

    /**
     *
     * @return
     */
    public String getMalopmoDK() {
        return malopmoDK;
    }

    /**
     *
     * @param malopmoDK
     */
    public void setMalopmoDK(String malopmoDK) {
        String oldMalopmoDK = this.malopmoDK;
        this.malopmoDK = malopmoDK;
        changeSupport.firePropertyChange("malopmoDK", oldMalopmoDK, malopmoDK);
    }

    /**
     *
     * @return
     */
    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    /**
     *
     * @param thoiGianBatDau
     */
    public void setThoiGianBatDau(Date thoiGianBatDau) {
        Date oldThoiGianBatDau = this.thoiGianBatDau;
        this.thoiGianBatDau = thoiGianBatDau;
        changeSupport.firePropertyChange("thoiGianBatDau", oldThoiGianBatDau, thoiGianBatDau);
    }

    /**
     *
     * @return
     */
    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    /**
     *
     * @param thoiGianKetThuc
     */
    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        Date oldThoiGianKetThuc = this.thoiGianKetThuc;
        this.thoiGianKetThuc = thoiGianKetThuc;
        changeSupport.firePropertyChange("thoiGianKetThuc", oldThoiGianKetThuc, thoiGianKetThuc);
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
        String oldThu = this.thu;
        this.thu = thu;
        changeSupport.firePropertyChange("thu", oldThu, thu);
    }

    /**
     *
     * @return
     */
    public String getTuanHoc() {
        return tuanHoc;
    }

    /**
     *
     * @param tuanHoc
     */
    public void setTuanHoc(String tuanHoc) {
        String oldTuanHoc = this.tuanHoc;
        this.tuanHoc = tuanHoc;
        changeSupport.firePropertyChange("tuanHoc", oldTuanHoc, tuanHoc);
    }

    /**
     *
     * @return
     */
    public String getLoaiLop() {
        return loaiLop;
    }

    /**
     *
     * @param loaiLop
     */
    public void setLoaiLop(String loaiLop) {
        String oldLoaiLop = this.loaiLop;
        this.loaiLop = loaiLop;
        changeSupport.firePropertyChange("loaiLop", oldLoaiLop, loaiLop);
    }

    /**
     *
     * @return
     */
    public String getIdmonhocDK() {
        return idmonhocDK;
    }

    /**
     *
     * @param idmonhocDK
     */
    public void setIdmonhocDK(String idmonhocDK) {
        String oldIdmonhocDK = this.idmonhocDK;
        this.idmonhocDK = idmonhocDK;
        changeSupport.firePropertyChange("idmonhocDK", oldIdmonhocDK, idmonhocDK);
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
        String oldNhom = this.nhom;
        this.nhom = nhom;
        changeSupport.firePropertyChange("nhom", oldNhom, nhom);
    }

    /**
     *
     * @return
     */
    public String getPhongHoc() {
        return phongHoc;
    }

    /**
     *
     * @param phongHoc
     */
    public void setPhongHoc(String phongHoc) {
        String oldPhongHoc = this.phongHoc;
        this.phongHoc = phongHoc;
        changeSupport.firePropertyChange("phongHoc", oldPhongHoc, phongHoc);
    }

    /**
     *
     * @return
     */
    public String getHocKi() {
        return hocKi;
    }

    /**
     *
     * @param hocKi
     */
    public void setHocKi(String hocKi) {
        String oldHocKi = this.hocKi;
        this.hocKi = hocKi;
        changeSupport.firePropertyChange("hocKi", oldHocKi, hocKi);
    }

    /**
     *
     * @return
     */
    public int getSoLuongDaDangKi() {
        return soLuongDaDangKi;
    }

    /**
     *
     * @param soLuongDaDangKi
     */
    public void setSoLuongDaDangKi(int soLuongDaDangKi) {
        int oldSoLuongDaDangKi = this.soLuongDaDangKi;
        this.soLuongDaDangKi = soLuongDaDangKi;
        changeSupport.firePropertyChange("soLuongDaDangKi", oldSoLuongDaDangKi, soLuongDaDangKi);
    }

    /**
     *
     * @return
     */
    public int getSoluongmaxDK() {
        return soluongmaxDK;
    }

    /**
     *
     * @param soluongmaxDK
     */
    public void setSoluongmaxDK(int soluongmaxDK) {
        int oldSoluongmaxDK = this.soluongmaxDK;
        this.soluongmaxDK = soluongmaxDK;
        changeSupport.firePropertyChange("soluongmaxDK", oldSoluongmaxDK, soluongmaxDK);
    }

    /**
     *
     * @return
     */
    public Date getDateToExist() {
        return dateToExist;
    }

    /**
     *
     * @param dateToExist
     */
    public void setDateToExist(Date dateToExist) {
        Date oldDateToExist = this.dateToExist;
        this.dateToExist = dateToExist;
        changeSupport.firePropertyChange("dateToExist", oldDateToExist, dateToExist);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddanhsachlopmoDK != null ? iddanhsachlopmoDK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DanhsachlopmoDK)) {
            return false;
        }
        DanhsachlopmoDK other = (DanhsachlopmoDK) object;
        if ((this.iddanhsachlopmoDK == null && other.iddanhsachlopmoDK != null) || (this.iddanhsachlopmoDK != null && !this.iddanhsachlopmoDK.equals(other.iddanhsachlopmoDK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hust.soict.ui.admin.DanhsachlopmoDK[ iddanhsachlopmoDK=" + iddanhsachlopmoDK + " ]";
    }

    /**
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    /**
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
