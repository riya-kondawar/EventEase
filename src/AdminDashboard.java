
import javax.swing.JFrame;
import com.eventease.utils.DBConnection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AdminDashboard extends javax.swing.JFrame {
public AdminDashboard() {
    // Enhanced session validation
    if (!UserSession.isLoggedIn() || !UserSession.isAdmin()) {
        JOptionPane.showMessageDialog(null,
            UserSession.isLoggedIn() ? "Access denied - Admin only" : "Session expired",
            "Authentication Error",
            JOptionPane.ERROR_MESSAGE);
        new Login().setVisible(true);
        dispose();
        return;
    }

        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Prevent accidental closing

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnManageEvents = new javax.swing.JButton();
        btnViewBookings = new javax.swing.JButton();
        btnFeedbackReport = new javax.swing.JButton();
        btnManageUsers = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboards/8.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 410, 310));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboards/17.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 400, 410, 310));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboards/18.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 50, 410, 310));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboards/16.jpg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, 410, 310));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/all pages background.png"))); // NOI18N
        jLabel11.setText("jLabel3");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, 410, 310));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/all pages background.png"))); // NOI18N
        jLabel12.setText("jLabel3");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 50, 410, 310));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/all pages background.png"))); // NOI18N
        jLabel13.setText("jLabel3");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 400, 410, 310));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/all pages background.png"))); // NOI18N
        jLabel14.setText("jLabel3");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 410, 310));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnManageEvents.setBackground(new java.awt.Color(102, 255, 102));
        btnManageEvents.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnManageEvents.setForeground(new java.awt.Color(51, 51, 51));
        btnManageEvents.setText("MANAGE EVENT");
        btnManageEvents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManageEventsMouseClicked(evt);
            }
        });
        btnManageEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEventsActionPerformed(evt);
            }
        });
        jPanel1.add(btnManageEvents, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 200, 48));

        btnViewBookings.setBackground(new java.awt.Color(204, 153, 255));
        btnViewBookings.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnViewBookings.setForeground(new java.awt.Color(51, 51, 51));
        btnViewBookings.setText("VIEW BOOKINGS");
        btnViewBookings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewBookingsMouseClicked(evt);
            }
        });
        btnViewBookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBookingsActionPerformed(evt);
            }
        });
        jPanel1.add(btnViewBookings, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 200, 48));

        btnFeedbackReport.setBackground(new java.awt.Color(51, 255, 255));
        btnFeedbackReport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFeedbackReport.setForeground(new java.awt.Color(51, 51, 51));
        btnFeedbackReport.setText("FEEDBACK REPORTS");
        btnFeedbackReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFeedbackReportMouseClicked(evt);
            }
        });
        btnFeedbackReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedbackReportActionPerformed(evt);
            }
        });
        jPanel1.add(btnFeedbackReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 200, 48));

        btnManageUsers.setBackground(new java.awt.Color(255, 255, 153));
        btnManageUsers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnManageUsers.setForeground(new java.awt.Color(51, 51, 51));
        btnManageUsers.setText("MANAGE USERS");
        btnManageUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManageUsersMouseClicked(evt);
            }
        });
        btnManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageUsersActionPerformed(evt);
            }
        });
        jPanel1.add(btnManageUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 200, 48));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Dashboard");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, 48));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("ADMIN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, 48));

        btnLogout.setBackground(new java.awt.Color(255, 204, 204));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(51, 51, 51));
        btnLogout.setText("LOGOUT");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 200, 48));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 350, 670));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin Home.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUsersActionPerformed
        new UserManagement().setVisible(true);
        this.dispose(); // optional
    }//GEN-LAST:event_btnManageUsersActionPerformed

    private void btnManageUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageUsersMouseClicked
        try {
            if (!UserSession.isLoggedIn()) {
                throw new Exception("Session expired. Please login again.");
            }

            Profile profile = new Profile(UserSession.getUserId());
            profile.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            handleError(e);
        }
    }//GEN-LAST:event_btnManageUsersMouseClicked

    private void btnFeedbackReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedbackReportActionPerformed
        new FeedbackReport().setVisible(true);
        this.dispose(); // optional
    }//GEN-LAST:event_btnFeedbackReportActionPerformed

    private void btnFeedbackReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeedbackReportMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFeedbackReportMouseClicked

    private void btnViewBookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBookingsActionPerformed
        new BookingReport().setVisible(true);
        this.dispose(); // optional
    }//GEN-LAST:event_btnViewBookingsActionPerformed

    private void btnViewBookingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewBookingsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewBookingsMouseClicked

    private void btnManageEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEventsActionPerformed
        new ACreateEvent().setVisible(true);
        this.dispose(); // optional
    }//GEN-LAST:event_btnManageEventsActionPerformed

    private void btnManageEventsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageEventsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManageEventsMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private boolean hasBookings(int userId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM bookings WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, userId);
            try (ResultSet rs = pst.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    private void handleError(Exception e) {
        if (e instanceof SQLException) {
            JOptionPane.showMessageDialog(this,
                    "Database error: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            UserSession.logout();
            new Login().setVisible(true);
            dispose();
        }
    }

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFeedbackReport;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageEvents;
    private javax.swing.JButton btnManageUsers;
    private javax.swing.JButton btnViewBookings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
