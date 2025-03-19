/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Kelompok 2
 */
import koneksi.koneksidatabase;
import model.Users;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsersController {

    // CREATE: Tambah User Baru
    public boolean tambahUser(Users user) {
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
        
        try (Connection conn = koneksidatabase.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword()); // Pastikan password sudah di-hash jika perlu
            pst.setString(3, user.getRole());
            
            int rowsInserted = pst.executeUpdate();
            return rowsInserted > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Menambah User: " + e.getMessage());
            return false;
        }
    }

    // READ: Ambil Semua User
    public List<Users> getAllUsers() {
        List<Users> listUsers = new ArrayList<>();
        String sql = "SELECT * FROM users";
        
        try (Connection conn = koneksidatabase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Users user = new Users();
                user.setIdUser(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                listUsers.add(user);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Mengambil Data User: " + e.getMessage());
        }
        
        return listUsers;
    }

    // UPDATE: Edit Data User
    public boolean editUser(Users user) {
        String sql = "UPDATE users SET username = ?, password = ?, role = ? WHERE id_user = ?";
        
        try (Connection conn = koneksidatabase.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword()); // Hash password jika perlu
            pst.setString(3, user.getRole());
            pst.setInt(4, user.getIdUser());
            
            int rowsUpdated = pst.executeUpdate();
            return rowsUpdated > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Mengedit User: " + e.getMessage());
            return false;
        }
    }

    // DELETE: Hapus User
    public boolean hapusUser(int idUser) {
        String sql = "DELETE FROM users WHERE id_user = ?";
        
        try (Connection conn = koneksidatabase.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, idUser);
            int rowsDeleted = pst.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Menghapus User: " + e.getMessage());
            return false;
        }
    }

    // LOGIN: Verifikasi User
    public Users loginUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (Connection conn = koneksidatabase.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                Users user = new Users();
                user.setIdUser(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                user.setRole(rs.getString("role"));
                return user;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Login Gagal: " + e.getMessage());
        }
        
        return null;
    }
}
