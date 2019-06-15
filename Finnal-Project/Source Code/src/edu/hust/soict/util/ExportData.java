/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.util;

import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Export data.
 *
 * @author quangnd
 *
 */
public class ExportData {

    /**
     * Export data table from database to xlsx file.
     * @param table
     */
    public void exportExcel(JTable table) {
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                FileWriter out = new FileWriter(file + ".xlsx");
                try (BufferedWriter bwrite = new BufferedWriter(out)) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    //Get Name Of Column
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        bwrite.write(model.getColumnName(j) + "\t");
                    }
                    bwrite.write("\n");
                    //Get Dynamic Data
                    for (int j = 0; j < table.getRowCount(); j++) {
                        for (int k = 0; k < table.getColumnCount(); k++) {
                            bwrite.write(model.getValueAt(j, k) + "\t");
                        }
                        bwrite.write("\n");
                    }
                }
                JOptionPane.showMessageDialog(null, "Đã lưu file thành công!", "Successfully!",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (HeadlessException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, hãy xem lại!", "Error!",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
