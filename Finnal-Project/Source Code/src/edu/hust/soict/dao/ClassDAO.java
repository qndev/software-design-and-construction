/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.dao;

import static edu.hust.soict.dao.DBConnect.cnn;
import edu.hust.soict.objects.Class;
import edu.hust.soict.objects.Register;
import edu.hust.soict.objects.MakeCourses;
import edu.hust.soict.ui.admin.ClassRegister;
import edu.hust.soict.ui.student.MainStudent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Class Data Access Object of Courses(all about method CRUD).
 *
 * @author quangnd
 */
public class ClassDAO {

    ClassRegister classRegister = new ClassRegister();
    MainStudent mainStudent = new MainStudent();

    /**
     *
     * @param rg
     * @return
     */
    public boolean addNewCourses(MakeCourses rg) {

        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("INSERT INTO danh_sach_lop_mo_DK(ma_lop_mo_DK, thoi_gian_bat_dau, thoi_gian_ket_thuc, thu, tuan_hoc, loai_lop, id_mon_hoc_DK, nhom, phong_hoc, hoc_ki, so_luong_max_DK, date_to_exist) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,?)");
                ps.setString(1, rg.getMa_lop_DK());
                ps.setString(2, rg.getBat_dau());
                ps.setString(3, rg.getKet_thuc());
                ps.setString(4, rg.getThu());
                ps.setString(5, rg.getTuan_hoc());
                ps.setString(6, rg.getLoai_lop());
                ps.setString(7, rg.getMa_mon_hoc());
                ps.setString(8, rg.getNhom());
                ps.setString(9, rg.getPhong_hoc());
                ps.setString(10, rg.getHoc_ki());
                ps.setInt(11, rg.getMax_DK());
                ps.setDate(12, rg.getThoi_han_DK());
                ps.executeUpdate();
                int i = ps.executeUpdate();
                if (i == 1) {
                    return true;
                    //JOptionPane.showMessageDialog(this.classRegister, "Đã tạo mới thành công mã lớp: " + rg.getMa_lop_DK() + "!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                //Logger.getLogger(AddUserDAO.class.getName()).log(Level.SEVERE, null, ex);
                String sqlMessage = ex.getMessage();
                String sqlState = ex.getSQLState();
                int vendorCode = ex.getErrorCode();
                System.err.println("SQLException:");
                System.err.println("ERROR code: " + vendorCode);
                System.err.println("SQL state: " + sqlState);
                System.err.println("Message: " + sqlMessage + "\n----------------");
                if (vendorCode == 1062) {
                    JOptionPane.showMessageDialog(this.classRegister, "Bạn không thể tạo mới được mã lớp." + "\n" + "Do mã lớp " + rg.getMa_lop_DK() + " đã tồn tại!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this.classRegister, "Bạn không thể tạo mới được mã lớp: " + rg.getMa_lop_DK() + "\n" + "Do "+sqlMessage, "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                }
            } finally {
                DBConnect.close(ps);
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    public ArrayList<Class> getAll() {
        ArrayList<Class> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select ma_lop_mo_DK, thoi_gian_bat_dau, thoi_gian_ket_thuc, thu, tuan_hoc, loai_lop, id_mon_hoc_DK, nhom, phong_hoc, so_luong_da_dang_ki, so_luong_max_DK from danh_sach_lop_mo_DK");
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    Class cl = new Class();
                    cl.setMa_lop_DK(rs.getString(1));
                    cl.setBat_dau(rs.getString(2));
                    cl.setKet_thuc(rs.getString(3));
                    cl.setThu(rs.getString(4));
                    cl.setTuan_hoc(rs.getString(5));
                    cl.setLoai_lop(rs.getString(6));
                    cl.setMa_mon_hoc(rs.getString(7));
                    cl.setNhom(rs.getString(8));
                    cl.setPhong_hoc(rs.getString(9));
                    cl.setDa_DK(rs.getString(10));
                    cl.setMax_DK(rs.getString(11));
                    list.add(cl);
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
     * @param maLop
     * @return
     */
    public ArrayList<Class> findByIDClass(String maLop) {
        ArrayList<Class> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select ma_lop_mo_DK, thoi_gian_bat_dau, thoi_gian_ket_thuc, thu, tuan_hoc, loai_lop, id_mon_hoc_DK, nhom, phong_hoc, so_luong_da_dang_ki, so_luong_max_DK from danh_sach_lop_mo_DK where id_mon_hoc_DK = ?");
                ps.setString(1, maLop);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    Class sv = new Class();
                    sv.setMa_lop_DK(rs.getString(1));
                    sv.setBat_dau(rs.getString(2));
                    sv.setKet_thuc(rs.getString(3));
                    sv.setThu(rs.getString(4));
                    sv.setTuan_hoc(rs.getString(5));
                    sv.setLoai_lop(rs.getString(6));
                    sv.setMa_mon_hoc(rs.getString(7));
                    sv.setNhom(rs.getString(8));
                    sv.setPhong_hoc(rs.getString(9));
                    sv.setDa_DK(rs.getString(10));
                    sv.setMax_DK(rs.getString(11));
                    list.add(sv);
                }
                return list;
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
     * @param register
     * @return
     * @throws java.sql.SQLException
     */
    public boolean addNew(Register register) throws SQLException {
        PreparedStatement ps = null, ps1 = null;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT DISTINCT thoi_gian_bat_dau, thoi_gian_ket_thuc, thu FROM danh_sach_lop_mo_DK WHERE ma_lop_mo_DK =" + register.getMaLopDK());
                rs = ps.executeQuery();
                if (rs.next()) {
                    Time starttime = rs.getTime("thoi_gian_bat_dau");
                    Time endtime = rs.getTime("thoi_gian_ket_thuc");
                    String thu = rs.getString("thu");
                    ps1 = DBConnect.cnn.prepareStatement("INSERT INTO danh_sach_SV_dang_ki_lop(id_sinh_vien_DK, ma_lop_mo_SV_DK, start_time, end_time, thu) VALUES (?, ?, ?, ?, ?)");
                    ps1.setString(1, register.getMaSinhVienDK());
                    ps1.setString(2, register.getMaLopDK());
                    ps1.setTime(3, starttime);
                    ps1.setTime(4, endtime);
                    ps1.setString(5, thu);
                    int i = ps1.executeUpdate();
                    if (i == 1) {
                        return true;
                        //JOptionPane.showMessageDialog(this.mainStudent, "Đã đăng kí thành công mã lớp: " + register.getMaLopDK() + "!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                    }
               }

            } catch (SQLException ex) {
                //Logger.getLogger(AddUserDAO.class.getName()).log(Level.SEVERE, null, ex);
                String sqlMessage = ex.getMessage();
                String sqlState = ex.getSQLState();
                int vendorCode = ex.getErrorCode();
                System.err.println("SQLException:");
                System.err.println("ERROR code: " + vendorCode);
                System.err.println("SQL state: " + sqlState);
                System.err.println("Message: " + sqlMessage + "\n----------------");
                JOptionPane.showMessageDialog(this.mainStudent, sqlMessage + "\n" + "Bạn không thể đăng kí được mã lớp:" + register.getMaLopDK() + "!", "CTĐT Thông báo!", JOptionPane.INFORMATION_MESSAGE);
            } finally {
                DBConnect.close(ps);
                DBConnect.close(ps1);
            }
        }
        return false;
    }

    /**
     *
     * @param idDangKiLop
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void deleteRegister(String idDangKiLop) throws SQLException, ClassNotFoundException {

        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("delete from danh_sach_SV_dang_ki_lop where iddanh_sach_SV_dang_ki_lop = ?");
                ps.setString(1, idDangKiLop);
                //ps.executeUpdate();
                int i = ps.executeUpdate();
                if (i == 1) {
                    JOptionPane.showMessageDialog(this.mainStudent, "Đã xóa thành công mã lớp ĐK!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                String sqlMessage = ex.getMessage();
                String sqlState = ex.getSQLState();
                int vendorCode = ex.getErrorCode();
                System.err.println("Exception occurred:");
                System.err.println("Message: " + sqlMessage);
                System.err.println("SQL state: " + sqlState);
                System.err.println("Vendor code: " + vendorCode + "\n----------------");
                JOptionPane.showMessageDialog(this.mainStudent, "Bạn không thể xóa lớp ĐK: " + idDangKiLop + "\nDo " + sqlMessage, "CTĐT Thông báo!", JOptionPane.INFORMATION_MESSAGE);
            } finally {
                DBConnect.close(ps);
            }
        }
    }

    /**
     *
     * @param maSV
     * @return
     */
    public ArrayList<Register> findByIDStudentRegister(String maSV) {
        ArrayList<Register> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select iddanh_sach_SV_dang_ki_lop, id_sinh_vien_DK, ma_lop_mo_SV_DK from danh_sach_SV_dang_ki_lop where id_sinh_vien_DK=?");
                ps.setString(1, maSV);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    Register sv = new Register();
                    sv.setIdDKLop(rs.getString(1));
                    sv.setMaSinhVienDK(rs.getString(2));
                    sv.setMaLopDK(rs.getString(3));
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
     * @param malop
     * @return 
     */
    public boolean deleteCourses(String malop) {

        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("delete from danh_sach_lop_mo_DK where ma_lop_mo_DK = ?");
                ps.setString(1, malop);
                int i = ps.executeUpdate();
                if (i == 1) {
                    return true;
                    //JOptionPane.showMessageDialog(this.classRegister, "Đã xóa thành công mã lớp!" + malop, "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                String sqlMessage = ex.getMessage();
                String sqlState = ex.getSQLState();
                int vendorCode = ex.getErrorCode();
                System.err.println("Exception occurred:");
                System.err.println("Message: " + sqlMessage);
                System.err.println("SQL state: " + sqlState);
                System.err.println("Vendor code: " + vendorCode + "\n----------------");
                JOptionPane.showMessageDialog(this.classRegister, "Bạn không thể xóa lớp ĐK: " + malop + "\nDo " + sqlMessage, "CTĐT Thông báo!", JOptionPane.INFORMATION_MESSAGE);
            } finally {
                DBConnect.close(ps);
            }
        }
        return false;
    }

    /**
     *
     * @param courses
     * @return
     */
    public boolean updateCourses(MakeCourses courses) {
        if (DBConnect.open()) {
            try {
                PreparedStatement ps = cnn.prepareStatement("UPDATE danh_sach_lop_mo_DK SET thoi_gian_bat_dau=?, thoi_gian_ket_thuc=?, thu=?, tuan_hoc=?, loai_lop=?, id_mon_hoc_DK=?, nhom=?, phong_hoc=?, hoc_ki=?, so_luong_max_DK=?, date_to_exist=?  WHERE ma_lop_mo_DK=?");
                ps.setString(1, courses.getBat_dau());
                ps.setString(2, courses.getKet_thuc());
                ps.setString(3, courses.getThu());
                ps.setString(4, courses.getTuan_hoc());
                ps.setString(5, courses.getLoai_lop());
                ps.setString(6, courses.getMa_mon_hoc());
                ps.setString(7, courses.getNhom());
                ps.setString(8, courses.getPhong_hoc());
                ps.setString(9, courses.getHoc_ki());
                ps.setInt(10, courses.getMax_DK());
                ps.setDate(11, courses.getThoi_han_DK());
                ps.setString(12, courses.getMa_lop_DK());
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
                JOptionPane.showMessageDialog(this.classRegister, "Bạn không thể cập nhật lớp ĐK: " + courses.getMa_lop_DK() + "\nDo " + sqlMessage, "CTĐT Thông báo!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return false;
    }

}
