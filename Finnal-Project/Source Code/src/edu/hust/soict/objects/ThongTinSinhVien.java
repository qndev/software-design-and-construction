/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.objects;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *Class auto generated when binding data table thong_tin_sinh_vien using POJO persistence, JDBC to collection DB.
 * @author quangnd
 */
@Entity
@Table(name = "thong_tin_sinh_vien", catalog = "quan_ly_sinh_vien", schema = "")
@NamedQueries({
    @NamedQuery(name = "ThongTinSinhVien.findAll", query = "SELECT t FROM ThongTinSinhVien t")
    , @NamedQuery(name = "ThongTinSinhVien.findByIdSinhVien", query = "SELECT t FROM ThongTinSinhVien t WHERE t.idSinhVien = :idSinhVien")
    , @NamedQuery(name = "ThongTinSinhVien.findByTenSinhVien", query = "SELECT t FROM ThongTinSinhVien t WHERE t.tenSinhVien = :tenSinhVien")
    , @NamedQuery(name = "ThongTinSinhVien.findByNgaySinh", query = "SELECT t FROM ThongTinSinhVien t WHERE t.ngaySinh = :ngaySinh")
    , @NamedQuery(name = "ThongTinSinhVien.findByLopHoc", query = "SELECT t FROM ThongTinSinhVien t WHERE t.lopHoc = :lopHoc")
    , @NamedQuery(name = "ThongTinSinhVien.findByChuongtrinhDT", query = "SELECT t FROM ThongTinSinhVien t WHERE t.chuongtrinhDT = :chuongtrinhDT")
    , @NamedQuery(name = "ThongTinSinhVien.findByHeHoc", query = "SELECT t FROM ThongTinSinhVien t WHERE t.heHoc = :heHoc")
    , @NamedQuery(name = "ThongTinSinhVien.findByTrangThai", query = "SELECT t FROM ThongTinSinhVien t WHERE t.trangThai = :trangThai")
    , @NamedQuery(name = "ThongTinSinhVien.findByKhoaHoc", query = "SELECT t FROM ThongTinSinhVien t WHERE t.khoaHoc = :khoaHoc")
    , @NamedQuery(name = "ThongTinSinhVien.findByDepartment", query = "SELECT t FROM ThongTinSinhVien t WHERE t.department = :department")
    , @NamedQuery(name = "ThongTinSinhVien.findByEmail", query = "SELECT t FROM ThongTinSinhVien t WHERE t.email = :email")
    , @NamedQuery(name = "ThongTinSinhVien.findByDonViTinChiHocPhi", query = "SELECT t FROM ThongTinSinhVien t WHERE t.donViTinChiHocPhi = :donViTinChiHocPhi")})
