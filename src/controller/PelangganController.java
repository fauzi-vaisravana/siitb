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
import model.Pelanggan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PelangganController {

    // CREATE: Tambah pelanggan baru
    public boolean tambahPelanggan(Pelanggan pelanggan) {
        String sql = "INSERT INTO pelanggan (kode_pelanggan, nama_pelanggan, alamat, no_telp) VALUES (?, ?, ?, ?)";

        try (Connection conn = koneksidatabase.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, pelanggan.getKodePelanggan());
            pst.setString(2, pelanggan.getNamaPelanggan());
            pst.setString(3, pelanggan.getAlamat());
            pst.setString(4, pelanggan.getNoTelp());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Menambah Pelanggan: " + e.getMessage());
            return false;
        }
    }

    // READ: Ambil semua data pelanggan
    public List<Pelanggan> getAllPelanggan() {
        List<Pelanggan> listPelanggan = new ArrayList<>();
        String sql = "SELECT * FROM pelanggan";

        try (Connection conn = koneksidatabase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pelanggan pelanggan = new Pelanggan(
                    rs.getString("kode_pelanggan"),
                    rs.getString("nama_pelanggan"),
                    rs.getString("alamat"),
                    rs.getString("no_telp")
                );
                listPelanggan.add(pelanggan);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Mengambil Data Pelanggan: " + e.getMessage());
        }

        return listPelanggan;
    }

    // UPDATE: Edit data pelanggan
    public boolean editPelanggan(Pelanggan pelanggan) {
        String sql = "UPDATE pelanggan SET nama_pelanggan = ?, alamat = ?, no_telp = ? WHERE kode_pelanggan = ?";

        try (Connection conn = koneksidatabase.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, pelanggan.getNamaPelanggan());
            pst.setString(2, pelanggan.getAlamat());
            pst.setString(3, pelanggan.getNoTelp());
            pst.setString(4, pelanggan.getKodePelanggan());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Mengedit Pelanggan: " + e.getMessage());
            return false;
        }
    }

    // DELETE: Hapus pelanggan berdasarkan kode_pelanggan
    public boolean hapusPelanggan(String kodePelanggan) {
        String sql = "DELETE FROM pelanggan WHERE kode_pelanggan = ?";

        try (Connection conn = koneksidatabase.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, kodePelanggan);
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Menghapus Pelanggan: " + e.getMessage());
            return false;
        }
    }
}
