/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        Connection con = ConnectionProvider.getCon();
        if (con != null) {
            System.out.println("Database Connected Successfully!");
        } else {
            System.out.println("Failed to Connect to Database.");
        }
    }
}

