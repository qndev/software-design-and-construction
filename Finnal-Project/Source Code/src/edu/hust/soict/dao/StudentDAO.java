/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.dao;

import static edu.hust.soict.dao.DBConnect.cnn;
import edu.hust.soict.objects.Student;
import edu.hust.soict.ui.admin.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Class Data Access Object of Students(all about method CRUD).
 *
 * @author quangnd
 */
public class StudentDAO implements InterfaceStudentDAO {

    Main main = new Main();

    /**
     *
     * @return
     */
    @Override
    public ArrayList<Student> getAll() {
        ArrayList<Student> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select id_sinh_vien, ten_sinh_vien, lop_hoc, chuong_trinh_DT, ngay_sinh, he_hoc, khoa_hoc, email, trang_thai from thong_tin_sinh_vien");
                rs = ps.executeQuery();

                list = new ArrayList<>();
                while (rs.next()) {
                    Student sv = new Student();
                    sv.setId_sinh_vien(rs.getString(1));
                    sv.setTen_sinh_vien(rs.getString(2));
                    sv.setLop_hoc(rs.getString(3));
                    sv.setChuong_trinh_DT(rs.getString(4));
                    sv.setNgay_sinh(rs.getDate(5));
                    sv.setHe_hoc(rs.getString(6));
                    sv.setKhoa(rs.getString(7));
                    sv.setEmail(rs.getString(8));
                    sv.setTrang_thai(rs.getString(9));
                    list.add(sv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }
        return list;
    }

    /**
     *
     * @param maSV
     * @return
     */
    @Override
    public ArrayList<Student> findByIDStudent(String maSV) {
        ArrayList<Student> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select id_sinh_vien, ten_sinh_vien, lop_hoc, chuong_trinh_DT, ngay_sinh, he_hoc, khoa_hoc, email, trang_thai from thong_tin_sinh_vien where id_sinh_vien = ?");
                ps.setString(1, maSV);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    Student sv = new Student();
                    sv.setId_sinh_vien(rs.getString(1));
                    sv.setTen_sinh_vien(rs.getString(2));
                    sv.setLop_hoc(rs.getString(3));
                    sv.setChuong_trinh_DT(rs.getString(4));
                    sv.setNgay_sinh(rs.getDate(5));
                    sv.setHe_hoc(rs.getString(6));
                    sv.setKhoa(rs.getString(7));
                    sv.setEmail(rs.getString(8));
                    sv.setTrang_thai(rs.getString(9));
                    list.add(sv);
                }

            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }

