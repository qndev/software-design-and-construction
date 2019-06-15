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
 *
 * @author quangnd
 */
@Entity
@Table(name = "mon_hoc", catalog = "quan_ly_sinh_vien", schema = "")
@NamedQueries({
    @NamedQuery(name = "MonHoc.findAll", query = "SELECT m FROM MonHoc m")
    , @NamedQuery(name = "MonHoc.findByIdMonHoc", query = "SELECT m FROM MonHoc m WHERE m.idMonHoc = :idMonHoc")
    , @NamedQuery(name = "MonHoc.findByTenMonHoc", query = "SELECT m FROM MonHoc m WHERE m.tenMonHoc = :tenMonHoc")
    , @NamedQuery(name = "MonHoc.findByThoiLuong", query = "SELECT m FROM MonHoc m WHERE m.thoiLuong = :thoiLuong")
    , @NamedQuery(name = "MonHoc.findBySoTinChi", query = "SELECT m FROM MonHoc m WHERE m.soTinChi = :soTinChi")
    , @NamedQuery(name = "MonHoc.findByTinChiHocPhi", query = "SELECT m FROM MonHoc m WHERE m.tinChiHocPhi = :tinChiHocPhi")
    , @NamedQuery(name = "MonHoc.findByTrongSo", query = "SELECT m FROM MonHoc m WHERE m.trongSo = :trongSo")})
public class MonHoc implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_mon_hoc")
    private String idMonHoc;
    @Basic(optional = false)
    @Column(name = "ten_mon_hoc")
    private String tenMonHoc;
    @Basic(optional = false)
    @Column(name = "thoi_luong")
    private String thoiLuong;
    @Basic(optional = false)
    @Column(name = "so_tin_chi")
    private int soTinChi;
    @Basic(optional = false)
    @Column(name = "tin_chi_hoc_phi")
    private float tinChiHocPhi;
    @Basic(optional = false)
    @Column(name = "trong_so")
    private float trongSo;

    /**
     *
     */
    public MonHoc() {
    }

    /**
     *
     * @param idMonHoc
     */
    public MonHoc(String idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    /**
     *
     * @param idMonHoc
     * @param tenMonHoc
     * @param thoiLuong
     * @param soTinChi
     * @param tinChiHocPhi
     * @param trongSo
     */
    public MonHoc(String idMonHoc, String tenMonHoc, String thoiLuong, int soTinChi, float tinChiHocPhi, float trongSo) {
        this.idMonHoc = idMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.thoiLuong = thoiLuong;
        this.soTinChi = soTinChi;
        this.tinChiHocPhi = tinChiHocPhi;
        this.trongSo = trongSo;
    }

    /**
     *
     * @return
     */
    public String getIdMonHoc() {
        return idMonHoc;
    }

    /**
     *
     * @param idMonHoc
     */
    public void setIdMonHoc(String idMonHoc) {
        String oldIdMonHoc = this.idMonHoc;
        this.idMonHoc = idMonHoc;
        changeSupport.firePropertyChange("idMonHoc", oldIdMonHoc, idMonHoc);
    }

    /**
     *
     * @return
     */
    public String getTenMonHoc() {
        return tenMonHoc;
    }

    /**
     *
     * @param tenMonHoc
     */
    public void setTenMonHoc(String tenMonHoc) {
        String oldTenMonHoc = this.tenMonHoc;
        this.tenMonHoc = tenMonHoc;
        changeSupport.firePropertyChange("tenMonHoc", oldTenMonHoc, tenMonHoc);
    }

    /**
     *
     * @return
     */
    public String getThoiLuong() {
        return thoiLuong;
    }

    /**
     *
     * @param thoiLuong
     */
    public void setThoiLuong(String thoiLuong) {
        String oldThoiLuong = this.thoiLuong;
        this.thoiLuong = thoiLuong;
        changeSupport.firePropertyChange("thoiLuong", oldThoiLuong, thoiLuong);
    }

    /**
     *
     * @return
     */
    public int getSoTinChi() {
        return soTinChi;
    }

    /**
     *
     * @param soTinChi
     */
    public void setSoTinChi(int soTinChi) {
        int oldSoTinChi = this.soTinChi;
        this.soTinChi = soTinChi;
        changeSupport.firePropertyChange("soTinChi", oldSoTinChi, soTinChi);
    }

    /**
     *
     * @return
     */
    public float getTinChiHocPhi() {
        return tinChiHocPhi;
    }

    /**
     *
     * @param tinChiHocPhi
     */
    public void setTinChiHocPhi(float tinChiHocPhi) {
        float oldTinChiHocPhi = this.tinChiHocPhi;
        this.tinChiHocPhi = tinChiHocPhi;
        changeSupport.firePropertyChange("tinChiHocPhi", oldTinChiHocPhi, tinChiHocPhi);
    }

    /**
     *
     * @return
     */
    public float getTrongSo() {
        return trongSo;
    }

    /**
     *
     * @param trongSo
     */
    public void setTrongSo(float trongSo) {
        float oldTrongSo = this.trongSo;
        this.trongSo = trongSo;
        changeSupport.firePropertyChange("trongSo", oldTrongSo, trongSo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMonHoc != null ? idMonHoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonHoc)) {
            return false;
        }
        MonHoc other = (MonHoc) object;
        if ((this.idMonHoc == null && other.idMonHoc != null) || (this.idMonHoc != null && !this.idMonHoc.equals(other.idMonHoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hust.soict.ui.student.MonHoc[ idMonHoc=" + idMonHoc + " ]";
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
