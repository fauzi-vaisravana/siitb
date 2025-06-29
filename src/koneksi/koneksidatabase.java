/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fauzi
 */
public class koneksidatabase {
     public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/siitb_data_new";
            String user = "root"; // Sesuaikan dengan user XAMPP
            String password = ""; // Kosong jika default XAMPP
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
            return null;
        }
    }
}
