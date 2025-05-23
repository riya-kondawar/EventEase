
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Reliance Digital
 */
public class BrowseEvents extends javax.swing.JFrame {

    public BrowseEvents() {
        initComponents();
        loadEvents(); // Load events when form opens
        setLocationRelativeTo(null); // Center the window
    }

    private void loadEvents() {
        DefaultTableModel model = (DefaultTableModel) eventTable.getModel();
        model.setRowCount(0); // Clear existing data

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/events", "root", "Root@123")) {
            String sql = "SELECT * FROM events WHERE date >= CURDATE() ORDER BY date";
            PreparedStatement pst = conn.prepareStatement(sql);
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
                    "Error loading events: " + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventTable = new javax.swing.JTable();
        ComboFilter = new javax.swing.JComboBox<>();
        btnsearch = new javax.swing.JButton();
        btnRegisterForEvent = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Events");

        btnHome.setBackground(new java.awt.Color(0, 204, 102));
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
        jScrollPane1.setViewportView(eventTable);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(588, 588, 588))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegisterForEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(436, 436, 436)
                            .addComponent(ComboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ComboFilter, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btnsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegisterForEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1260, 670));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin Home.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private boolean isEventAvailable(int eventId) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/events", "root", "Root@123")) {
            // Check if event exists and has available seats
            String sql = "SELECT seats FROM events WHERE event_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, eventId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int availableSeats = rs.getInt("seats");
                if (availableSeats > 0) {
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error checking event availability: " + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void btnRegisterForEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterForEventMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegisterForEventMouseClicked

    private boolean userExists(int userId) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/events", "root", "Root@123")) {
            String sql = "SELECT 1 FROM users WHERE user_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, userId);
            return pst.executeQuery().next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error verifying user account: " + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void btnRegisterForEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterForEventActionPerformed
        // 1. Check if user is logged in
        if (!UserSession.isLoggedIn()) {
            JOptionPane.showMessageDialog(this,
                    "Please login first to register for events",
                    "Not Logged In",
                    JOptionPane.WARNING_MESSAGE);
            new Login().setVisible(true);
            this.dispose();
            return;
        }

        // 2. Check if event is selected
        int selectedRow = eventTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,
                    "Please select an event to register",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 3. Get event and user IDs
        int eventId = (int) eventTable.getValueAt(selectedRow, 0);
        int userId = UserSession.getUserId();

        // 4. Execute the transaction
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/events", "root", "Root@123")) {
            conn.setAutoCommit(false); // Start transaction

            try {
                // Check if seats are available
                String checkSeatsSql = "SELECT seats FROM events WHERE event_id = ? FOR UPDATE";
                PreparedStatement checkSeatsStmt = conn.prepareStatement(checkSeatsSql);
                checkSeatsStmt.setInt(1, eventId);
                ResultSet rs = checkSeatsStmt.executeQuery();

                if (!rs.next() || rs.getInt("seats") <= 0) {
                    JOptionPane.showMessageDialog(this,
                            "No available seats for this event",
                            "Event Full",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Check if already registered
                String checkRegSql = "SELECT 1 FROM bookings WHERE user_id = ? AND event_id = ?";
                PreparedStatement checkRegStmt = conn.prepareStatement(checkRegSql);
                checkRegStmt.setInt(1, userId);
                checkRegStmt.setInt(2, eventId);

                if (checkRegStmt.executeQuery().next()) {
                    JOptionPane.showMessageDialog(this,
                            "You are already registered for this event",
                            "Duplicate Registration",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Create booking
                String insertSql = "INSERT INTO bookings (user_id, event_id, booking_date) VALUES (?, ?, NOW())";
                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                insertStmt.setInt(1, userId);
                insertStmt.setInt(2, eventId);
                insertStmt.executeUpdate();

                // Decrement available seats
                String updateSeatsSql = "UPDATE events SET seats = seats - 1 WHERE event_id = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateSeatsSql);
                updateStmt.setInt(1, eventId);
                updateStmt.executeUpdate();

                conn.commit(); // Commit transaction

                JOptionPane.showMessageDialog(this,
                        "Successfully registered for the event!",
                        "Registration Successful",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException e) {
                conn.rollback(); // Rollback on error
                if (e.getMessage().contains("foreign key constraint fails")) {
                    JOptionPane.showMessageDialog(this,
                            "Your account is not properly registered in our system",
                            "Account Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Registration error: " + e.getMessage(),
                            "Database Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } finally {
                conn.setAutoCommit(true); // Reset auto-commit
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Database connection error: " + e.getMessage(),
                    "Connection Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegisterForEventActionPerformed

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
            java.util.logging.Logger.getLogger(BrowseEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrowseEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrowseEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrowseEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BrowseEvents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboFilter;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnRegisterForEvent;
    private javax.swing.JButton btnsearch;
    private javax.swing.JTable eventTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
