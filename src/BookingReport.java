
import javax.swing.table.DefaultTableModel;

//import com.mysql.cj.result.Row;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Row;
import java.io.FileOutputStream;
import java.io.File;

public class BookingReport extends javax.swing.JFrame {

//    private javax.swing.JButton btnExport; // Declare your button

    public BookingReport() {
        initComponents();
        setupTableModel();
        loadAllBookings();
        setLocationRelativeTo(null);
    }

    private void setupTableModel() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Booking ID", "User Name", "Event Name", "Booking Date", "Status", "Payment Status"}
        ) {
            Class[] types = new Class[]{
                Integer.class, String.class, String.class,
                Object.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        TableBookings.setModel(model);
    }

    private void loadAllBookings() {
        DefaultTableModel model = (DefaultTableModel) TableBookings.getModel();
        model.setRowCount(0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm");

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/events", "root", "Root@123")) {
            String sql = "SELECT b.booking_id, u.name AS user_name, e.name AS event_name, "
                    + "b.booking_date, b.status "
                    + "FROM bookings b "
                    + "JOIN signup u ON b.user_id = u.user_id "
                    + "JOIN events e ON b.event_id = e.event_id "
                    + "ORDER BY b.booking_date DESC";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String formattedDate = dateFormat.format(rs.getTimestamp("booking_date"));
                model.addRow(new Object[]{
                    rs.getInt("booking_id"),
                    rs.getString("user_name"),
                    rs.getString("event_name"),
                    formattedDate, // Formatted date
                    rs.getString("status")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        TableMyBookings = new javax.swing.JScrollPane();
        TableBookings = new javax.swing.JTable();
        ComboFilter = new javax.swing.JComboBox<>();
        btnsearch = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("User Booking Report");

        btnHome.setBackground(new java.awt.Color(153, 204, 255));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHome.setForeground(new java.awt.Color(51, 51, 51));
        btnHome.setText("Back To HOME");
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
        });
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        TableBookings.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TableBookings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Booking ID", "User Name", "Event Name", "Booking Date", "Status", "Payment Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableMyBookings.setViewportView(TableBookings);

        ComboFilter.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ComboFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Date", "Type", "Club" }));
        ComboFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboFilterActionPerformed(evt);
            }
        });

        btnsearch.setBackground(new java.awt.Color(255, 255, 255));
        btnsearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsearch.setForeground(new java.awt.Color(51, 51, 51));
        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnsearch.setBorder(null);
        btnsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsearchMouseClicked(evt);
            }
        });
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        btnExport.setBackground(new java.awt.Color(153, 204, 255));
        btnExport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExport.setForeground(new java.awt.Color(51, 51, 51));
        btnExport.setText("EXPORT");
        btnExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportMouseClicked(evt);
            }
        });
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(439, 439, 439)
                            .addComponent(ComboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(451, 451, 451)
                            .addComponent(jLabel2))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addComponent(TableMyBookings, javax.swing.GroupLayout.PREFERRED_SIZE, 1145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ComboFilter, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btnsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(TableMyBookings, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1260, 670));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin Home.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, -1, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        new UserDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void ComboFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboFilterActionPerformed
        String filter = (String) ComboFilter.getSelectedItem();
        String condition = "";

        switch (filter) {
            case "Today":
                condition = "DATE(b.booking_date) = CURDATE()";
                break;
            case "This Week":
                condition = "YEARWEEK(b.booking_date) = YEARWEEK(CURDATE())";
                break;
            case "Confirmed":
                condition = "b.status = 'CONFIRMED'";
                break;
            case "Cancelled":
                condition = "b.status = 'CANCELLED'";
                break;
            case "Paid":
                condition = "b.payment_status = 'PAID'";
                break;
            case "Unpaid":
                condition = "b.payment_status = 'UNPAID'";
                break;
        }

        String sql = "SELECT b.booking_id, u.name AS user_name, e.name AS event_name, b.booking_date, b.status, b.payment_status "
                + "FROM bookings b "
                + "JOIN signup u ON b.user_id = u.user_id "
                + "JOIN events e ON b.event_id = e.event_id "
                + (condition.isEmpty() ? "" : "WHERE " + condition)
                + " ORDER BY b.booking_date DESC";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/events", "root", "Root@123")) {
            DefaultTableModel model = (DefaultTableModel) TableBookings.getModel();
            model.setRowCount(0);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("booking_id"),
                    rs.getString("user_name"),
                    rs.getString("event_name"),
                    rs.getTimestamp("booking_date"),
                    rs.getString("status"),
                    rs.getString("payment_status")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error applying filter: " + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ComboFilterActionPerformed

    private void btnsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsearchMouseClicked

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        String searchTerm = JOptionPane.showInputDialog(this, "Search by user or event name:");
        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) TableBookings.getModel();
            model.setRowCount(0);

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/events", "root", "Root@123")) {
                String sql = "SELECT b.booking_id, u.name as user_name, e.name as event_name, "
                        + "b.booking_date, b.status, b.payment_status "
                        + "FROM bookings b "
                        + "JOIN users u ON b.user_id = u.user_id "
                        + "JOIN events e ON b.event_id = e.event_id "
                        + "WHERE u.name LIKE ? OR e.name LIKE ? "
                        + "ORDER BY b.booking_date DESC";

                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, "%" + searchTerm + "%");
                pst.setString(2, "%" + searchTerm + "%");
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("booking_id"),
                        rs.getString("user_name"),
                        rs.getString("event_name"),
                        rs.getTimestamp("booking_date"),
                        rs.getString("status"),
                        rs.getString("payment_status")
                    });
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this,
                        "Search error: " + e.getMessage(),
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportMouseClicked

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save as Excel");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xlsx"));

        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (!file.getName().endsWith(".xlsx")) {
                file = new File(file.getParentFile(), file.getName() + ".xlsx");
            }

            try (XSSFWorkbook workbook = new XSSFWorkbook()) {
                XSSFSheet sheet = workbook.createSheet("Bookings Report");

                // Create header row
                DefaultTableModel model = (DefaultTableModel) TableBookings.getModel();
                Row headerRow = sheet.createRow(0);
                for (int col = 0; col < model.getColumnCount(); col++) {
                    headerRow.createCell(col).setCellValue(model.getColumnName(col));
                }

                // Add data rows
                for (int row = 0; row < model.getRowCount(); row++) {
                    Row dataRow = sheet.createRow(row + 1);
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        Object value = model.getValueAt(row, col);
                        dataRow.createCell(col).setCellValue(value != null ? value.toString() : "");
                    }
                }

                // Auto-size columns
                for (int col = 0; col < model.getColumnCount(); col++) {
                    sheet.autoSizeColumn(col);
                }

                // Write to file
                try (FileOutputStream outputStream = new FileOutputStream(file)) {
                    workbook.write(outputStream);
                    JOptionPane.showMessageDialog(this,
                            "Report exported successfully to:\n" + file.getAbsolutePath(),
                            "Export Successful",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Error exporting report: " + e.getMessage(),
                        "Export Error",
                        JOptionPane.ERROR_MESSAGE);

            }
        }

    }//GEN-LAST:event_btnExportActionPerformed

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
            java.util.logging.Logger.getLogger(BookingReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(BookingReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookingReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboFilter;
    private javax.swing.JTable TableBookings;
    private javax.swing.JScrollPane TableMyBookings;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
