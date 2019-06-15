/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * Check validation of email, user name,...
 *
 * @author quangnd
 */
public class Check {

    /**
     *
     */
    public Check() {
    }

    /**
     *
     * @param n
     * @return
     */
    public static boolean checkName(String n) {

        if (n == null || n.length() == 0) {
            return false;
        } else {
            String strPattern = "[^a-z ]";

            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }

    /**
     *
     * @param n
     * @return
     */
    public static boolean checkPhone(String n) {
        if (n == null || n.length() > 13 || n.length() < 7) {
            return false;
        } else {
            String strPattern = "[^0-9]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }

    /**
     *
     * @param n
     * @return
     */
    public static boolean checkMark(String n) {
        if (n == null || n.length() > 2 || n.length() < 1) {
            return false;
        } else {
            String strPattern = "[^0-9]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }

    /**
     *
     * @param n
     * @return
     */
    public static boolean checkSpace(String n) {
        String strPattern = "[^ ]";
        Pattern p;
        Matcher m;
        int flag = Pattern.CASE_INSENSITIVE;
        p = Pattern.compile(strPattern, flag);
        m = p.matcher(n);
        return m.find();
    }

    /**
     *
     * @param n
     * @return
     */
    public static boolean checkEmail(String n) {
        if (n == null) {
            return false;
        } else {
            String strPattern = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return m.find();
        }
    }

    /**
     *
     * @param n
     * @return
     */
    public static boolean checkNumber(String n) {
        if (n == null || n.length() > 10 || n.length() < 1) {
            return false;
        } else {
            String strPattern = "[^0-9]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }

    /**
     *
     * @param n
     * @return
     */
    public static boolean check(String n) {
        if (n == null || n.length() == 0) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param n
     * @return
     */
    public static boolean checkID(String n) {
        if (n.length() == 0) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không được trống!", "Hãy nhập lại!", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (n.length() != 8) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập phải đủ 8 kí tự [^a-z0-9]!", "Hãy nhập lại!", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            String strPattern = "[^a-z0-9]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }

    /**
     *
     * @param n
     * @return
     */
    public static boolean checkIDCourses(String n) {
        if (n == null || n.length() != 6) {
            return false;
        } else {
            String strPattern = "[^0-9]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }

    /**
     *
     * @param n
     * @return
     */
    public static boolean checkDate(String n) {
        if (n == null) {
            return false;
        } else {
            String strPattern = "^(0[1-9]|1[0-9]|2[0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.matches();
        }
    }
}
