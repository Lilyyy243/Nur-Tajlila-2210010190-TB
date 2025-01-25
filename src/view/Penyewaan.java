/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import database.Koneksi;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import utils.*;

public class Penyewaan extends javax.swing.JFrame {

    private Connection conn;
    private DefaultTableModel tableModel;

    /**
     * Creates new form Penyewaan
     */
    public Penyewaan() {
        initComponents();
        setLocationRelativeTo(null);
        
        conn = Koneksi.getConnection();
        setupTable();
        loadData();
        loadComboBoxes();
        setButtonStates(true, false, false); // Initially enable only tambah button
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                new MainMenu().setVisible(true);
            }
        });
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ubahBtn = new javax.swing.JButton();
        hapusBtn = new javax.swing.JButton();
        tambahBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pelanggan = new javax.swing.JComboBox<>();
        komputer = new javax.swing.JComboBox<>();
        totalBiaya = new javax.swing.JTextField();
        tglSewa = new com.toedter.calendar.JDateChooser();
        tglKemabali = new com.toedter.calendar.JDateChooser();
        Table = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cariField = new javax.swing.JTextField();
        cariBtn = new javax.swing.JButton();
        cetakBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(0, 1));

        Input.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        java.awt.GridBagLayout InputLayout = new java.awt.GridBagLayout();
        InputLayout.columnWidths = new int[] {0, 15, 0, 15, 0, 15, 0, 15, 0};
        InputLayout.rowHeights = new int[] {0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0};
        Input.setLayout(InputLayout);

        jLabel7.setText("Pelanggan :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        Input.add(jLabel7, gridBagConstraints);

        jLabel8.setText("Model komputer :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        Input.add(jLabel8, gridBagConstraints);

        jLabel9.setText("Tanggal Sewa :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        Input.add(jLabel9, gridBagConstraints);

        ubahBtn.setBackground(new java.awt.Color(102, 102, 102));
        ubahBtn.setForeground(new java.awt.Color(255, 255, 255));
        ubahBtn.setText("Ubah");
        ubahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        Input.add(ubahBtn, gridBagConstraints);

        hapusBtn.setBackground(new java.awt.Color(204, 0, 0));
        hapusBtn.setForeground(new java.awt.Color(255, 255, 255));
        hapusBtn.setText("Hapus");
        hapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        Input.add(hapusBtn, gridBagConstraints);

        tambahBtn.setBackground(new java.awt.Color(0, 153, 51));
        tambahBtn.setForeground(new java.awt.Color(242, 242, 242));
        tambahBtn.setText("Tambahkan");
        tambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        Input.add(tambahBtn, gridBagConstraints);

        jLabel1.setText("Tanggal Pengembalian :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        Input.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Total Biaya :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        Input.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        Input.add(pelanggan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        Input.add(komputer, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        Input.add(totalBiaya, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        Input.add(tglSewa, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        Input.add(tglKemabali, gridBagConstraints);

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
        gridBagConstraints.ipadx = 240;
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
        gridBagConstraints.ipadx = 30;
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

        jScrollPane4.setPreferredSize(new java.awt.Dimension(600, 200));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTable2.setPreferredSize(new java.awt.Dimension(90, 500));
        jTable2.setShowGrid(true);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        Table.add(jScrollPane4, gridBagConstraints);

        getContentPane().add(Table);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void tambahBtnActionPerformed(java.awt.event.ActionEvent evt) {
    // Validate selections
    if (pelanggan.getSelectedItem() == null || komputer.getSelectedItem() == null) {
        ValidationUtils.showError(this, "Pilih pelanggan dan komputer!");
        return;
    }

    // Validate dates
    if (tglSewa.getDate() == null || tglKemabali.getDate() == null) {
        ValidationUtils.showError(this, "Tanggal sewa dan tanggal kembali harus diisi!");
        return;
    }

    if (!ValidationUtils.isValidDate(tglSewa.getDate(), tglKemabali.getDate())) {
        ValidationUtils.showError(this, "Tanggal kembali harus setelah tanggal sewa!");
        return;
    }

    // Validate total biaya
    if (ValidationUtils.isEmptyField(totalBiaya) || !ValidationUtils.isValidNumber(totalBiaya.getText())) {
        ValidationUtils.showError(this, "Total biaya harus berupa angka!");
        return;
    }

    try {
        // Validate form data
        if (pelanggan.getSelectedItem() == null || 
            komputer.getSelectedItem() == null || 
            tglSewa.getDate() == null || 
            tglKemabali.getDate() == null || 
            totalBiaya.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Semua field harus diisi!", 
                "Validasi Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "INSERT INTO penyewaan (id_pelanggan, id_pc, tanggal_sewa, tanggal_kembali, total_biaya) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ComboItem selectedPelanggan = (ComboItem) pelanggan.getSelectedItem();
        ComboItem selectedPC = (ComboItem) komputer.getSelectedItem();
        
        ps.setInt(1, selectedPelanggan.getId());
        ps.setInt(2, selectedPC.getId());
        ps.setDate(3, new java.sql.Date(tglSewa.getDate().getTime()));
        ps.setDate(4, new java.sql.Date(tglKemabali.getDate().getTime()));
        
        try {
            double biaya = Double.parseDouble(totalBiaya.getText());
            ps.setDouble(5, biaya);
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Total biaya harus berupa angka!", 
                "Validasi Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ps.executeUpdate();
        loadData();
        clearForm();
        setButtonStates(true, false, false);
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Data berhasil ditambahkan", 
            "Sukses", 
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
        ValidationUtils.showSuccess(this, "Data penyewaan berhasil ditambahkan");
    } catch (SQLException e) {
        ValidationUtils.showError(this, "Error: " + e.getMessage());
    }
}//GEN-LAST:event_tambahBtnActionPerformed

private void ubahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahBtnActionPerformed
    int row = jTable2.getSelectedRow();
    if (row < 0) {
        ValidationUtils.showError(this, "Pilih data yang akan diubah!");
        return;
    }

    // Validate selections
    if (pelanggan.getSelectedItem() == null || komputer.getSelectedItem() == null) {
        ValidationUtils.showError(this, "Pilih pelanggan dan komputer!");
        return;
    }

    // Validate dates
    if (tglSewa.getDate() == null || tglKemabali.getDate() == null) {
        ValidationUtils.showError(this, "Tanggal sewa dan tanggal kembali harus diisi!");
        return;
    }

    if (!ValidationUtils.isValidDate(tglSewa.getDate(), tglKemabali.getDate())) {
        ValidationUtils.showError(this, "Tanggal kembali harus setelah tanggal sewa!");
        return;
    }

    // Validate total biaya
    if (ValidationUtils.isEmptyField(totalBiaya) || !ValidationUtils.isValidNumber(totalBiaya.getText())) {
        ValidationUtils.showError(this, "Total biaya harus berupa angka!");
        return;
    }

    try {
        if (row >= 0) {
            int id = (int) jTable2.getValueAt(row, 0);
            String sql = "UPDATE penyewaan SET id_pelanggan=?, id_pc=?, tanggal_sewa=?, tanggal_kembali=?, total_biaya=? WHERE id_penyewaan=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ComboItem selectedPelanggan = (ComboItem) pelanggan.getSelectedItem();
            ComboItem selectedPC = (ComboItem) komputer.getSelectedItem();
            
            ps.setInt(1, selectedPelanggan.getId());
            ps.setInt(2, selectedPC.getId());
            ps.setDate(3, new java.sql.Date(tglSewa.getDate().getTime()));
            ps.setDate(4, new java.sql.Date(tglKemabali.getDate().getTime()));
            ps.setDouble(5, Double.parseDouble(totalBiaya.getText()));
            ps.setInt(6, id);
            
            ps.executeUpdate();
            loadData();
            clearForm();
            setButtonStates(true, false, false);
        }
        ValidationUtils.showSuccess(this, "Data penyewaan berhasil diubah");
    } catch (SQLException e) {
        ValidationUtils.showError(this, "Error: " + e.getMessage());
    }
}//GEN-LAST:event_ubahBtnActionPerformed

private void hapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBtnActionPerformed
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
        if (row >= 0) {
            try {
                int id = (int) jTable2.getValueAt(row, 0);
                String sql = "DELETE FROM penyewaan WHERE id_penyewaan=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                loadData();
                clearForm();
                setButtonStates(true, false, false);
                ValidationUtils.showSuccess(this, "Data penyewaan berhasil dihapus");
            } catch (SQLException e) {
                ValidationUtils.showError(this, "Error: " + e.getMessage());
            }
        }
    }
}//GEN-LAST:event_hapusBtnActionPerformed

    private void cariBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBtnActionPerformed
        String keyword = cariField.getText();
        tableModel.setRowCount(0);
        try {
            String sql = "SELECT p.*, pl.nama as nama_pelanggan, k.model as model_pc " +
                        "FROM penyewaan p " +
                        "JOIN pelanggan pl ON p.id_pelanggan = pl.id_pelanggan " +
                        "JOIN komputer k ON p.id_pc = k.id_pc " +
                        "WHERE pl.nama LIKE ? OR k.model LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id_penyewaan"),
                    rs.getString("nama_pelanggan"),
                    rs.getString("model_pc"),
                    rs.getDate("tanggal_sewa"),
                    rs.getDate("tanggal_kembali"),
                    rs.getDouble("total_biaya")
                };
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("Error searching data: " + e.getMessage());
        }
    }//GEN-LAST:event_cariBtnActionPerformed

    private void cetakBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cetakBtnActionPerformed