public class ThongTinSinhVien implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_sinh_vien")
    private String idSinhVien;
    @Basic(optional = false)
    @Column(name = "ten_sinh_vien")
    private String tenSinhVien;
    @Basic(optional = false)
    @Column(name = "ngay_sinh")
    private String ngaySinh;
    @Basic(optional = false)
    @Column(name = "lop_hoc")
    private String lopHoc;
    @Basic(optional = false)
    @Column(name = "chuong_trinh_DT")
    private String chuongtrinhDT;
    @Basic(optional = false)
    @Column(name = "he_hoc")
    private String heHoc;
    @Basic(optional = false)
    @Column(name = "trang_thai")
    private String trangThai;
    @Basic(optional = false)
    @Column(name = "khoa_hoc")
    private String khoaHoc;
    @Basic(optional = false)
    @Column(name = "department")
    private String department;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "don_vi_tin_chi_hoc_phi")
    private float donViTinChiHocPhi;

    /**
     *
     */
    public ThongTinSinhVien() {
    }

    /**
     *
     * @param idSinhVien
     */
    public ThongTinSinhVien(String idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    /**
     *
     * @param idSinhVien
     * @param tenSinhVien
     * @param ngaySinh
     * @param lopHoc
     * @param chuongtrinhDT
     * @param heHoc
     * @param trangThai
     * @param khoaHoc
     * @param department
     * @param email
     * @param donViTinChiHocPhi
     */
    public ThongTinSinhVien(String idSinhVien, String tenSinhVien, String ngaySinh, String lopHoc, String chuongtrinhDT, String heHoc, String trangThai, String khoaHoc, String department, String email, float donViTinChiHocPhi) {
        this.idSinhVien = idSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.ngaySinh = ngaySinh;
        this.lopHoc = lopHoc;
        this.chuongtrinhDT = chuongtrinhDT;
        this.heHoc = heHoc;
        this.trangThai = trangThai;
        this.khoaHoc = khoaHoc;
        this.department = department;
        this.email = email;
        this.donViTinChiHocPhi = donViTinChiHocPhi;
    }

    /**
     *
     * @return
     */
    public String getIdSinhVien() {
        return idSinhVien;
    }

    /**
     *
     * @param idSinhVien
     */
    public void setIdSinhVien(String idSinhVien) {
        String oldIdSinhVien = this.idSinhVien;
        this.idSinhVien = idSinhVien;
        changeSupport.firePropertyChange("idSinhVien", oldIdSinhVien, idSinhVien);
    }

    /**
     *
     * @return
     */
    public String getTenSinhVien() {
        return tenSinhVien;
    }

    /**
     *
     * @param tenSinhVien
     */
    public void setTenSinhVien(String tenSinhVien) {
        String oldTenSinhVien = this.tenSinhVien;
        this.tenSinhVien = tenSinhVien;
        changeSupport.firePropertyChange("tenSinhVien", oldTenSinhVien, tenSinhVien);
    }

    /**
     *
     * @return
     */
    public String getNgaySinh() {
        return ngaySinh;
    }

    /**
     *
     * @param ngaySinh
     */
    public void setNgaySinh(String ngaySinh) {
        String oldNgaySinh = this.ngaySinh;
        this.ngaySinh = ngaySinh;
        changeSupport.firePropertyChange("ngaySinh", oldNgaySinh, ngaySinh);
    }

    /**
     *
     * @return
     */
    public String getLopHoc() {
        return lopHoc;
    }

    /**
     *
     * @param lopHoc
     */
    public void setLopHoc(String lopHoc) {
        String oldLopHoc = this.lopHoc;
        this.lopHoc = lopHoc;
        changeSupport.firePropertyChange("lopHoc", oldLopHoc, lopHoc);
    }

    /**
     *
     * @return
     */
    public String getChuongtrinhDT() {
        return chuongtrinhDT;
    }

    /**
     *
     * @param chuongtrinhDT
     */
    public void setChuongtrinhDT(String chuongtrinhDT) {
        String oldChuongtrinhDT = this.chuongtrinhDT;
        this.chuongtrinhDT = chuongtrinhDT;
        changeSupport.firePropertyChange("chuongtrinhDT", oldChuongtrinhDT, chuongtrinhDT);
    }

    /**
     *
     * @return
     */
    public String getHeHoc() {
        return heHoc;
    }

    /**
     *
     * @param heHoc
     */
    public void setHeHoc(String heHoc) {
        String oldHeHoc = this.heHoc;
        this.heHoc = heHoc;
        changeSupport.firePropertyChange("heHoc", oldHeHoc, heHoc);
    }

    /**
     *
     * @return
     */
    public String getTrangThai() {
        return trangThai;
    }

    /**
     *
     * @param trangThai
     */
    public void setTrangThai(String trangThai) {
        String oldTrangThai = this.trangThai;
        this.trangThai = trangThai;
        changeSupport.firePropertyChange("trangThai", oldTrangThai, trangThai);
    }

    /**
     *
     * @return
     */
    public String getKhoaHoc() {
        return khoaHoc;
    }

    /**
     *
     * @param khoaHoc
     */
    public void setKhoaHoc(String khoaHoc) {
        String oldKhoaHoc = this.khoaHoc;
        this.khoaHoc = khoaHoc;
        changeSupport.firePropertyChange("khoaHoc", oldKhoaHoc, khoaHoc);
    }

    /**
     *
     * @return
     */
    public String getDepartment() {
        return department;
    }

    /**
     *
     * @param department
     */
    public void setDepartment(String department) {
        String oldDepartment = this.department;
        this.department = department;
        changeSupport.firePropertyChange("department", oldDepartment, department);
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    /**
     *
     * @return
     */
    public float getDonViTinChiHocPhi() {
        return donViTinChiHocPhi;
    }

    /**
     *
     * @param donViTinChiHocPhi
     */
    public void setDonViTinChiHocPhi(float donViTinChiHocPhi) {
        float oldDonViTinChiHocPhi = this.donViTinChiHocPhi;
        this.donViTinChiHocPhi = donViTinChiHocPhi;
        changeSupport.firePropertyChange("donViTinChiHocPhi", oldDonViTinChiHocPhi, donViTinChiHocPhi);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSinhVien != null ? idSinhVien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThongTinSinhVien)) {
            return false;
        }
        ThongTinSinhVien other = (ThongTinSinhVien) object;
        if ((this.idSinhVien == null && other.idSinhVien != null) || (this.idSinhVien != null && !this.idSinhVien.equals(other.idSinhVien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hust.soict.ui.student.ThongTinSinhVien[ idSinhVien=" + idSinhVien + " ]";
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
