/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import database.Koneksi;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import utils.*;

public class Komputer extends javax.swing.JFrame {

    private Connection conn;
    private DefaultTableModel tableModel;
    private int lastSelectedRow = -1;

    /**
     * Creates new form Komputer
     */
    public Komputer() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        
        conn = Koneksi.getConnection();
        setupTable();
        loadData();
        setButtonStates(true, false, false);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                new MainMenu().setVisible(true);
            }
        });
        
        // Add document listener to search field
        cariField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) { searchIfEmpty(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { searchIfEmpty(); }
            public void insertUpdate(javax.swing.event.DocumentEvent e) { searchIfEmpty(); }
        });
    }

    private void setupTable() {
        String[] columns = {"ID", "Model", "Spesifikasi"};
        tableModel = new DefaultTableModel(columns, 0);
        jTable2.setModel(tableModel);
        // Hide ID column
        jTable2.getColumnModel().getColumn(0).setMinWidth(0);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(0).setWidth(0);
    }

    private void loadData() {
        tableModel.setRowCount(0);
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM komputer");
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id_pc"),
                    rs.getString("model"),
                    rs.getString("spesifikasi")
                };
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    private void setButtonStates(boolean tambahEnabled, boolean ubahEnabled, boolean hapusEnabled) {
        btnTambah3.setEnabled(tambahEnabled);
        btnUbah1.setEnabled(ubahEnabled);
        btnHapus1.setEnabled(hapusEnabled);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Input = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnUbah1 = new javax.swing.JButton();
        btnHapus1 = new javax.swing.JButton();
        btnTambah3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        model = new javax.swing.JTextField();
        Table = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cariField = new javax.swing.JTextField();
        cariBtn = new javax.swing.JButton();
        cetakBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Komputer");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(0, 1));

        Input.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        java.awt.GridBagLayout inputLayout = new java.awt.GridBagLayout();
        inputLayout.columnWidths = new int[] {0, 15, 0, 15, 0, 15, 0, 15, 0};
        inputLayout.rowHeights = new int[] {0, 11, 0, 11, 0};
        Input.setLayout(inputLayout);

        jLabel8.setText("Model :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        Input.add(jLabel8, gridBagConstraints);

        jLabel9.setText("Spesifikasi :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        Input.add(jLabel9, gridBagConstraints);

        btnUbah1.setBackground(new java.awt.Color(102, 102, 102));
        btnUbah1.setForeground(new java.awt.Color(255, 255, 255));
        btnUbah1.setText("Ubah");
        btnUbah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbah1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        Input.add(btnUbah1, gridBagConstraints);

        btnHapus1.setBackground(new java.awt.Color(204, 0, 0));
        btnHapus1.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus1.setText("Hapus");
        btnHapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapus1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        Input.add(btnHapus1, gridBagConstraints);

        btnTambah3.setBackground(new java.awt.Color(0, 153, 51));
        btnTambah3.setForeground(new java.awt.Color(242, 242, 242));
        btnTambah3.setText("Tambahkan");
        btnTambah3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambah3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        Input.add(btnTambah3, gridBagConstraints);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        Input.add(jScrollPane1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        Input.add(model, gridBagConstraints);

        getContentPane().add(Input);

        Table.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Table.setLayout(new java.awt.GridBagLayout());

        jLabel11.setText("Cari PC");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        Table.add(jLabel11, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 190;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        Table.add(cariField, gridBagConstraints);

        cariBtn.setText("Cari");
        cariBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        Table.add(cariBtn, gridBagConstraints);

        cetakBtn.setText("Cetak");
        cetakBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        Table.add(cetakBtn, gridBagConstraints);

        jScrollPane4.setPreferredSize(new java.awt.Dimension(350, 200));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jTable2.setPreferredSize(new java.awt.Dimension(60, 500));
        jTable2.setShowGrid(true);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        Table.add(jScrollPane4, gridBagConstraints);

        getContentPane().add(Table);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUbah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbah1ActionPerformed
        int row = jTable2.getSelectedRow();
        if (row < 0) {
            ValidationUtils.showError(this, "Pilih data yang akan diubah!");
            return;
        }

        if (ValidationUtils.isEmptyField(model) || ValidationUtils.isEmptyField(jTextArea1)) {
            ValidationUtils.showError(this, "Model dan spesifikasi komputer harus diisi!");
            return;
        }

        try {
            int id = (int) jTable2.getValueAt(row, 0);
            String sql = "UPDATE komputer SET model=?, spesifikasi=? WHERE id_pc=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, model.getText());
            ps.setString(2, jTextArea1.getText());
            ps.setInt(3, id);
            ps.executeUpdate();
            loadData();
            clearForm();
            setButtonStates(true, false, false);
            ValidationUtils.showSuccess(this, "Data komputer berhasil diubah");
        } catch (SQLException e) {
            ValidationUtils.showError(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnUbah1ActionPerformed

    private void btnHapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapus1ActionPerformed
        int row = jTable2.getSelectedRow();
        if (row < 0) {
            ValidationUtils.showError(this, "Pilih data yang akan dihapus!");
            return;
        }

        int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "Apakah Anda yakin ingin menghapus data ini?",
            "Konfirmasi Hapus",
            javax.swing.JOptionPane.YES_NO_OPTION
        );
        
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            try {
                int id = (int) jTable2.getValueAt(row, 0);
                String sql = "DELETE FROM komputer WHERE id_pc=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                loadData();
                clearForm();
                setButtonStates(true, false, false);
                ValidationUtils.showSuccess(this, "Data komputer berhasil dihapus");
            } catch (SQLException e) {
                ValidationUtils.showError(this, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnHapus1ActionPerformed

    private void btnTambah3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambah3ActionPerformed
        // Validate inputs
        if (ValidationUtils.isEmptyField(model) || ValidationUtils.isEmptyField(jTextArea1)) {
            ValidationUtils.showError(this, "Model dan spesifikasi komputer harus diisi!");
            return;
        }
        
        try {
            String sql = "INSERT INTO komputer (model, spesifikasi) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, model.getText().trim());
            ps.setString(2, jTextArea1.getText().trim());
            ps.executeUpdate();
            loadData();
            clearForm();
            setButtonStates(true, false, false);
            ValidationUtils.showSuccess(this, "Data komputer berhasil ditambahkan");
        } catch (SQLException e) {
            ValidationUtils.showError(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTambah3ActionPerformed

    private void cariBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBtnActionPerformed
        String keyword = cariField.getText().trim();
        
        // Show warning if search field is empty
        if (keyword.isEmpty()) {
            ValidationUtils.showError(this, "Masukkan kata kunci pencarian!");
            return;
        }

        tableModel.setRowCount(0);
        try {
            String sql = "SELECT * FROM komputer WHERE model LIKE ? OR spesifikasi LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            
            boolean found = false;
            while (rs.next()) {
                found = true;
                Object[] row = {
                    rs.getInt("id_pc"),
                    rs.getString("model"),
                    rs.getString("spesifikasi")
                };
                tableModel.addRow(row);
            }
            
            if (!found) {
                ValidationUtils.showError(this, "Data tidak ditemukan");
                loadData(); // Reload all data if no results found
            }
        } catch (SQLException e) {
            ValidationUtils.showError(this, "Error mencari data: " + e.getMessage());
            loadData(); // Reload all data on error
        }
    }//GEN-LAST:event_cariBtnActionPerformed

    private void cetakBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakBtnActionPerformed
    String filename = "Laporan_Komputer_" + System.currentTimeMillis() + ".pdf";
    PDFGenerator.generatePDF("Laporan Data Komputer", filename, jTable2);
}//GEN-LAST:event_cetakBtnActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int row = jTable2.getSelectedRow();
        if (row >= 0) {
            int currentRow = jTable2.getSelectedRow();
            // If clicking the same row twice, clear the form
            if (currentRow == lastSelectedRow) {
                clearForm();
                lastSelectedRow = -1; // Reset last selected row
                return;
            }
            lastSelectedRow = currentRow; // Update last selected row
            
            setButtonStates(false, true, true);
            model.setText(jTable2.getValueAt(row, 1).toString());
            jTextArea1.setText(jTable2.getValueAt(row, 2).toString());
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void clearForm() {
        model.setText("");
        jTextArea1.setText("");
        setButtonStates(true, false, false);
    }

    private void searchIfEmpty() {
        if (cariField.getText().trim().isEmpty()) {
            loadData();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Komputer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Komputer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Komputer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Komputer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Komputer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Input;
    private javax.swing.JPanel Table;
    private javax.swing.JButton btnHapus1;
    private javax.swing.JButton btnTambah3;
    private javax.swing.JButton btnUbah1;
    private javax.swing.JButton cariBtn;
    private javax.swing.JTextField cariField;
    private javax.swing.JButton cetakBtn;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField model;
    // End of variables declaration//GEN-END:variables
}
