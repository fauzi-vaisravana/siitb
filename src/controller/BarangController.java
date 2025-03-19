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
import model.Barang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BarangController {
    
    // CREATE: Tambah barang baru
    public boolean tambahBarang(Barang barang) {
        String sql = "INSERT INTO barang (kode_barang, nama_barang, harga, stok) VALUES (?, ?, ?, ?)";

        try (Connection conn = koneksidatabase.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Koneksi Database Gagal!");
                return false;
            }

            pst.setString(1, barang.getKodeBarang());
            pst.setString(2, barang.getNamaBarang());
            pst.setDouble(3, barang.getHarga());
            pst.setInt(4, barang.getStok());

            return pst.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Gagal Menambah Barang: " + e.getMessage());
            return false;
        }
    }
    
    // READ: Ambil semua data barang
    public List<Barang> getAllBarang() {
        List<Barang> listBarang = new ArrayList<>();
        String sql = "SELECT * FROM barang";

        try (Connection conn = koneksidatabase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Koneksi Database Gagal!");
                return listBarang;
            }

            while (rs.next()) {
                listBarang.add(new Barang(
                    rs.getString("kode_barang"),
                    rs.getString("nama_barang"),
                    rs.getInt("stok"),
                    rs.getDouble("harga")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Gagal Mengambil Data Barang: " + e.getMessage());
        }

        return listBarang;
    }
    
    // UPDATE: Edit data barang
    public boolean editBarang(Barang barang) {
        String sql = "UPDATE barang SET nama_barang = ?, harga = ?, stok = ? WHERE kode_barang = ?";

        try (Connection conn = koneksidatabase.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Koneksi Database Gagal!");
                return false;
            }

            pst.setString(1, barang.getNamaBarang());
            pst.setDouble(2, barang.getHarga());
            pst.setInt(3, barang.getStok());
            pst.setString(4, barang.getKodeBarang());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Gagal Mengedit Barang: " + e.getMessage());
            return false;
        }
    }
    
    // DELETE: Hapus barang berdasarkan kode_barang
    public boolean hapusBarang(String kodeBarang) {
        String sql = "DELETE FROM barang WHERE kode_barang = ?";

        try (Connection conn = koneksidatabase.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Koneksi Database Gagal!");
                return false;
            }

            pst.setString(1, kodeBarang);
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Gagal Menghapus Barang: " + e.getMessage());
            return false;
        }
    }
}