private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {
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
        try {
            int id = (int) jTable2.getValueAt(row, 0);
            String sql = "SELECT * FROM penyewaan WHERE id_penyewaan=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                // Set pelanggan combobox
                for (int i = 0; i < pelanggan.getItemCount(); i++) {
                    ComboItem item = pelanggan.getItemAt(i);
                    if (item.getId() == rs.getInt("id_pelanggan")) {
                        pelanggan.setSelectedIndex(i);
                        break;
                    }
                }
                
                // Set komputer combobox
                for (int i = 0; i < komputer.getItemCount(); i++) {
                    ComboItem item = komputer.getItemAt(i);
                    if (item.getId() == rs.getInt("id_pc")) {
                        komputer.setSelectedIndex(i);
                        break;
                    }
                }
                
                tglSewa.setDate(rs.getDate("tanggal_sewa"));
                tglKemabali.setDate(rs.getDate("tanggal_kembali"));
                totalBiaya.setText(String.valueOf(rs.getDouble("total_biaya")));
            }
        } catch (SQLException e) {
            System.out.println("Error loading selection: " + e.getMessage());
        }
    }
}

// Add this field to the class
private int lastSelectedRow = -1;

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
            java.util.logging.Logger.getLogger(Penyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penyewaan().setVisible(true);
            }
        });
    }

    private void setupTable() {
        String[] columns = {"ID", "Pelanggan", "PC", "Tanggal Sewa", "Tanggal Kembali", "Total Biaya"};
        tableModel = new DefaultTableModel(columns, 0);
        jTable2.setModel(tableModel);
        // Hide the ID column but keep it for reference
        jTable2.getColumnModel().getColumn(0).setMinWidth(0);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(0).setWidth(0);
    }

    private void loadComboBoxes() {
        try {
            // Load Pelanggan
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_pelanggan, nama FROM pelanggan");
            pelanggan.removeAllItems();
            while (rs.next()) {
                pelanggan.addItem(new ComboItem(rs.getInt("id_pelanggan"), rs.getString("nama")));
            }

            // Load Komputer
            rs = st.executeQuery("SELECT id_pc, model FROM komputer");
            komputer.removeAllItems();
            while (rs.next()) {
                komputer.addItem(new ComboItem(rs.getInt("id_pc"), rs.getString("model")));
            }
        } catch (SQLException e) {
            System.out.println("Error loading combos: " + e.getMessage());
        }
    }

    private void loadData() {
        tableModel.setRowCount(0);
        try {
            String sql = "SELECT p.*, pl.nama as nama_pelanggan, k.model as model_pc " +
                        "FROM penyewaan p " +
                        "JOIN pelanggan pl ON p.id_pelanggan = pl.id_pelanggan " +
                        "JOIN komputer k ON p.id_pc = k.id_pc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id_penyewaan"),  // Hidden ID column
                    rs.getString("nama_pelanggan"),
                    rs.getString("model_pc"),
                    rs.getDate("tanggal_sewa"),
                    rs.getDate("tanggal_kembali"),
                    rs.getDouble("total_biaya")
                };
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    private void clearForm() {
        pelanggan.setSelectedIndex(0);
        komputer.setSelectedIndex(0);
        tglSewa.setDate(null);
        tglKemabali.setDate(null);
        totalBiaya.setText("");
        setButtonStates(true, false, false);
    }

    private void setButtonStates(boolean tambahEnabled, boolean ubahEnabled, boolean hapusEnabled) {
        tambahBtn.setEnabled(tambahEnabled);
        ubahBtn.setEnabled(ubahEnabled);
        hapusBtn.setEnabled(hapusEnabled);
    }

    private class ComboItem {
        private int id;
        private String description;

        public ComboItem(int id, String description) {
            this.id = id;
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }

        public int getId() {
            return id;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Input;
    private javax.swing.JPanel Table;
    private javax.swing.JButton cariBtn;
    private javax.swing.JTextField cariField;
    private javax.swing.JButton cetakBtn;
    private javax.swing.JButton hapusBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<Penyewaan.ComboItem> komputer;
    private javax.swing.JComboBox<Penyewaan.ComboItem> pelanggan;
    private javax.swing.JButton tambahBtn;
    private com.toedter.calendar.JDateChooser tglKemabali;
    private com.toedter.calendar.JDateChooser tglSewa;
    private javax.swing.JTextField totalBiaya;
    private javax.swing.JButton ubahBtn;
    // End of variables declaration//GEN-END:variables
}