        return list;
    }

    /**
     *
     * @param sv
     * @return
     */
    @Override
    public boolean addNew(Student sv) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {

                ps = DBConnect.cnn.prepareStatement("INSERT INTO thong_tin_sinh_vien (id_sinh_vien, ten_sinh_vien, ngay_sinh, lop_hoc, chuong_trinh_DT, he_hoc, trang_thai, khoa_hoc, department, email, don_vi_tin_chi_hoc_phi) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, sv.getId_sinh_vien());
                ps.setString(2, sv.getTen_sinh_vien());
                ps.setDate(3, sv.getNgay_sinh());
                ps.setString(4, sv.getLop_hoc());
                ps.setString(5, sv.getChuong_trinh_DT());
                ps.setString(6, sv.getHe_hoc());
                ps.setString(7, sv.getTrang_thai());
                ps.setString(8, sv.getKhoa());
                ps.setString(9, sv.getDepartment());
                ps.setString(10, sv.getEmail());
                ps.setDouble(11, sv.getDon_vi_HP());
                int i = ps.executeUpdate();
                if (i == 1) {
                    return true;
                    //JOptionPane.showMessageDialog(this.main, "Tạo mới sinh viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {

                }

            } catch (SQLException ex) {
                String sqlMessage = ex.getMessage();
                String sqlState = ex.getSQLState();
                int vendorCode = ex.getErrorCode();
                System.err.println("SQLException:");
                System.err.println("ERROR code: " + vendorCode);
                System.err.println("SQL state: " + sqlState);
                System.err.println("Message: " + sqlMessage + "\n----------------");
                if (vendorCode == 1062) {
                    return false;
                    //JOptionPane.showMessageDialog(this.main, "Sinh viên với mã sinh viên:" + sv.getId_sinh_vien() + " đã tồn tại" + "!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            } finally {
                DBConnect.close(ps);
            }
        }
        return false;
    }

    /**
     *
     * @param st
     * @return
     */
    @Override
    public boolean updateByID(Student st) {
        if (DBConnect.open()) {
            try {
                PreparedStatement ps = DBConnect.cnn.prepareStatement("UPDATE thong_tin_sinh_vien set ten_sinh_vien = ?, ngay_sinh = ?, email = ? WHERE id_sinh_vien = ?");
                ps.setString(1, st.getTen_sinh_vien());
                ps.setDate(2, st.getNgay_sinh());
                ps.setString(3, st.getEmail());
                ps.setString(4, st.getId_sinh_vien());
                int i = ps.executeUpdate();
                if (i == 1) {
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close();
            }

        }
        return false;
    }


    /**
     *
     * @param masv
     * @return
     */
    @Override
    public ArrayList<Student> checkID(String masv) {
        ArrayList<Student> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from thong_tin_sinh_vien where id_sinh_vien=?");
                psCheck.setString(1, masv);
                rs = psCheck.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    Student sinhVien = new Student();
                    sinhVien.setId_sinh_vien(rs.getString(1));
                    list.add(sinhVien);
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(psCheck, rs);
            }
        }
        return list;
    }

    /**
     *
     * @param maSV
     */
    public void deleteStudent(String maSV) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("delete from thong_tin_sinh_vien where id_sinh_vien = ?");
                ps.setString(1, maSV);
                int i = ps.executeUpdate();
                if (i == 1) {
                    JOptionPane.showMessageDialog(this.main, "Đã xóa thành công sinh viên: " + maSV, "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                String sqlMessage = ex.getMessage();
                String sqlState = ex.getSQLState();
                int vendorCode = ex.getErrorCode();
                System.err.println("Exception occurred:");
                System.err.println("Message: " + sqlMessage);
                System.err.println("SQL state: " + sqlState);
                System.err.println("Vendor code: " + vendorCode + "\n----------------");
                if (vendorCode == 1451) {
                    JOptionPane.showMessageDialog(this.main, "Bạn không thể xóa sinh viên: " + maSV + "\nBạn chỉ có thể cập nhật thông tin liên quan. ", "CTĐT Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                }
            } finally {
                DBConnect.close(ps);
            }
        }
    }

    /**
     *
     * @param st
     * @return
     */
    public boolean updateStudent(Student st) {

        if (DBConnect.open()) {
            try {
                PreparedStatement ps = cnn.prepareStatement("UPDATE thong_tin_sinh_vien SET ten_sinh_vien=?, ngay_sinh=?, lop_hoc=?, chuong_trinh_DT=?, he_hoc=?, trang_thai=?, khoa_hoc=?, department=?, email=?, don_vi_tin_chi_hoc_phi=? WHERE id_sinh_vien=?");
                ps.setString(1, st.getTen_sinh_vien());
                ps.setDate(2, st.getNgay_sinh());
                ps.setString(3, st.getLop_hoc());
                ps.setString(4, st.getChuong_trinh_DT());
                ps.setString(5, st.getHe_hoc());
                ps.setString(6, st.getTrang_thai());
                ps.setString(7, st.getKhoa());
                ps.setString(8, st.getDepartment());
                ps.setString(9, st.getEmail());
                ps.setDouble(10, st.getDon_vi_HP());
                ps.setString(11, st.getId_sinh_vien());
                int i = ps.executeUpdate();
                if (i == 1) {
                    return true;
                }
            } catch (SQLException ex) {
                String sqlMessage = ex.getMessage();
                String sqlState = ex.getSQLState();
                int vendorCode = ex.getErrorCode();
                System.err.println("Exception occurred:");
                System.err.println("Message: " + sqlMessage);
                System.err.println("SQL state: " + sqlState);
                System.err.println("Vendor code: " + vendorCode + "\n----------------");
                JOptionPane.showMessageDialog(this.main, "Bạn không thể cập nhật sinh viên với mã SV: " + st.getId_sinh_vien() + "\nDo " + sqlMessage, "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
            } finally {
                DBConnect.close();
            }
        }
        return false;
    }

}
