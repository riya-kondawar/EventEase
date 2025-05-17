
import java.beans.Statement;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MyBookings extends javax.swing.JFrame {

    private int userId;
    private javax.swing.JLabel statusLabel; // Add this if you're using it

    public MyBookings(int userId) {
        this.userId = userId;
        initComponents();
        setupBookingsTable();
        loadUserBookings();
        setLocationRelativeTo(null);
    }
    
    
    private void setupBookingsTable() {
        // Set up the table model for bookings
        DefaultTableModel model = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Booking ID", "Event Name", "Date", "Venue", "Booking Date", "Status"}
        ) {
            Class[] types = new Class[]{
                Integer.class, String.class, Object.class, 
                String.class, Object.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        eventTable.setModel(model);
    }

private void loadUserBookings() {
    DefaultTableModel model = (DefaultTableModel) eventTable.getModel();
    model.setRowCount(0); // Clear existing data

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/events", "root", "Root@123")) {
        // First check if bookings table exists
        if (!tableExists(conn, "bookings")) {
            JOptionPane.showMessageDialog(this,
                "Bookings system not initialized. Please contact admin.",
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "SELECT b.booking_id, e.name, e.date, e.venue, b.booking_date, b.status " +
                     "FROM bookings b JOIN events e ON b.event_id = e.event_id " +
                     "WHERE b.user_id = ? " +
                     "ORDER BY e.date DESC";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, userId);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("booking_id"),
                rs.getString("name"),
                rs.getDate("date"),
                rs.getString("venue"),
                rs.getDate("booking_date"),
                rs.getString("status")
            });
        }

        if (statusLabel != null) {
            statusLabel.setText("Showing " + model.getRowCount() + " bookings");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
            "Error loading bookings: " + e.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE);
    }
}

