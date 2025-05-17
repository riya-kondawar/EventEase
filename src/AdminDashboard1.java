
import javax.swing.*;
import java.awt.event.*;

public class AdminDashboard1 extends javax.swing.JFrame {

    public AdminDashboard1() {
        if (!UserSession.isAdmin()) {
            JOptionPane.showMessageDialog(this, "Access denied.");
            new Login().setVisible(true);
            dispose();
        } else {
            initComponents();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnCreateEvent = new javax.swing.JButton();
        btnManageEvent = new javax.swing.JButton();
        btnViewBookings = new javax.swing.JButton();
        btnFeedbackReport = new javax.swing.JButton();
        btnManageUsers = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Admin Dashboard");

        btnCreateEvent.setBackground(new java.awt.Color(0, 204, 102));
        btnCreateEvent.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCreateEvent.setForeground(new java.awt.Color(51, 51, 51));
        btnCreateEvent.setText("CREATE EVENT");
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

        btnManageEvent.setBackground(new java.awt.Color(0, 204, 102));
        btnManageEvent.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnManageEvent.setForeground(new java.awt.Color(51, 51, 51));
        btnManageEvent.setText("MANAGE EVENTS");
        btnManageEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManageEventMouseClicked(evt);
            }
        });
        btnManageEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEventActionPerformed(evt);
            }
        });

        btnViewBookings.setBackground(new java.awt.Color(0, 204, 102));
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

        btnFeedbackReport.setBackground(new java.awt.Color(0, 204, 102));
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

        btnManageUsers.setBackground(new java.awt.Color(0, 204, 102));
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

        btnLogout.setBackground(new java.awt.Color(0, 204, 102));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(469, 469, 469)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFeedbackReport, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnManageUsers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnViewBookings, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnManageEvent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(btnCreateEvent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(481, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(47, 47, 47)
                .addComponent(btnCreateEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnManageEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnViewBookings, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnManageUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFeedbackReport, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1260, 640));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin Home.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEventActionPerformed
        new EventList().setVisible(true);
        this.dispose(); // optional
    }//GEN-LAST:event_btnManageEventActionPerformed

    private void btnManageEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageEventMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManageEventMouseClicked

    private void btnCreateEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEventActionPerformed
        new ACreateEvent().setVisible(true);
        this.dispose(); // optional
    }//GEN-LAST:event_btnCreateEventActionPerformed

    private void btnCreateEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateEventMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateEventMouseClicked

    private void btnViewBookingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewBookingsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewBookingsMouseClicked

    private void btnViewBookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBookingsActionPerformed
        new BookingReport().setVisible(true);
        this.dispose(); // optional
    }//GEN-LAST:event_btnViewBookingsActionPerformed

    private void btnFeedbackReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeedbackReportMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFeedbackReportMouseClicked

    private void btnFeedbackReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedbackReportActionPerformed
        new FeedbackReport().setVisible(true);
        this.dispose(); // optional
    }//GEN-LAST:event_btnFeedbackReportActionPerformed

    private void btnManageUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageUsersMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManageUsersMouseClicked

    private void btnManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUsersActionPerformed
        new UserManagement().setVisible(true);
        this.dispose(); // optional
    }//GEN-LAST:event_btnManageUsersActionPerformed

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to logout?",
                "Confirm Logout",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (choice == JOptionPane.YES_OPTION) {
            UserSession.logout();
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(AdminDashboard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateEvent;
    private javax.swing.JButton btnFeedbackReport;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageEvent;
    private javax.swing.JButton btnManageUsers;
    private javax.swing.JButton btnViewBookings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
