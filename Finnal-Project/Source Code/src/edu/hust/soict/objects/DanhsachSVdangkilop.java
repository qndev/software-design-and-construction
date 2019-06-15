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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *Constructor, getter, setter Object List of Students registered Courses(define properties, methods).
 * Class auto generated when binding data table danh_sach_SV_dang_ki_lop using POJO persistence, JDBC to collection DB.
 * @author quangnd
 */
@Entity
@Table(name = "danh_sach_SV_dang_ki_lop", catalog = "quan_ly_sinh_vien", schema = "")
@NamedQueries({
    @NamedQuery(name = "DanhsachSVdangkilop.findAll", query = "SELECT d FROM DanhsachSVdangkilop d")
    , @NamedQuery(name = "DanhsachSVdangkilop.findByIddanhsachSVdangkilop", query = "SELECT d FROM DanhsachSVdangkilop d WHERE d.iddanhsachSVdangkilop = :iddanhsachSVdangkilop")
    , @NamedQuery(name = "DanhsachSVdangkilop.findByIdsinhvienDK", query = "SELECT d FROM DanhsachSVdangkilop d WHERE d.idsinhvienDK = :idsinhvienDK")
    , @NamedQuery(name = "DanhsachSVdangkilop.findByMalopmoSVDK", query = "SELECT d FROM DanhsachSVdangkilop d WHERE d.malopmoSVDK = :malopmoSVDK")
    , @NamedQuery(name = "DanhsachSVdangkilop.findBySoluongDK", query = "SELECT d FROM DanhsachSVdangkilop d WHERE d.soluongDK = :soluongDK")
    , @NamedQuery(name = "DanhsachSVdangkilop.findByMaxDK", query = "SELECT d FROM DanhsachSVdangkilop d WHERE d.maxDK = :maxDK")
    , @NamedQuery(name = "DanhsachSVdangkilop.findByHockiDK", query = "SELECT d FROM DanhsachSVdangkilop d WHERE d.hockiDK = :hockiDK")})
public class DanhsachSVdangkilop implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddanh_sach_SV_dang_ki_lop")
    private Integer iddanhsachSVdangkilop;
    @Basic(optional = false)
    @Column(name = "id_sinh_vien_DK")
    private String idsinhvienDK;
    @Basic(optional = false)
    @Column(name = "ma_lop_mo_SV_DK")
    private String malopmoSVDK;
    @Column(name = "so_luong_DK")
    private Integer soluongDK;
    @Column(name = "max_DK")
    private Integer maxDK;
    @Column(name = "hoc_ki_DK")
    private String hockiDK;

    /**
     *
     */
    public DanhsachSVdangkilop() {
    }

    /**
     *
     * @param iddanhsachSVdangkilop
     */
    public DanhsachSVdangkilop(Integer iddanhsachSVdangkilop) {
        this.iddanhsachSVdangkilop = iddanhsachSVdangkilop;
    }

    /**
     *
     * @param iddanhsachSVdangkilop
     * @param idsinhvienDK
     * @param malopmoSVDK
     */
    public DanhsachSVdangkilop(Integer iddanhsachSVdangkilop, String idsinhvienDK, String malopmoSVDK) {
        this.iddanhsachSVdangkilop = iddanhsachSVdangkilop;
        this.idsinhvienDK = idsinhvienDK;
        this.malopmoSVDK = malopmoSVDK;
    }

    /**
     *
     * @return
     */
    public Integer getIddanhsachSVdangkilop() {
        return iddanhsachSVdangkilop;
    }

    /**
     *
     * @param iddanhsachSVdangkilop
     */
    public void setIddanhsachSVdangkilop(Integer iddanhsachSVdangkilop) {
        Integer oldIddanhsachSVdangkilop = this.iddanhsachSVdangkilop;
        this.iddanhsachSVdangkilop = iddanhsachSVdangkilop;
        changeSupport.firePropertyChange("iddanhsachSVdangkilop", oldIddanhsachSVdangkilop, iddanhsachSVdangkilop);
    }

    /**
     *
     * @return
     */
    public String getIdsinhvienDK() {
        return idsinhvienDK;
    }

    /**
     *
     * @param idsinhvienDK
     */
    public void setIdsinhvienDK(String idsinhvienDK) {
        String oldIdsinhvienDK = this.idsinhvienDK;
        this.idsinhvienDK = idsinhvienDK;
        changeSupport.firePropertyChange("idsinhvienDK", oldIdsinhvienDK, idsinhvienDK);
    }

    /**
     *
     * @return
     */
    public String getMalopmoSVDK() {
        return malopmoSVDK;
    }

    /**
     *
     * @param malopmoSVDK
     */
    public void setMalopmoSVDK(String malopmoSVDK) {
        String oldMalopmoSVDK = this.malopmoSVDK;
        this.malopmoSVDK = malopmoSVDK;
        changeSupport.firePropertyChange("malopmoSVDK", oldMalopmoSVDK, malopmoSVDK);
    }

    /**
     *
     * @return
     */
    public Integer getSoluongDK() {
        return soluongDK;
    }

    /**
     *
     * @param soluongDK
     */
    public void setSoluongDK(Integer soluongDK) {
        Integer oldSoluongDK = this.soluongDK;
        this.soluongDK = soluongDK;
        changeSupport.firePropertyChange("soluongDK", oldSoluongDK, soluongDK);
    }

    /**
     *
     * @return
     */
    public Integer getMaxDK() {
        return maxDK;
    }

    /**
     *
     * @param maxDK
     */
    public void setMaxDK(Integer maxDK) {
        Integer oldMaxDK = this.maxDK;
        this.maxDK = maxDK;
        changeSupport.firePropertyChange("maxDK", oldMaxDK, maxDK);
    }

    /**
     *
     * @return
     */
    public String getHockiDK() {
        return hockiDK;
    }

    /**
     *
     * @param hockiDK
     */
    public void setHockiDK(String hockiDK) {
        String oldHockiDK = this.hockiDK;
        this.hockiDK = hockiDK;
        changeSupport.firePropertyChange("hockiDK", oldHockiDK, hockiDK);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddanhsachSVdangkilop != null ? iddanhsachSVdangkilop.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DanhsachSVdangkilop)) {
            return false;
        }
        DanhsachSVdangkilop other = (DanhsachSVdangkilop) object;
        if ((this.iddanhsachSVdangkilop == null && other.iddanhsachSVdangkilop != null) || (this.iddanhsachSVdangkilop != null && !this.iddanhsachSVdangkilop.equals(other.iddanhsachSVdangkilop))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hust.soict.ui.student.DanhsachSVdangkilop[ iddanhsachSVdangkilop=" + iddanhsachSVdangkilop + " ]";
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