// Helper method to check if table exists
private boolean tableExists(Connection conn, String tableName) throws SQLException {
    if (conn == null || tableName == null || tableName.trim().isEmpty()) {
        return false;
    }

    // Use a query that works across most databases
    try (java.sql.Statement stmt = conn.createStatement()) {
        return true;
    } catch (SQLException e) {
        // Check if the error indicates the table doesn't exist
        String errorMsg = e.getMessage().toLowerCase();
        if (errorMsg.contains("exist") || errorMsg.contains("not found") || 
            errorMsg.contains("unknown table")) {
            return false;
        }
        throw e; // Re-throw unexpected errors
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        TableMyBookings = new javax.swing.JScrollPane();
        eventTable = new javax.swing.JTable();
        ComboFilter = new javax.swing.JComboBox<>();
        btnsearch = new javax.swing.JButton();
        btnRegisterForEvent = new javax.swing.JButton();
        btnCancelRegistration = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextAreaAnnouncements = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("My Event Registrations");

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

        eventTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        eventTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Event Name", "Club", "Type", "Date", "Venue", "Seats", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableMyBookings.setViewportView(eventTable);

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

        btnRegisterForEvent.setBackground(new java.awt.Color(0, 204, 102));
        btnRegisterForEvent.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegisterForEvent.setForeground(new java.awt.Color(51, 51, 51));
        btnRegisterForEvent.setText("REGISTER FOR EVENT");
        btnRegisterForEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterForEventMouseClicked(evt);
            }
        });
        btnRegisterForEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterForEventActionPerformed(evt);
            }
        });

        btnCancelRegistration.setBackground(new java.awt.Color(255, 153, 153));
        btnCancelRegistration.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelRegistration.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelRegistration.setText("CANCEL REGISTRATION");
        btnCancelRegistration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelRegistrationMouseClicked(evt);
            }
        });
        btnCancelRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelRegistrationActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Announcements");

        TextAreaAnnouncements.setColumns(20);
        TextAreaAnnouncements.setRows(5);
        jScrollPane2.setViewportView(TextAreaAnnouncements);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(TableMyBookings, javax.swing.GroupLayout.PREFERRED_SIZE, 1145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(436, 436, 436)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ComboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(294, 294, 294)
                                .addComponent(btnCancelRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128)
                                .addComponent(btnRegisterForEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)))
                        .addGap(146, 146, 146)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
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
                .addGap(39, 39, 39)
                .addComponent(TableMyBookings, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegisterForEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGap(93, 93, 93))
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
        String filterBy = (String) ComboFilter.getSelectedItem();
        String sql = "SELECT * FROM events WHERE date >= CURDATE()";

        switch (filterBy) {
            case "Date":
                sql += " ORDER BY date";
                break;
            case "Type":
                sql += " ORDER BY type";
                break;
            case "Club":
                sql += " ORDER BY club";
                break;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/events", "root", "Root@123")) {
            DefaultTableModel model = (DefaultTableModel) eventTable.getModel();
            model.setRowCount(0);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("event_id"),
                    rs.getString("name"),
                    rs.getString("club"),
                    rs.getString("type"),
                    rs.getDate("date"),
                    rs.getString("venue"),
                    rs.getInt("seats"),
                    rs.getString("description")
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
        String searchTerm = JOptionPane.showInputDialog(this, "Search events by name:");
        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) eventTable.getModel();
            model.setRowCount(0);

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/events", "root", "Root@123")) {
                String sql = "SELECT * FROM events WHERE name LIKE ? AND date >= CURDATE()";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, "%" + searchTerm + "%");
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("event_id"),
                        rs.getString("name"),
                        rs.getString("club"),
                        rs.getString("type"),
                        rs.getDate("date"),
                        rs.getString("venue"),
                        rs.getInt("seats"),
                        rs.getString("description")
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

    private void btnRegisterForEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterForEventMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegisterForEventMouseClicked

    private void btnRegisterForEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterForEventActionPerformed
        int selectedRow = eventTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,
                    "Please select an event to register",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int eventId = (int) eventTable.getValueAt(selectedRow, 0);
        int userId = UserSession.getUserId();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/events", "root", "Root@123")) {
            // Check if already registered
            String checkSql = "SELECT * FROM bookings WHERE user_id = ? AND event_id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setInt(1, userId);
            checkStmt.setInt(2, eventId);

            if (checkStmt.executeQuery().next()) {
                JOptionPane.showMessageDialog(this,
                        "You are already registered for this event",
                        "Already Registered",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Register for event
            String insertSql = "INSERT INTO bookings (user_id, event_id, booking_date) VALUES (?, ?, NOW())";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setInt(1, userId);
            insertStmt.setInt(2, eventId);

            int rowsAffected = insertStmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this,
                        "Successfully registered for the event!",
                        "Registration Successful",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Registration error: " + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnRegisterForEventActionPerformed

    private void btnCancelRegistrationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelRegistrationMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelRegistrationMouseClicked

    private void btnCancelRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelRegistrationActionPerformed
         int selectedRow = eventTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,
                "Please select a booking to cancel",
                "No Selection",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        int bookingId = (int) eventTable.getValueAt(selectedRow, 0);
        String eventName = (String) eventTable.getValueAt(selectedRow, 1);
        String status = (String) eventTable.getValueAt(selectedRow, 5);

        // Check if already cancelled
        if ("CANCELLED".equalsIgnoreCase(status)) {
            JOptionPane.showMessageDialog(this,
                "This booking is already cancelled",
                "Cancellation Error",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
            "Cancel your registration for: " + eventName + "?",
            "Confirm Cancellation",
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/events", "root", "Root@123")) {
                String sql = "UPDATE bookings SET status = 'CANCELLED' WHERE booking_id = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, bookingId);
                
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this,
                        "Registration cancelled successfully",
                        "Cancellation Complete",
                        JOptionPane.INFORMATION_MESSAGE);
                    loadUserBookings(); // Refresh the table
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this,
                    "Error cancelling booking: " + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCancelRegistrationActionPerformed

    public static void main(String args[]) {
      /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MyBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // For testing only - in production, use UserSession.getUserId()
                new MyBookings(1).setVisible(true); // Replace with actual user ID
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboFilter;
    private javax.swing.JScrollPane TableMyBookings;
    private javax.swing.JTextArea TextAreaAnnouncements;
    private javax.swing.JButton btnCancelRegistration;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnRegisterForEvent;
    private javax.swing.JButton btnsearch;
    private javax.swing.JTable eventTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
