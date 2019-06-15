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
 *Constructor, getter, setter Object User(define properties, methods of User).
 * Class auto generated when binding data table dang_nhap using POJO persistence, JDBC to collection DB.
 * @author quangnd
 */
@Entity
@Table(name = "dang_nhap", catalog = "quan_ly_sinh_vien", schema = "")
@NamedQueries({
    @NamedQuery(name = "DangNhap.findAll", query = "SELECT d FROM DangNhap d")
    , @NamedQuery(name = "DangNhap.findByUserName", query = "SELECT d FROM DangNhap d WHERE d.userName = :userName")
    , @NamedQuery(name = "DangNhap.findByPassword", query = "SELECT d FROM DangNhap d WHERE d.password = :password")
    , @NamedQuery(name = "DangNhap.findByIsAdmin", query = "SELECT d FROM DangNhap d WHERE d.isAdmin = :isAdmin")})
public class DangNhap implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "user_name")
    @Id
    private String userName;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "is_admin")
    private String isAdmin;

    /**
     *
     */
    public DangNhap() {
    }

    /**
     *
     * @param userName
     */
    public DangNhap(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @param userName
     * @param password
     * @param isAdmin
     */
    public DangNhap(String userName, String password, String isAdmin) {
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        String oldUserName = this.userName;
        this.userName = userName;
        changeSupport.firePropertyChange("userName", oldUserName, userName);
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    /**
     *
     * @return
     */
    public String getIsAdmin() {
        return isAdmin;
    }

    /**
     *
     * @param isAdmin
     */
    public void setIsAdmin(String isAdmin) {
        String oldIsAdmin = this.isAdmin;
        this.isAdmin = isAdmin;
        changeSupport.firePropertyChange("isAdmin", oldIsAdmin, isAdmin);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DangNhap)) {
            return false;
        }
        DangNhap other = (DangNhap) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hust.soict.ui.admin.DangNhap[ userName=" + userName + " ]";
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
