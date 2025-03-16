/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package dao;
//import javax.swing.JOptionPane;
//import java.sql.*;
//
//public class DbOperations {
//    public static void setDataOrDelete(String Query, String msg){
//        try{
//            Connection con = ConnectionProvider.getCon();
//            Statement st = con.createStatement();
//            st.executeUpdate(Query);
//            if(!msg.equals(""))
//                JOptionPane.showMessageDialog(null, msg);
//        }
//        catch(Exception e){
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
//        }
//    };
//}



package dao;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.sql.*;

public class DbOperations {
    public static void setDataOrDelete(String query, String msg) {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            st.executeUpdate(query);
            if (!msg.equals("")) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, msg);
                });
            }
        } catch (Exception e) {
            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            });
            e.printStackTrace();
        }
    }
}
