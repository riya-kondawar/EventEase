
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EventList extends javax.swing.JFrame {

    public EventList() {
        if (!UserSession.isAdmin()) { // Assuming you have a session class
            JOptionPane.showMessageDialog(this, "Access denied.");
            new Login().setVisible(true);
            this.dispose();
        }
        initComponents();
    }

    private void refreshEventTable() {
        DefaultTableModel model = (DefaultTableModel) eventTable.getModel();
        model.setRowCount(0);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/events", "root", "Root@123")) {
            String sql = "SELECT * FROM events";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("event_id"),
                    rs.getString("name"),
                    rs.getString("club"),
                    rs.getString("type"),
                    rs.getString("date"),
                    rs.getString("venue"),
                    rs.getInt("seats"),
                    rs.getString("description")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error refreshing events: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnCreateEvent = new javax.swing.JButton();
        btnEditEvent = new javax.swing.JButton();
        btnDeleteEvent = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventTable = new javax.swing.JTable();
        ComboFilter = new javax.swing.JComboBox<>();
        btnsearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Events");

        btnCreateEvent.setBackground(new java.awt.Color(0, 204, 102));
        btnCreateEvent.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCreateEvent.setForeground(new java.awt.Color(51, 51, 51));
        btnCreateEvent.setText("REGISTER NEW EVENT");
        btnCreateEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateEventMouseClicked(evt);
            }
        });
        btnCreateEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEventActionPerformed(evt);
            }
        });

        btnEditEvent.setBackground(new java.awt.Color(0, 204, 102));
        btnEditEvent.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditEvent.setForeground(new java.awt.Color(51, 51, 51));
        btnEditEvent.setText("EDIT EVENT");
        btnEditEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditEventMouseClicked(evt);
            }
        });
        btnEditEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditEventActionPerformed(evt);
            }
        });

        btnDeleteEvent.setBackground(new java.awt.Color(0, 204, 102));
        btnDeleteEvent.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeleteEvent.setForeground(new java.awt.Color(51, 51, 51));
        btnDeleteEvent.setText("DELETE EVENT");
        btnDeleteEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteEventMouseClicked(evt);
            }
        });
        btnDeleteEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEventActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(588, 588, 588))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(436, 436, 436)
                        .addComponent(ComboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(340, 340, 340))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnCreateEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(118, 118, 118)
                            .addComponent(btnEditEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(128, 128, 128)
                            .addComponent(btnDeleteEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ComboFilter)
                    .addComponent(btnsearch, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1260, 670));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin Home.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateEventMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateEventMouseClicked

    private void btnCreateEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEventActionPerformed
        new ACreateEvent().setVisible(true); // Open event creation form
        this.dispose();
    }//GEN-LAST:event_btnCreateEventActionPerformed

    private void btnEditEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditEventMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditEventMouseClicked

    private void btnEditEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditEventActionPerformed
        int row = eventTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select an event to edit.");
            return;
        }

        int eventId = (int) eventTable.getValueAt(row, 0);
        String name = (String) eventTable.getValueAt(row, 1);
        String club = (String) eventTable.getValueAt(row, 2);
        String type = (String) eventTable.getValueAt(row, 3);
        String date = eventTable.getValueAt(row, 4).toString();
        String venue = (String) eventTable.getValueAt(row, 5);
        int seats = (int) eventTable.getValueAt(row, 6);
        String desc = (String) eventTable.getValueAt(row, 7);

        // Prompt user to edit fields using JOptionPane input dialogs
        String newName = JOptionPane.showInputDialog(this, "Edit Event Name:", name);
        String newClub = JOptionPane.showInputDialog(this, "Edit Club:", club);
        String newType = JOptionPane.showInputDialog(this, "Edit Type:", type);
        String newDate = JOptionPane.showInputDialog(this, "Edit Date (YYYY-MM-DD):", date);
        String newVenue = JOptionPane.showInputDialog(this, "Edit Venue:", venue);
        String newSeatsStr = JOptionPane.showInputDialog(this, "Edit Seats:", String.valueOf(seats));
        String newDesc = JOptionPane.showInputDialog(this, "Edit Description:", desc);

        // Validation
        if (newName == null || newClub == null || newType == null || newDate == null || newVenue == null || newSeatsStr == null || newDesc == null) {
            return; // User cancelled
        }

        try {
            int newSeats = Integer.parseInt(newSeatsStr);

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/events", "root", "Root@123")) {
                String sql = "UPDATE events SET name = ?, club = ?, type = ?, date = ?, venue = ?, seats = ?, description = ? WHERE event_id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, newName);
                pstmt.setString(2, newClub);
                pstmt.setString(3, newType);
                pstmt.setString(4, newDate);
                pstmt.setString(5, newVenue);
                pstmt.setInt(6, newSeats);
                pstmt.setString(7, newDesc);
                pstmt.setInt(8, eventId);

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Event updated successfully.");
                refreshEventTable(); // custom method to reload table
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format for seats.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Update failed: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditEventActionPerformed

    private void btnDeleteEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteEventMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteEventMouseClicked

    private void btnDeleteEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEventActionPerformed
        int row = eventTable.getSelectedRow();
        if (row != -1) {
            int eventId = (int) eventTable.getValueAt(row, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Delete this event?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/events", "root", "Root@123")) {
                    String query = "DELETE FROM events WHERE event_id = ?";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setInt(1, eventId);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Event deleted.");
                    refreshEventTable();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error deleting event: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select an event to delete.");
        }
    }//GEN-LAST:event_btnDeleteEventActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        new AdminDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeMouseClicked

    private void ComboFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboFilterActionPerformed
        String filterBy = (String) ComboFilter.getSelectedItem();
        String sql = "SELECT * FROM events";

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
                    rs.getString("date"),
                    rs.getString("venue"),
                    rs.getInt("seats"),
                    rs.getString("description")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Filter error: " + e.getMessage());
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
                String sql = "SELECT * FROM events WHERE name LIKE ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, "%" + searchTerm + "%");
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("event_id"),
                        rs.getString("name"),
                        rs.getString("club"),
                        rs.getString("type"),
                        rs.getString("date"),
                        rs.getString("venue"),
                        rs.getInt("seats"),
                        rs.getString("description")
                    });
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Search error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnsearchActionPerformed

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
            java.util.logging.Logger.getLogger(EventList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboFilter;
    private javax.swing.JButton btnCreateEvent;
    private javax.swing.JButton btnDeleteEvent;
    private javax.swing.JButton btnEditEvent;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnsearch;
    private javax.swing.JTable eventTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
