import javax.swing.JFrame;
import com.eventease.utils.DBConnection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UserDashboard extends javax.swing.JFrame {

public UserDashboard() {
       // Enhanced session validation
        if (!UserSession.isLoggedIn() || !UserSession.isStudent()) {
            JOptionPane.showMessageDialog(null, 
                UserSession.isLoggedIn() ? "Access denied - Student only" : "Session expired",
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

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnBrowseEvents = new javax.swing.JButton();
        btnMyBookings = new javax.swing.JButton();
        btnSubmitFeedback = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboards/13.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, 410, 310));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboards/22.jpeg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 50, 410, 310));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboards/16.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 400, 410, 310));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboards/24.jpeg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 410, 310));

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

        btnBrowseEvents.setBackground(new java.awt.Color(102, 255, 102));
        btnBrowseEvents.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBrowseEvents.setForeground(new java.awt.Color(51, 51, 51));
        btnBrowseEvents.setText("BROWSE EVENTS");
        btnBrowseEvents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBrowseEventsMouseClicked(evt);
            }
        });
        btnBrowseEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseEventsActionPerformed(evt);
            }
        });
        jPanel1.add(btnBrowseEvents, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 200, 48));

        btnMyBookings.setBackground(new java.awt.Color(204, 153, 255));
        btnMyBookings.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMyBookings.setForeground(new java.awt.Color(51, 51, 51));
        btnMyBookings.setText("MY BOOKINGS");
        btnMyBookings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMyBookingsMouseClicked(evt);
            }
        });
        btnMyBookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyBookingsActionPerformed(evt);
            }
        });
        jPanel1.add(btnMyBookings, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 200, 48));

        btnSubmitFeedback.setBackground(new java.awt.Color(51, 255, 255));
        btnSubmitFeedback.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSubmitFeedback.setForeground(new java.awt.Color(51, 51, 51));
        btnSubmitFeedback.setText("SUBMIT FEEDBACK");
        btnSubmitFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubmitFeedbackMouseClicked(evt);
            }
        });
        btnSubmitFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitFeedbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubmitFeedback, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 200, 48));

        btnProfile.setBackground(new java.awt.Color(255, 255, 153));
        btnProfile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnProfile.setForeground(new java.awt.Color(51, 51, 51));
        btnProfile.setText("PROFILE SETTINGS");
        btnProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProfileMouseClicked(evt);
            }
        });
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });
        jPanel1.add(btnProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 200, 48));

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Dashboard");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, 48));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("STUDENT");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 48));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 350, 670));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin Home.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int choice = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to logout?",
            "Confirm Logout",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        if (choice == JOptionPane.YES_OPTION) {
            UserSession.logout();
            new Login().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfileMouseClicked
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
    }//GEN-LAST:event_btnProfileMouseClicked

    private void btnSubmitFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitFeedbackActionPerformed
        //        if (UserSession.getUserId() == 0) {
            //            JOptionPane.showMessageDialog(this, "Please login first to give a Feedback.");
            //            return;
            //        }
        //        FeedbackForm feedbackForm = new FeedbackForm(UserSession.getUserId());
        //        feedbackForm.setVisible(true);
        ////        this.dispose();

        try {
            if (!UserSession.isLoggedIn()) {
                throw new Exception("Session expired. Please login again.");
            }

            FeedbackForm feedbackForm = new FeedbackForm(UserSession.getUserId());
            feedbackForm.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            handleError(e);
        }
    }//GEN-LAST:event_btnSubmitFeedbackActionPerformed

    private void btnSubmitFeedbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitFeedbackMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitFeedbackMouseClicked

    private void btnMyBookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyBookingsActionPerformed
        try {
            if (!UserSession.isLoggedIn()) {
                throw new Exception("Session expired. Please login again.");
            }

            // Check if user has any bookings
            if (!hasBookings(UserSession.getUserId())) {
                JOptionPane.showMessageDialog(this,
                    "You haven't registered for any events yet.",
                    "No Bookings",
                    JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            MyBookings myBookings = new MyBookings(UserSession.getUserId());
            myBookings.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            handleError(e);
        }
    }//GEN-LAST:event_btnMyBookingsActionPerformed

    private void btnMyBookingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyBookingsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMyBookingsMouseClicked

    private void btnBrowseEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseEventsActionPerformed
        try {
            BrowseEvents browseEvents = new BrowseEvents();
            browseEvents.setVisible(true);
            this.setVisible(false); // Hide current window
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error loading events: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBrowseEventsActionPerformed

    private void btnBrowseEventsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBrowseEventsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBrowseEventsMouseClicked

        private boolean hasBookings(int userId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM bookings WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
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
    private javax.swing.JButton btnBrowseEvents;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMyBookings;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnSubmitFeedback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
