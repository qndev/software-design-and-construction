/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.logic;

import edu.hust.soict.dao.ClassDAO;
import edu.hust.soict.dao.DBConnect;
import edu.hust.soict.objects.Register;
import edu.hust.soict.ui.student.StudentRegisterCourses;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quangnd
 */
public class CheckStudentRegister {
    
    public PreparedStatement ps;
    public ResultSet rs;

    public boolean addRegister(Register register) throws SQLException {
        if(new ClassDAO().addNew(register) == true){
            fetchDataAfterAddRegister(register.getMaSinhVienDK()); //from DAO
            return true;
        } else{
        return false;
        }
    }

    public int fetchTotalRegister(String userLogin) throws SQLException {
        
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareCall("select sum(so_tin_chi)\n"
                    + "       from mon_hoc, danh_sach_lop_mo_DK, danh_sach_SV_dang_ki_lop\n"
                    + "       where mon_hoc.id_mon_hoc = danh_sach_lop_mo_DK.id_mon_hoc_DK\n"
                    + "       and danh_sach_SV_dang_ki_lop.ma_lop_mo_SV_DK = danh_sach_lop_mo_DK.ma_lop_mo_DK \n"
                    + "       and id_sinh_vien_DK =" + userLogin);
            rs = ps.executeQuery();
            if(rs.first()){
                return rs.getInt(1);
            }
        }
        return 0;
    }
        
    public ResultSet fetchListCourses() throws SQLException {
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT ma_lop_mo_DK, thoi_gian_bat_dau, thoi_gian_ket_thuc, thu, tuan_hoc, loai_lop, id_mon_hoc_DK, nhom, phong_hoc, so_luong_da_dang_ki, so_luong_max_DK, date_to_exist FROM danh_sach_lop_mo_DK");
                rs = ps.executeQuery();
                return rs;
            } catch (SQLException e) {
                Logger.getLogger(StudentRegisterCourses.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
       
    public ResultSet fetchDataAfterAddRegister(String maSinhVien) throws SQLException { //from DAO
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("SELECT iddanh_sach_SV_dang_ki_lop, id_sinh_vien_DK, ma_lop_mo_SV_DK, danh_sach_lop_mo_DK.id_mon_hoc_DK, mon_hoc.ten_mon_hoc, mon_hoc.so_tin_chi FROM danh_sach_SV_dang_ki_lop, danh_sach_lop_mo_DK, mon_hoc WHERE ma_lop_mo_SV_DK = ma_lop_mo_DK AND mon_hoc.id_mon_hoc=danh_sach_lop_mo_DK.id_mon_hoc_DK AND id_sinh_vien_DK=" + maSinhVien);
            rs = ps.executeQuery();   
            return rs;
        }
            return null;
    } 
    
    public ArrayList<edu.hust.soict.objects.Class> searchClassById(String maLop) throws SQLException {
        StudentRegisterCourses registerCourses = new StudentRegisterCourses();
        while (registerCourses.dtmLop.getRowCount() > 0) {
            registerCourses.dtmLop.removeRow(0);
        }
        if (maLop != null && maLop.trim().length() > 0) {
            ClassDAO classDAO = new ClassDAO();
            ArrayList arrayList = classDAO.findByIDClass(maLop);
            return arrayList;
        } else {
            ClassDAO classDAO = new ClassDAO();
            ArrayList arrayList = classDAO.getAll();
            return arrayList;
        }
    }
    
    public static Object[] toOjectClass(edu.hust.soict.objects.Class cl) {
        Object[] objects = {cl.getMa_lop_DK(), cl.getBat_dau(), cl.getKet_thuc(), cl.getThu(), cl.getTuan_hoc(), cl.getLoai_lop(), cl.getMa_mon_hoc(), cl.getNhom(), cl.getPhong_hoc(), cl.getDa_DK(), cl.getMax_DK()};
        return objects;
    }
}
